package br.com.fiap.geofauna

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.geofauna.screens.LoginScreen
import br.com.fiap.geofauna.screens.RegisterScreen
import br.com.fiap.geofauna.ui.theme.GeoFaunaTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GeoFaunaTheme {
                Surface {

                }
            }
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "login") {
                composable(route = "login") { LoginScreen(navController) }
                composable(route = "register") { RegisterScreen(navController) }
            }
        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun LoginScreePreview() {
//    GeoFaunaTheme {
//        LoginScreen()
//    }
//}
