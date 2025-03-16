package br.com.fiap.geofauna.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.geofauna.components.CaixaDeEntrada
import br.com.fiap.geofauna.model.Animal
import br.com.fiap.geofauna.model.PexelsResponse
import br.com.fiap.geofauna.model.Photos
import br.com.fiap.geofauna.service.PexelRetrofitFactory
import br.com.fiap.geofauna.service.RetrofitFactory
import coil.compose.rememberAsyncImagePainter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun SearchAnimalScreen(navController: NavController) {

    var searchAnimal by remember {
        mutableStateOf("")
    }

    var listAnimalState by remember {
        mutableStateOf(listOf<Animal>())
    }

    var listPhotoState by remember {
        mutableStateOf("")
    }


    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .background(Color.Gray)
                .fillMaxWidth()
        ) {
            CaixaDeEntrada(
                value = searchAnimal,
                onValueChange = { searchAnimal = it },
                label = "Nome do Animal",
                trailingIcon = {
                    IconButton(onClick = {
                        var call = RetrofitFactory().getAnimalService()
                            .getAnimalByName(animal = searchAnimal)
                        var photoCall = PexelRetrofitFactory().getPhotoAnimalService().getAnimalPhotos(query = searchAnimal)

                        //Primeira API
                        call.enqueue(object : Callback<List<Animal>> {
                            override fun onResponse(
                                call: Call<List<Animal>>,
                                response: Response<List<Animal>>
                            ) {
                                //Log.i("FIAP", "onResponse: ${response.body()} ")
                                //listAnimalState = response.body()!!
                                if (response.isSuccessful) {
                                    val animal = response.body() ?: emptyList()
                                    listAnimalState = response.body()!!
                                    if (animal.isNotEmpty()){

                                    }
                                }
//
                            }

                            override fun onFailure(call: Call<List<Animal>>, t: Throwable) {
                                Log.i("FIAP", "onResponse: ${t.message} ")

                            }

                        })
                        //Segunda API
//                        photoCall.enqueue(object : Callback<List<Photos>>{
//                            override fun onResponse(
//                                call: Call<List<Photos>>,
//                                response: Response<List<Photos>>
//                            ) {
//                                if (response.isSuccessful){
//                                    val photos = response.body() ?: emptyList()
//                                    if (photos.isNotEmpty()) {
//
//                                    }
//                                }
//                            }
//
//                            override fun onFailure(call: Call<List<Photos>>, t: Throwable) {
//                                TODO("Not yet implemented")
//                            }
//                        })
                    }
                    )
                   {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "")
                    }
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
        Box(modifier = Modifier
            .background(Color.Red)
            .height(300.dp) ){
            LazyColumn {
                items(listAnimalState){
                    CardAnimal(it)

                }
                items(listPhotoState.toInt()){
                   // AnimalPhoto(it)
                }

            }
        }

    }


}

@Composable
fun CardAnimal(animal: Animal) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = "Nome: ${animal.name}")
            Text(text = "Taxonomia: ${animal.taxonomy}")
            Text(text = "Localização: ${animal.locations}")
            Text(text = "Caracteristicas: ${animal.characteristics}")
            Spacer(modifier = Modifier.height(30.dp))

        }

    }
}
@Composable
fun AnimalPhoto(foto: PexelsResponse) {
    if (foto.photos.url.isNotEmpty()){
        Image(
            painter = rememberAsyncImagePainter(foto.photos.url),
            contentDescription = "Imagem do animal",
            modifier = Modifier.size(200.dp)
        )
    }
}


//IconButton(onClick = {
//    val scope = CoroutineScope(Dispatchers.IO) // Define a Thread de execução
//
//    scope.launch {
//        try {
//            // Chama as duas APIs em paralelo
//            val animalResponse = async { RetrofitFactory().getAnimalService().getAnimalByName(searchAnimal).execute() }
//            val photoResponse = async { PexelRetrofitFactory().getPhotoAnimalService().getAnimalPhotos(searchAnimal).execute() }
//
//            val animals = animalResponse.await().body() ?: emptyList()
//            val photo = photoResponse.await().body() ?: emptyList()
//
//            // Atualiza os estados na thread principal
//            withContext(Dispatchers.Main) {
//                listAnimalState = animals
//                photos = photo as List<PexelsResponse>
//            }
//
//        } catch (e: Exception) {
//            Log.e("FIAP", "Erro na requisição: ${e.message}")
//        }
//    }
//}
