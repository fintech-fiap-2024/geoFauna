package br.com.fiap.geofauna

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.geofauna.model.AnimalViewModel
import br.com.fiap.geofauna.screens.AnimalScreen
import br.com.fiap.geofauna.screens.AnimalSearchScreen
import br.com.fiap.geofauna.screens.DashboardScreen
import br.com.fiap.geofauna.screens.LoginScreen
import br.com.fiap.geofauna.screens.MapScreen
import br.com.fiap.geofauna.screens.RegisterScreen
import br.com.fiap.geofauna.screens.SearchMapScreen
//import br.com.fiap.geofauna.screens.SearchAnimalScreen
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
                composable(route = "dashboard") { DashboardScreen(navController) }
                composable(route = "searchanimal") {
                    val viewModel: AnimalViewModel = viewModel()
                    AnimalSearchScreen(navController = navController, viewModel = viewModel)
                }
                composable("mapScreen") { SearchMapScreen(navController) }
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
