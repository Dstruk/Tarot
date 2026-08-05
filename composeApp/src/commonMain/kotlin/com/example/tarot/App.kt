package com.example.tarot

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    var username by remember { mutableStateOf("") }
    var selectedCard by remember { mutableStateOf<TarotCard?>(null) }

    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF121212)) // Fondo oscuro místico
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "TAROT INTERACTIVO",
                color = Color(0xFFFFD700), // Dorado
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
            
            Spacer(modifier = Modifier.height(24.dp))

            TextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Nombre del Usuario (TikTok)") },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Color(0xFFFFD700),
                    textColor = Color.Black
                ),
                modifier = Modifier.fillMaxWidth(0.8f)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (username.isNotBlank()) {
                        selectedCard = TarotEngine.getCardForUser(username)
                    }
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFFFD700)),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("LEER DESTINO", color = Color.Black)
            }

            Spacer(modifier = Modifier.height(32.dp))

            selectedCard?.let { card ->
                Card(
                    elevation = 10.dp,
                    backgroundColor = Color(0xFF1E1E1E),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.fillMaxWidth(0.9f)
                ) {
                    Column(
                        modifier = Modifier.padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = card.name,
                            color = Color(0xFFFFD700),
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Arcano ${card.arcana}",
                            color = Color.Gray,
                            fontSize = 14.sp
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = card.meaningGeneral,
                            color = Color.White,
                            fontSize = 18.sp,
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Energía: ${card.energy}",
                            color = if (card.energy == "Positiva") Color.Green else if (card.energy == "Negativa") Color.Red else Color.Cyan,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}
