package br.com.fiap.geofauna

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.geofauna.ui.theme.GeoFaunaTheme

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import br.com.fiap.geofauna.components.BotaoLogin
import br.com.fiap.geofauna.ui.theme.Exo
import br.com.fiap.geofauna.ui.theme.GeoFaunaTheme
import br.com.fiap.geofauna.ui.theme.SourceSerif


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
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


@OptIn(ExperimentalMaterial3Api::class)
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
                .fillMaxSize()
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
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
                    .padding(16.dp)
                    .alpha(0.4f),
                shape = RoundedCornerShape(24.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)

            ) {
                Text(
                    text = "LOGIN",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    fontSize = 32.sp,
                    fontFamily = SourceSerif,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.tertiary_color)
                )
                OutlinedTextField(
                    value = login,
                    onValueChange = { login = it },
                    label = {
                        Text(
                            "Digite o login",
                            color = Color.Black,
                            fontFamily = Exo,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, end = 8.dp, bottom = 16.dp),

                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = Color.Black,
                        cursorColor = Color.Black,
                        focusedBorderColor = colorResource(id = R.color.secondary_color),
                        unfocusedBorderColor = colorResource(id = R.color.primary_color)
                    )
                )
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Digite a senha", color = Color.Black) },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, end = 8.dp, bottom = 8.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = Color.Black,
                        cursorColor = Color.Black,
                        focusedBorderColor = colorResource(id = R.color.secondary_color),
                        unfocusedBorderColor = colorResource(id = R.color.primary_color)
                    )
                )
                Text(
                    text = "Esqueci minha senha",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp, start = 8.dp)
                        .clickable {  },
                    fontSize = 16.sp,
                    fontFamily = Exo,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.gray)
                )
                BotaoLogin(
                    text = "Registrar",
                    icon = painterResource(id = R.drawable.patalaranja)
                ) {
                    // Ação ao clicar no botão
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