package com.pjsoftware.inkedupandroid.repository

import android.app.Application
import androidx.room.Room
import com.pjsoftware.inkedupandroid.api.StationaryService
import com.pjsoftware.inkedupandroid.db.StationaryDatabase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executors

class RepositoryApplication : Application() {

    lateinit var stationaryRepository: StationaryRepository

    override fun onCreate() {
        super.onCreate()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val stationaryService = retrofit.create<StationaryService>(StationaryService::class.java)

        val stationaryDatabase = Room.databaseBuilder(applicationContext,
            StationaryDatabase::class.java, "post-db").build()

        stationaryRepository = StationaryRepositoryImpl(
            stationaryService,
            stationaryDatabase.penDao(),
            stationaryDatabase.inkDao(),
            PenMapper(),
            InkMapper(),
            Executors.newSingleThreadExecutor()
        )
    }

}