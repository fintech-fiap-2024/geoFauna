package br.com.fiap.geofauna.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.geofauna.model.AnimalViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimalSearchScreen(
    navController: NavHostController,
    viewModel: AnimalViewModel = viewModel()
) {
    var query by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = query,
            onValueChange = { query = it },
            label = { Text("Enter species name") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { viewModel.searchAnimalByScientificName(query) }) {
            Text("Search")
        }
        Spacer(modifier = Modifier.height(16.dp))
        AnimalScreen(viewModel = viewModel)
    }
}






//@Composable
//fun SearchAnimalScreen(navController: NavController) {
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
//}



