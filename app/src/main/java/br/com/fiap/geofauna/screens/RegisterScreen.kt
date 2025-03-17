package br.com.fiap.geofauna.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import br.com.fiap.geofauna.R
import br.com.fiap.geofauna.components.BotaoCustomizado
import br.com.fiap.geofauna.components.CaixaDeEntrada
import br.com.fiap.geofauna.database.repository.UsuarioRepository
import br.com.fiap.geofauna.model.Usuario
import br.com.fiap.geofauna.ui.theme.SourceSerif

@Composable
fun RegisterScreen(navController: NavController) {

    val context = LocalContext.current
    val usuarioRepository = UsuarioRepository(context)

    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var celular by remember { mutableStateOf("") }

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
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .width(160.dp)
                    .height(144.dp)
                    .offset(x = 82.dp, y = 120.dp)
                    .zIndex(1f),
                painter = painterResource(id = R.drawable.bird),
                contentDescription = "Geo Fauna logo",
                contentScale = ContentScale.Crop
            )
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.primary_color).copy(alpha = 0.7f))
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 42.dp)
                ) {
                    IconButton(
                        onClick = { navController.navigate("login") }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Ícone voltar",
                            tint = Color.White
                        )
                    }
                    Text(
                        text = "REGISTRAR",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 8.dp),
                        fontSize = 32.sp,
                        fontFamily = SourceSerif,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.End,
                        color = colorResource(id = R.color.gray)
                    )
                }
                CaixaDeEntrada(
                    value = login,
                    label = "Digite o login",
                    onValueChange = { login = it },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Filled.AccountCircle,
                            contentDescription = "Ícone usuário",
                            tint = Color.White
                        )
                    }
                )
                CaixaDeEntrada(
                    value = password,
                    label = "Digite a senha",
                    onValueChange = { password = it },
                    trailingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.key_24),
                            contentDescription = "Ícone senha",
                            tint = Color.White
                        )
                    }
                )
                CaixaDeEntrada(
                    value = email,
                    label = "Digite o email",
                    onValueChange = { email = it },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Email,
                            contentDescription = "Ícone e-mail",
                            tint = Color.White
                        )
                    }
                )
                CaixaDeEntrada(
                    value = celular,
                    label = "Digite o celular",
                    onValueChange = { celular = it },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Phone,
                            contentDescription = "Ícone celular",
                            tint = Color.White
                        )
                    }
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    BotaoCustomizado(
                        text = "Registrar",
                        icon = painterResource(id = R.drawable.pata_laranja),
                        backgroundColor = colorResource(id = R.color.tertiary_color),
                        onClick = {
                            val usuario = Usuario(
                                id = 0,
                                login = login,
                                senha = password,
                                telefone = celular,
                                email = email
                            )

                            usuarioRepository.cadastrar(usuario)
                        }
                    )
                }
            }
        }
    }
}