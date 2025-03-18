package br.com.fiap.geofauna.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import br.com.fiap.geofauna.R
import br.com.fiap.geofauna.model.AnimalViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimalSearchScreen(
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
            AnimalScreen(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                viewModel = viewModel
            )
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



