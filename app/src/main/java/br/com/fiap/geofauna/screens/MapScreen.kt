package br.com.fiap.geofauna.screens

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
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.fiap.geofauna.model.AnimalViewModel
import br.com.fiap.geofauna.ui.theme.SourceSerif
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

@Composable
fun MapScreen(viewModel: AnimalViewModel = viewModel()) {
    val context = LocalContext.current
    val animalInfo by viewModel.animalInfo.collectAsState()
    val mapHeight = 500.dp
    val mapWidth = 400.dp

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Localização do Animal",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = SourceSerif,
            color = Color.White,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Box(
            modifier = Modifier
                .height(mapHeight)
                .width(mapWidth)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.LightGray)
        ) {
            AndroidView(
                modifier = Modifier.fillMaxSize(),
                factory = { ctx ->
                    MapView(ctx).apply {
                        setTileSource(TileSourceFactory.MAPNIK)
                        Configuration.getInstance().userAgentValue = context.packageName

                        setBuiltInZoomControls(false)
                        setMultiTouchControls(true)

                        controller.setZoom(2.0)
                        controller.setCenter(GeoPoint(0.0, 0.0))

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
    }
}
