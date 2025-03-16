package br.com.fiap.geofauna.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

    Column {
        // Exibe as informações da espécie
        Text(text = "Scientific Name: ${animalInfo.scientificName}")
        Text(text = "Kingdom: ${animalInfo.kingdom}")
        Text(text = "Phylum: ${animalInfo.phylum}")
        Text(text = "Order: ${animalInfo.order}")
        Text(text = "Family: ${animalInfo.family}")
        Text(text = "Genus: ${animalInfo.genus}")
        Text(text = "Species: ${animalInfo.species}")
        Text(text = "Habitat: ${animalInfo.habitat}")

        // Exibe a imagem do animal (se disponível)
        val imageUrl = animalInfo.media?.firstOrNull { it.type == "StillImage" }?.identifier
        if (imageUrl != null) {
            Image(
                painter = rememberImagePainter(data = imageUrl),
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