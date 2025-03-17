package br.com.fiap.geofauna.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.fiap.geofauna.model.Animal
import coil.compose.rememberImagePainter

@Composable
fun AnimalInfo(animalInfo: Animal?) {
    if (animalInfo == null) {
        Text("No animal information available")
        return
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Exibe as informações da espécie
        Text(text = "Scientific Name: ${animalInfo.scientificName}")

        // Exibe a imagem do animal (se disponível)
        val imageUrl = animalInfo.media.firstOrNull { it.type == "StillImage" }?.identifier
        if (imageUrl != null) {
            Image(
                painter = rememberImagePainter(imageUrl),
                contentDescription = "Animal Image",
                modifier = Modifier
                    .size(200.dp)
                    .padding(8.dp)
            )
        } else {
            Text("No image available")
        }
    }
}