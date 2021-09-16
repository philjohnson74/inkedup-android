package com.pjsoftware.inkedupandroid.api

import com.google.gson.annotations.SerializedName

data class Ink(
    @SerializedName("manufacturer") val manufacturer: String,
    @SerializedName("color") val color: String
)
