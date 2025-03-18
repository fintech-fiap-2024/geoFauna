package br.com.fiap.geofauna.model

data class Animal(
    val scientificName: String,
    val vernacularName: String?,
    val kingdom: String?,
    val phylum: String?,
    val order: String?,
    val family: String?,
    val species: String?,
    val media: List<Media> = emptyList(),  // Inicializa com uma lista vazia
    val decimalLatitude: Double,
    val decimalLongitude: Double
)

data class Media(
    val identifier: String,
    val type: String
)

data class SpeciesSearchResult(
    val key: Int, // speciesKey
    val scientificName: String,
    val canonicalName: String,
    val vernacularName: String?,
    val kingdom: String?,
    val phylum: String?,
    val order: String?,
    val family: String?,
    val genus: String?,
    val species: String?,
    val habitat: String?,
    val media: List<Media>? = emptyList() // Inicialize com uma lista vazia
)

data class SpeciesSearchResponse(
    val offset: Int,
    val limit: Int,
    val endOfRecords: Boolean,
    val count: Int,
    val results: List<SpeciesSearchResult>,
    val facets: List<Any> // Pode ser substituído por uma classe específica se houver facetas
)

data class AnimalSearchResponse(
    val results: List<AnimalResult>
)

data class AnimalResult(
    val scientificName: String,
    val vernacularName: String?,
    val kingdom: String?,
    val phylum: String?,
    val order: String?,
    val family: String?,
    val species: String?,
    val media: List<Media>?,
    val decimalLatitude: Double,
    val decimalLongitude: Double
)
