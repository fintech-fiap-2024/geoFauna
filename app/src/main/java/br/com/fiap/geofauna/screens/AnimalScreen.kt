package br.com.fiap.geofauna.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.fiap.geofauna.model.AnimalViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import br.com.fiap.geofauna.components.AnimalInfo

@Composable
fun AnimalScreen(
    navController: NavHostController,
    viewModel: AnimalViewModel = viewModel()
) {
    val animalInfo by viewModel.animalInfo.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (isLoading) {
            CircularProgressIndicator()
        } else if (error != null) {
            Text(text = "Error: $error", color = Color.Red)
        } else if (animalInfo != null) {
            AnimalInfo(animalInfo!!)
        } else {
            Text("No data available")
        }
    }
}

//@Composable
//fun AnimalScreen(animalInfo: Animal) {
//    Column {
//        Text(text = "Scientific Name: ${animalInfo.scientificName}")
//        Text(text = "Kingdom: ${animalInfo.kingdom}")
//        Text(text = "Phylum: ${animalInfo.phylum}")
//        Text(text = "Order: ${animalInfo.order}")
//        Text(text = "Family: ${animalInfo.family}")
//        Text(text = "Genus: ${animalInfo.genus}")
//        Text(text = "Species: ${animalInfo.species}")
//        Text(text = "Habitat: ${animalInfo.habitat}")
//
//        val imageUrl = animalInfo.media.firstOrNull { it.type == "StillImage" }?.identifier
//        if (imageUrl != null) {
//            Image(
//                painter = rememberImagePainter(data = imageUrl),
//                contentDescription = "Animal Image",
//                modifier = Modifier
//                    .size(200.dp)
//                    .padding(8.dp)
//            )
//        }
//    }
//}

