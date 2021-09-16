package com.pjsoftware.inkedupandroid.db

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "pens", primaryKeys = ["manufacturer", "model"])
data class PenEntity(
    @ColumnInfo(name = "manufacturer") val manufacturer: String,
    @ColumnInfo(name = "model") val model: String,
    @ColumnInfo(name = "ink") val ink: String
)
