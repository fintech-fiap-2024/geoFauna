package br.com.fiap.geofauna.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.geofauna.R
import br.com.fiap.geofauna.ui.theme.Exo
import br.com.fiap.geofauna.ui.theme.SourceSerif


@Composable
fun SearchAnimalScreen(navController: NavController) {
    Column() {
        Text(
            text = "LOGIN",
            modifier = Modifier
                .fillMaxWidth(),
            fontSize = 32.sp,
            fontFamily = SourceSerif,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = colorResource(id = R.color.gray)
        )
    }
}