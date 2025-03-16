package br.com.fiap.geofauna.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class PexelRetrofitFactory {
    private val retrofit = Retrofit
        .Builder()
        .baseUrl("https://api.pexels.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

   // val api: PexelsApi = retrofit.create(PexelsApi::class.java)

    fun getPhotoAnimalService(): PexelsApi {
        return retrofit.create(PexelsApi::class.java)
    }
}


