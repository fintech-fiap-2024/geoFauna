package br.com.fiap.geofauna

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.geofauna.components.BotaoCustomizado
import br.com.fiap.geofauna.components.CaixaDeEntrada
import br.com.fiap.geofauna.ui.theme.Exo
import br.com.fiap.geofauna.ui.theme.GeoFaunaTheme
import br.com.fiap.geofauna.ui.theme.SourceSerif


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GeoFaunaTheme {
                Surface {
                    LoginScreen()
                }
            }
            LoginScreen()
        }
    }
}

@Composable
fun LoginScreen() {
    var login by remember { mutableStateOf("")}
    var password by remember { mutableStateOf("")}

    Box(modifier = Modifier.fillMaxSize()){
        //background image
        Image(
            painter = painterResource(id= R.drawable.background_image),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column (
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .width(180.dp)
                    .height(260.dp),
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Geo Fauna logo",
                contentScale = ContentScale.Crop
            )
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.primary_color).copy(alpha = 0.5f))
            ) {
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
                CaixaDeEntrada(
                    value = login,
                    label = "Digite o Login",
                    onValueChange = { login = it }
                )
                CaixaDeEntrada(
                    value = password,
                    label = "Digite a senha",
                    onValueChange = { password = it }
                )
                Text(
                    text = "Esqueci minha senha",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp, end = 8.dp)
                        .clickable { }
                        .wrapContentWidth(Alignment.End),
                    fontSize = 16.sp,
                    fontFamily = Exo,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.gray)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    BotaoCustomizado(
                        text = "Entrar",
                        icon = painterResource(id = R.drawable.pata_verde),
                        backgroundColor = colorResource(id = R.color.secondary_color),
                        iconBackgroundColor = Color(0xFFD6864A), // Laranja
                        onClick = {  }
                    )
                    BotaoCustomizado(
                        text = "Registrar",
                        icon = painterResource(id = R.drawable.pata_laranja),
                        backgroundColor = colorResource(id = R.color.tertiary_color),
                        iconBackgroundColor = Color(0xFFD6864A),
                        onClick = {  }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreePreview() {
    GeoFaunaTheme {
        LoginScreen()
    }
}
