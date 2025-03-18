package br.com.fiap.geofauna.components

import TextoCustomizado
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import br.com.fiap.geofauna.R
import br.com.fiap.geofauna.model.Animal
import br.com.fiap.geofauna.ui.theme.Exo
import coil.compose.rememberAsyncImagePainter

@Composable
fun AnimalInfo(animalInfo: Animal?) {
    if (animalInfo == null) {
        Text("Informações do animal indisponíveis")
        return
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
//            .background(colorResource(id = R.color.secondary_color))
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
    ) {
        // Exibe o nome científico
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
            colors = CardDefaults.cardColors(colorResource(id = R.color.secondary_color))
        ) {

            val kingdomNameNameText = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("Reino: ")
                }
                withStyle(style = SpanStyle(fontWeight = FontWeight.Medium)) {
                    append(animalInfo.kingdom!!)
                }
            }
            TextoCustomizado(
                text = kingdomNameNameText,
                modifier = Modifier.padding(6.dp),
                fontSize = 24,
                fontFamily = Exo,
                fontWeight =  FontWeight.Bold,
                color = Color.White
            )

            val phylumNameNameText = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("Filo: ")
                }
                withStyle(style = SpanStyle(fontWeight = FontWeight.Medium)) {
                    append(animalInfo.phylum!!)
                }
            }
            TextoCustomizado(
                text = phylumNameNameText,
                modifier = Modifier.padding(6.dp),
                fontSize = 20,
                fontFamily = Exo,
                fontWeight =  FontWeight.Bold,
                color = Color.White
            )

            val imageUrl = animalInfo.media.firstOrNull { it.type == "StillImage" }?.identifier
            if (imageUrl != null) {
                Image(
                    painter = rememberAsyncImagePainter(imageUrl),
                    contentDescription = "Animal Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .padding(top = 8.dp, bottom = 8.dp),
                    contentScale = ContentScale.Crop
                )
            } else {
                Text("Imagem indisponível")
            }

            if (!animalInfo.vernacularName.isNullOrEmpty()) {

                val vernacularNameNameText = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("Nome Comum: ")
                    }
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Medium)) {
                        append(animalInfo.vernacularName)
                    }
                }
                TextoCustomizado(
                    text = vernacularNameNameText,
                    modifier = Modifier.padding(6.dp),
                    fontSize = 20,
                    fontFamily = Exo,
                    fontWeight =  FontWeight.Bold,
                    color = Color.White
                )
            }
            val scientificNameText = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("Nome científico: ")
                }
                withStyle(style = SpanStyle(
                    fontWeight = FontWeight.Medium,
                    fontStyle = FontStyle.Italic
                )) {
                    append(animalInfo.scientificName)
                }
            }

            TextoCustomizado(
                text = scientificNameText, // Passa o AnnotatedString
                modifier = Modifier.padding(6.dp),
                fontSize = 20,
                fontFamily = Exo,
                color = Color.White
            )


            val orderNameText = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("Ordem: ")
                }
                withStyle(style = SpanStyle(fontWeight = FontWeight.Medium)) {
                    append(animalInfo.order!!)
                }
            }
            TextoCustomizado(
                text = orderNameText,
                modifier = Modifier.padding(6.dp),
                fontSize = 18,
                fontFamily = Exo,
                fontWeight =  FontWeight.Light,
                color = Color.White
            )


            val familyNameText = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("Familia: ")
                }
                withStyle(style = SpanStyle(fontWeight = FontWeight.Medium)) {
                    append(animalInfo.family!!)
                }
            }
            TextoCustomizado(
                text = familyNameText,
                modifier = Modifier.padding(6.dp),
                fontSize = 18,
                fontFamily = Exo,
                fontWeight =  FontWeight.Light,
                color = Color.White
            )


            val speciesNameText = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("Espécie: ")
                }
                withStyle(style = SpanStyle(fontWeight = FontWeight.Medium)) {
                    append(animalInfo.species!!)
                }
            }
            TextoCustomizado(
                text = speciesNameText,
                modifier = Modifier.padding(6.dp),
                fontSize = 18,
                fontFamily = Exo,
                fontWeight =  FontWeight.Light,
                color = Color.White
            )

        }
    }
}