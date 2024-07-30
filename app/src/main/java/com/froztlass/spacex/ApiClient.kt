package com.froztlass.spacex

//10121079
//Fa'i Refriandi
//IF-2 (PemAndro-3)

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASE_URL = "https://api.spacexdata.com/v3/"

    val instance: SpaceXApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(SpaceXApi::class.java)
    }
}
