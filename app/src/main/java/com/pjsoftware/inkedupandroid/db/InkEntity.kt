package com.pjsoftware.inkedupandroid.db

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "inks", primaryKeys = ["manufacturer", "color"])
data class InkEntity(
    @ColumnInfo(name = "manufacturer") val manufacturer: String,
    @ColumnInfo(name = "color") val color: String
)
