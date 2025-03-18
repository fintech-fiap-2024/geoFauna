package br.com.fiap.geofauna.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import br.com.fiap.geofauna.R
import br.com.fiap.geofauna.components.CardCustomizado


@Composable
fun DashboardScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = colorResource(id = R.color.primary_color)),
    ) {
        Box() {
            Image(
                modifier = Modifier
                    .width(76.dp)
                    .height(120.dp)
                    .zIndex(1F)
                    .padding(top = 16.dp)
                    .align(Alignment.TopCenter),
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Geo Fauna logo",
                contentScale = ContentScale.Crop,
            )
            Image(
                painter = painterResource(id = R.drawable.dash_logo),
                contentDescription = "Animais na floresta",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
        ) {
            CardCustomizado(
                title = "Buscar por animal",
                icon = painterResource(id = R.drawable.search_24),
                description = "Você pode buscar por um animal específico e saber mais sobre ele, além de seu habitat.",
                buttonText = "Pesquisar",
                onButtonClick = { navController.navigate("searchanimal") }
            )
            Divider(
                color = colorResource(id = R.color.gray),
                thickness = 1.dp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            CardCustomizado(
                title = "Buscar por região",
                icon = painterResource(id = R.drawable.map_24),
                description = "Você pode visualizar o mapa e os animais mais comuns de cada região.",
                buttonText = "Abrir mapa",
                onButtonClick = { navController.navigate("mapScreen") }
            )
        }
    }
}
