package br.com.fiap.geofauna.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BotaoLogin(
    text: String,
    icon: Painter,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(50.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8B5A2B)), // Cor marrom principal
        modifier = Modifier
            .shadow(6.dp, RoundedCornerShape(50.dp)) // Efeito de sombra
            .height(50.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {
            Text(
                text = text,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(end = 8.dp)
            )
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .background(Color(0xFFD77B42), CircleShape), // Cor laranja no lado direito
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = icon,
                    contentDescription = "Pata",
                    modifier = Modifier.size(40.dp)
                )
            }
        }
    }
}