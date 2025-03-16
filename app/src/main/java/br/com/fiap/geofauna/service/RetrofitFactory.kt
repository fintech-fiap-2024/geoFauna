package br.com.fiap.geofauna.service

import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {



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
}