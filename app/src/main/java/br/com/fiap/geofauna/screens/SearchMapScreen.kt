package br.com.fiap.geofauna.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import br.com.fiap.geofauna.R
import br.com.fiap.geofauna.model.AnimalViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchMapScreen(
    navController: NavHostController,
    viewModel: AnimalViewModel = viewModel()
) {
    var query by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.primary_color))
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            // TextField no topo da tela
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                value = query,
                onValueChange = { query = it },
                label = { Text("Digite o nome científico") },
                trailingIcon = {
                    IconButton(
                        onClick = { viewModel.searchAnimalByScientificName(query) }
                    ) {
                        Icon(
                            painterResource(id = R.drawable.search_24),
                            contentDescription = "Ícone de busca"
                        )
                    }
                },
                colors = androidx.compose.material3.TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    focusedLabelColor = colorResource(id = R.color.secondary_color),
                    containerColor = Color.White,
                    focusedIndicatorColor = colorResource(id = R.color.tertiary_color),
                    unfocusedIndicatorColor = Color.Gray,
                    cursorColor = colorResource(id = R.color.secondary_color)
                )
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                MapScreen(viewModel = viewModel)
            }
        }
        Button(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.tertiary_color)
            ),
            shape = RectangleShape,
            onClick = { viewModel.searchAnimalByScientificName(query) }
        ) {
            Text(text = "Encontrar Animal")
        }
    }
}