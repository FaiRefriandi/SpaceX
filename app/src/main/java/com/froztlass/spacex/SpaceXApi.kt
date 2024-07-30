package com.froztlass.spacex
//10121079
//Fa'i Refriandi
//IF-2 (PemAndro-3)

import retrofit2.Call
import retrofit2.http.GET

interface SpaceXApi {
    @GET("launches")
    fun getLaunches(): Call<List<Launch>>
}
