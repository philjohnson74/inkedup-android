package com.pjsoftware.inkedupandroid.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [PenEntity::class, InkEntity::class],
    version = 1
)
abstract class StationaryDatabase : RoomDatabase(){
    abstract fun penDao(): PenDao
    abstract fun inkDao(): InkDao
}