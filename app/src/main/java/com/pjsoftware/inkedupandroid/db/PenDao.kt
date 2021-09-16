package com.pjsoftware.inkedupandroid.db

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface PenDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPens(pens: List<PenEntity>)

    @Query("SELECT * FROM pens")
    fun loadPens(): LiveData<List<PenEntity>>
}