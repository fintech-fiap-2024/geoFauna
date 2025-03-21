package br.com.fiap.geofauna.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.fiap.geofauna.components.AnimalInfo
import br.com.fiap.geofauna.model.Animal
import br.com.fiap.geofauna.model.AnimalViewModel
import br.com.fiap.geofauna.ui.theme.Exo

@Composable
fun AnimalScreen(viewModel: AnimalViewModel = viewModel(), modifier: Modifier) {
    val animalInfo by viewModel.animalInfo.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
    ) {
        if (isLoading) {
            CircularProgressIndicator()
        } else if (error != null) {
            Text(text = "Error: $error", color = Color.Red)
        } else if (animalInfo != null) {
            AnimalInfo(animalInfo)
        } else {
            Text(
                text = "Informação indisponível",
                color = Color.White,
                fontSize = 20.sp,
                fontFamily = Exo,
                fontWeight = FontWeight.Bold,
            )
        }

    }
}

@Composable
fun AnimalInfo(animalInfo: Animal?) {
    if (animalInfo == null) {
        Text("No animal information available")
        return
    }

    AnimalInfo(animalInfo)

}
