package br.com.fiap.geofauna.components

import TextoCustomizado
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.fiap.geofauna.R
import br.com.fiap.geofauna.model.Animal
import br.com.fiap.geofauna.ui.theme.SourceSerif
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter

@Composable
fun AnimalInfo(animalInfo: Animal?) {
    if (animalInfo == null) {
        Text("Informações do animal indisponíveis")
        return
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(colorResource(id = R.color.secondary_color))
            .fillMaxWidth(),
    ) {
        // Exibe o nome científico
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            TextoCustomizado(
                text = "Reino: ${animalInfo.kingdom}",
                modifier = Modifier.padding(8.dp),
                fontSize = 24,
                fontFamily = SourceSerif,
                fontWeight =  FontWeight.Bold,
                color = colorResource(id = R.color.primary_color)
            )
            TextoCustomizado(
                text = "Filo: ${animalInfo.phylum}",
                modifier = Modifier.padding(8.dp),
                fontSize = 20,
                fontFamily = SourceSerif,
                fontWeight =  FontWeight.Bold,
                color = colorResource(id = R.color.primary_color)
            )

            val imageUrl = animalInfo.media.firstOrNull { it.type == "StillImage" }?.identifier
            if (imageUrl != null) {
                Image(
                    painter = rememberAsyncImagePainter(imageUrl),
                    contentDescription = "Animal Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp, bottom = 8.dp)
                )
            } else {
                Text("Imagem indisponível")
            }

            if (!animalInfo.vernacularName.isNullOrEmpty()) {
                TextoCustomizado(
                    text = "Nome comum: ${animalInfo.vernacularName}",
                    modifier = Modifier.padding(8.dp),
                    fontSize = 20,
                    fontFamily = SourceSerif,
                    fontWeight =  FontWeight.Bold,
                    color = colorResource(id = R.color.primary_color)
                )
            }
            TextoCustomizado(
                text = "Nome científico: ${animalInfo.scientificName}",
                modifier = Modifier.padding(8.dp),
                fontSize = 20,
                fontFamily = SourceSerif,
                fontWeight =  FontWeight.Medium,
                color = colorResource(id = R.color.primary_color)
            )
            TextoCustomizado(
                text = "Ordem: ${animalInfo.order}",
                modifier = Modifier.padding(8.dp),
                fontSize = 18,
                fontFamily = SourceSerif,
                fontWeight =  FontWeight.Light,
                color = colorResource(id = R.color.primary_color)
            )
            TextoCustomizado(
                text = "Família: ${animalInfo.family}",
                modifier = Modifier.padding(8.dp),
                fontSize = 18,
                fontFamily = SourceSerif,
                fontWeight =  FontWeight.Light,
                color = colorResource(id = R.color.primary_color)
            )
            TextoCustomizado(
                text = "Espécie: ${animalInfo.species}",
                modifier = Modifier.padding(8.dp),
                fontSize = 18,
                fontFamily = SourceSerif,
                fontWeight =  FontWeight.Light,
                color = colorResource(id = R.color.primary_color)
            )

        }
    }
}