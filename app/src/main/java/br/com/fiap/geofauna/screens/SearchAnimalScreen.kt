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
//
//    var searchAnimal by remember {
//        mutableStateOf("")
//    }
//
//    var listAnimalState by remember {
//        mutableStateOf("Animal")
//    }
//
//
//    Column(modifier = Modifier.fillMaxSize()) {
//        Box(
//            modifier = Modifier
//                .background(Color.Gray)
//                .fillMaxWidth()
//        ) {
//            CaixaDeEntrada(
//                value = searchAnimal,
//                onValueChange = { searchAnimal = it },
//                label = "Nome do Animal",
//                trailingIcon = {
//                    IconButton(onClick = {
//                        var call = RetrofitFactory().getAnimalService().getSpeciesInfo(speciesKey = searchAnimal)
//
//                        //Primeira API
//                        call.enqueue(object : Callback<List<Animal>> {
//                            override fun onResponse(
//                                call: Call<List<Animal>>,
//                                response: Response<List<Animal>>
//                            ) {
//                                //Log.i("FIAP", "onResponse: ${response.body()} ")
//                                listAnimalState = response.body()!!
//
//                            }
//
//                            override fun onFailure(call: Call<List<Animal>>, t: Throwable) {
//                                Log.i("FIAP", "onResponse: ${t.message} ")
//
//                            }
//
//                        })
//                    }
//                    )
//                   {
//                        Icon(imageVector = Icons.Default.Search, contentDescription = "")
//                    }
//                }
//            )
//            Spacer(modifier = Modifier.height(10.dp))
//        }
//        Box(modifier = Modifier
//            .background(Color.Red)
//            .height(300.dp) ){
//            LazyColumn {
//                items(listAnimalState){
//                    CardAnimal(it)
//
//                }
//
//            }
//        }
//
//    }
//
//
}



