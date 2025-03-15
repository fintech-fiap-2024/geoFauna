package br.com.fiap.geofauna.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import br.com.fiap.geofauna.components.CaixaDeEntrada

@Composable
fun SearchAnimalScreen(navController: NavController) {

    var searchAnimal by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .background(Color.Gray)
            .fillMaxSize()
    ){
        CaixaDeEntrada(
            value = searchAnimal,
            onValueChange = { searchAnimal = it },
            label = "Nome do Animal",
            trailingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "")
                }
            }
        )
    }
}
