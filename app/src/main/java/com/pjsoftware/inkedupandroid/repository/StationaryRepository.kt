package com.pjsoftware.inkedupandroid.repository

import androidx.lifecycle.LiveData
import com.pjsoftware.inkedupandroid.db.InkEntity
import com.pjsoftware.inkedupandroid.db.PenEntity

interface StationaryRepository {
    fun getPens(): LiveData<List<PenEntity>>
    fun getInks(): LiveData<List<InkEntity>>
}