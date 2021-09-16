package com.pjsoftware.inkedupandroid.api

import com.google.gson.annotations.SerializedName

data class Pen(
    @SerializedName("manufacturer") val manufacturer: String,
    @SerializedName("model") val model: String,
    @SerializedName("ink") val ink: String
)
