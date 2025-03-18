package br.com.fiap.geofauna.screens

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import br.com.fiap.geofauna.model.AnimalViewModel
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MapScreen(viewModel: AnimalViewModel = viewModel()) {
    val context = LocalContext.current
    val animalInfo by viewModel.animalInfo.collectAsState()

    // Define o tamanho do mapa (ajuste conforme necessário)
    val mapHeight = 500.dp
    val mapWidth = 400.dp

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título ou outro conteúdo acima do mapa
        Text(
            text = "Localização do Animal",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Box para delimitar o espaço do mapa
        Box(
            modifier = Modifier
                .height(mapHeight)
                .width(mapWidth)
                .clip(RoundedCornerShape(16.dp)) // Adiciona bordas arredondadas
                .background(Color.LightGray) // Cor de fundo da "caixa"
        ) {
            // MapView dentro da Box
            AndroidView(
                modifier = Modifier.fillMaxSize(),
                factory = { ctx ->
                    MapView(ctx).apply {
                        setTileSource(TileSourceFactory.MAPNIK) // Usa o mapa padrão do OpenStreetMap
                        Configuration.getInstance().userAgentValue = context.packageName

                        // Habilita controles de zoom e gestos de toque
                        setBuiltInZoomControls(false)
                        setMultiTouchControls(true)

                        // Configuração inicial do mapa
                        controller.setZoom(2.0) // Define um zoom inicial para mostrar o mundo inteiro
                        controller.setCenter(GeoPoint(0.0, 0.0)) // Centraliza o mapa no equador e meridiano de Greenwich

                        // Desativa a repetição de tiles
                        isHorizontalMapRepetitionEnabled = false
                        isVerticalMapRepetitionEnabled = false
                    }
                },
                update = { mapView ->
                    if (animalInfo != null) {
                        val latitude = animalInfo!!.decimalLatitude
                        val longitude = animalInfo!!.decimalLongitude

                        val startPoint = GeoPoint(latitude, longitude)
                        mapView.controller.setZoom(8.0) // Aumenta o zoom para focar na localização do animal
                        mapView.controller.setCenter(startPoint)

                        val marker = Marker(mapView)
                        marker.position = startPoint
                        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
                        mapView.overlays.add(marker)
                    }
                }
            )
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewMapScreen(){
    MapScreen()
}