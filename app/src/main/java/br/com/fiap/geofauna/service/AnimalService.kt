package br.com.fiap.geofauna.service

import br.com.fiap.geofauna.model.Animal
import br.com.fiap.geofauna.model.AnimalSearchResponse
import br.com.fiap.geofauna.model.SpeciesSearchResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AnimalService {
    @GET("species/search")
    suspend fun searchSpecies(@Query("q") query: String): SpeciesSearchResponse

    @GET("species/{speciesKey}")
    suspend fun getSpeciesInfo(@Path("speciesKey") speciesKey: Int): Animal

    @GET("occurrence/search")
    suspend fun searchAnimalByScientificName(
        @Query("scientificName") scientificName: String,
        @Query("limit") limit: Int = 1,
        @Query("sort") sort: String = "eventDate"
    ): AnimalSearchResponse
}

