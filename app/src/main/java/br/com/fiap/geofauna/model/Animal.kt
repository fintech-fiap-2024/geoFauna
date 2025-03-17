package br.com.fiap.geofauna.model

data class Animal(
    val scientificName: String,
    val media: List<Media> = emptyList()  // Inicializa com uma lista vazia
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
    val media: List<Media>?
)



//data class Animal(
//    val name: String,
//    val taxonomy: Taxonomy,
//    val locations: ArrayList<String>,
//    val characteristics: Characteristics
//)
//
//data class Taxonomy(
//    val kingdom: String,
//    val phylum: String,
//    @SerializedName("class")val class_: String,  // 'class' é uma palavra reservada no Kotlin, então usamos 'class_'
//    val order: String,
//    val family: String
//)
//
//data class Characteristics(
//    val prey: String,
//    val name_of_young: String,
//    val group_behavior: String,
//    val estimated_population_size: String,
//    val biggest_threat: String,
//    val most_distinctive_feature: String,
//    val gestation_period: String,
//    val habiat: String,
//    val diet: String,
//    val average_little_size: String,
//    val lifestyle: String,
//    val common_name: String,
//    val number_of_species: String,
//    val location: String,
//    val slogan: String,
//    val group: String,
//    val color: String,
//    val skin_type: String,
//    val top_speed: String,
//    val lifespan: String,
//    val weight: String,
//    val height: String,
//    val age_of_sexual_maturity: String,
//    val age_of_weaning: String,
//)