package com.example.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Persisted selected AI index
            var selectedAi by rememberSaveable { mutableStateOf(0) }
            val aiModels = listOf("Model A", "Model B", "Model C")

            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Aplikasi MyApp")
                Text(text = "AI yang dipilih: ${aiModels[selectedAi]}")

                Row(modifier = Modifier.padding(top = 8.dp)) {
                    aiModels.forEachIndexed { index, model ->
                        Button(
                            onClick = { selectedAi = index },
                            modifier = Modifier.padding(end = 8.dp)
                        ) {
                            Text(text = model)
                        }
                    }
                }
            }
        }
    }
}
