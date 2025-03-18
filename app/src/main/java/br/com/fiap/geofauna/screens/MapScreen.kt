package br.com.fiap.geofauna.screens

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

    // Configuração do mapa
    AndroidView(
        modifier = Modifier.fillMaxSize().padding(8.dp),
        factory = { ctx ->
            MapView(ctx).apply {
                setTileSource(TileSourceFactory.MAPNIK) // Usa o mapa padrão do OpenStreetMap
                Configuration.getInstance().userAgentValue = context.packageName
                setMultiTouchControls(false) // Habilita controles de toque (zoom, rotação, etc.)
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
                mapView.controller.setZoom(8.0)
                mapView.controller.setCenter(startPoint)

                val marker = Marker(mapView)
                marker.position = startPoint
                marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
                mapView.overlays.add(marker)
            }
        }
    )
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewMapScreen(){
    MapScreen()
}