package com.example.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AiSelectionScreen()
                }
            }
        }
    }
}

@Composable
fun AiSelectionScreen() {
    var selectedAi by rememberSaveable { mutableStateOf("Default AI") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "AI Terpilih: $selectedAi",
            style = MaterialTheme.typography.headlineMedium
        )
        
        Spacer(modifier = Modifier.height(24.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(onClick = { selectedAi = "Gemini" }) {
                Text("Gemini")
            }
            Button(onClick = { selectedAi = "GPT-4" }) {
                Text("GPT-4")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { selectedAi = "Otomatis (Auto)" },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Aktifkan Pemilihan Otomatis")
        }
    }
}
