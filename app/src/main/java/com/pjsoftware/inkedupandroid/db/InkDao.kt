package com.pjsoftware.inkedupandroid.db

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface InkDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertInks(inks: List<InkEntity>)

    @Query("SELECT * FROM inks")
    fun loadInks(): LiveData<List<InkEntity>>
}