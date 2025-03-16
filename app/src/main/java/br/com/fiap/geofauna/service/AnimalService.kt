package br.com.fiap.geofauna.service


import br.com.fiap.geofauna.model.SpeciesSearchResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface AnimalService {
    abstract val media: Any
    abstract val habitat: String
    abstract val species: String
    abstract val genus: String
    abstract val family: String
    abstract val order: String
    abstract val phylum: String
    abstract val scientificName: String
    abstract val kingdom: String

    @GET("species/search")
    suspend fun searchSpecies(@Query("q") query: String): SpeciesSearchResponse

    @GET("species/{speciesKey}")
    suspend fun getSpeciesInfo(@Path("speciesKey") speciesKey: Int): AnimalService
}


//interface AnimalService {

//    @GET("species/{speciesKey}")
//    fun getSpeciesInfo(@Path("speciesKey") speciesKey: Int): Animal

//    @GET("animals")
//    fun getAnimalByName(@Query("name") animal: String): Call<List<Animal>>
//}

