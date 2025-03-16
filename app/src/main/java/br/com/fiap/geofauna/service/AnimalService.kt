package br.com.fiap.geofauna.service

import br.com.fiap.geofauna.model.Animal
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface AnimalService {
    //https://api.api-ninjas.com/v1/animals

    //https://api.api-ninjas.com/v1/animals?name=cheetah
    @GET("animals")
    fun getAnimalByName(@Query("name") animal: String): Call<List<Animal>>

    //suspend fun getAnimalByName(@Header("Authorization") apiKey: String): Call<Animal>

    //val response = api.getDados("Bearer SUA_API_KEY_AQUI")
}

