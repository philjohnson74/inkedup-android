package com.pjsoftware.inkedupandroid.api

import retrofit2.Call
import retrofit2.http.GET

interface StationaryService {
    @GET("Pens")
    fun getPens(): Call<List<Pen>>

    @GET("Inks")
    fun getInks(): Call<List<Ink>>
}