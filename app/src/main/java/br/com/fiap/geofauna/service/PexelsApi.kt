package br.com.fiap.geofauna.service

import br.com.fiap.geofauna.model.PexelsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface PexelsApi {
    @Headers("Authorization: 1il8YlZ7SFNDQgmopQs2eBsvnjXXDsCMRMCq5ax5Y9eQ77ROrvqj9cmY")
    @GET("v1/search")
    fun getAnimalPhotos(@Query("query") query: String = "animal"): Call<ArrayList<PexelsResponse>>
}
