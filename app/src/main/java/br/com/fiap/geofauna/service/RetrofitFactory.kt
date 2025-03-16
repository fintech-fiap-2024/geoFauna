package br.com.fiap.geofauna.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://api.gbif.org/v1/"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: AnimalService by lazy {
        retrofit.create(AnimalService::class.java)
    }
}



//class RetrofitFactory {



//ANTIGO
//    private val BASE_URL = "https://api.api-ninjas.com/v1/"
//
//    private val apiKeyInterceptor = Interceptor { chain ->
//        val request = chain.request().newBuilder()
//            .addHeader("X-Api-Key", "UyIVZXcFXnhtBS4vjFsCBg==37YVw8ukeoLJvZNn")
//            .build()
//        chain.proceed(request)
//    }
//
//    private val client = OkHttpClient.Builder()
//        .addInterceptor(apiKeyInterceptor)
//        .build()
//
//    private val retrofitFactory = Retrofit
//        .Builder()
//        .baseUrl(BASE_URL)
//        .addConverterFactory(GsonConverterFactory.create())
//        .client(client)
//        .build()
//
//    fun getAnimalService(): AnimalService {
//        return retrofitFactory.create(AnimalService::class.java)
//    }
//}