package br.com.fiap.geofauna.service

import br.com.fiap.geofauna.model.Animal
import br.com.fiap.geofauna.model.SpeciesSearchResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AnimalService {
    @GET("species/search")
    suspend fun searchSpecies(@Query("q") query: String): SpeciesSearchResponse

    @GET("species/{speciesKey}")
    suspend fun getSpeciesInfo(@Path("speciesKey") speciesKey: Int): Animal
}


//interface AnimalService {

//    @GET("species/{speciesKey}")
//    fun getSpeciesInfo(@Path("speciesKey") speciesKey: Int): Animal

//    @GET("animals")
//    fun getAnimalByName(@Query("name") animal: String): Call<List<Animal>>
//}

