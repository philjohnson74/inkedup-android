package com.pjsoftware.inkedupandroid.repository

import androidx.lifecycle.LiveData
import com.pjsoftware.inkedupandroid.api.Ink
import com.pjsoftware.inkedupandroid.api.Pen
import com.pjsoftware.inkedupandroid.api.StationaryService
import com.pjsoftware.inkedupandroid.db.InkDao
import com.pjsoftware.inkedupandroid.db.InkEntity
import com.pjsoftware.inkedupandroid.db.PenDao
import com.pjsoftware.inkedupandroid.db.PenEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.Executor

class StationaryRepositoryImpl (
    private val stationaryService: StationaryService,
    private val penDao: PenDao,
    private val inkDao: InkDao,
    private val penMapper: PenMapper,
    private val inkMapper: InkMapper,
    private val executor: Executor
) : StationaryRepository {
    override fun getPens(): LiveData<List<PenEntity>> {
        stationaryService.getPens().enqueue(object : Callback<List<Pen>> {
            override fun onFailure(call: Call<List<Pen>>, t: Throwable) {
            }

            override fun onResponse(call: Call<List<Pen>>, response: Response<List<Pen>>) {
                response.body()?.let { pens ->
                    executor.execute {
                        penDao.insertPens(pens.map { pen ->
                            penMapper.serviceToEntity(pen)
                        })
                    }
                }
            }
        })
        return penDao.loadPens()
    }

    override fun getInks(): LiveData<List<InkEntity>> {
        stationaryService.getInks().enqueue(object : Callback<List<Ink>> {
            override fun onFailure(call: Call<List<Ink>>, t: Throwable) {
            }

            override fun onResponse(call: Call<List<Ink>>, response: Response<List<Ink>>) {
                response.body()?.let { inks ->
                    executor.execute {
                        inkDao.insertInks(inks.map { ink ->
                            inkMapper.serviceToEntity(ink)
                        })
                    }
                }
            }
        })
        return inkDao.loadInks()
    }
}