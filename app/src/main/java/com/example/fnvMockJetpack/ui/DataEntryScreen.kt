package com.example.fnvMockJetpack.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fnvMockJetpack.ui.theme.FnvMockJetpackTheme
import java.text.SimpleDateFormat
import java.util.*

@Composable

    fun DataEntryScreen(
        crateId: String,
        timestamp: String,
        supplier : String,
        Sku : String

    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            var supplierText by remember { mutableStateOf("") }
            var skuText by remember { mutableStateOf("") }
            var weightText by remember { mutableStateOf("") }
            var temperatureText by remember { mutableStateOf("") }
            var HumidityText by remember { mutableStateOf("") }
            var timestampmutable by remember { mutableStateOf("") }
            var crateittampmutable by remember { mutableStateOf("") }

            OutlinedTextField(
                value = "",
                enabled = false,
                onValueChange = { crateittampmutable = it },
                label = { Text("$crateId") },
                modifier = Modifier.padding(bottom = 8.dp)

            )

            OutlinedTextField(
                value = "",
                enabled = false,
                onValueChange = { timestampmutable = it },
                label = { Text("$timestamp") },
                modifier = Modifier.padding(bottom = 8.dp)

            )


            OutlinedTextField(
                value = "",
                enabled = false,
                onValueChange = { supplierText = it },
                label = { Text("$supplier") },
                modifier = Modifier.padding(bottom = 8.dp)

            )
            OutlinedTextField(
                value = "",
                enabled = false,
                onValueChange = { supplierText = it },
                label = { Text("$Sku") },
                modifier = Modifier.padding(bottom = 8.dp)

            )
            OutlinedTextField(
                value = weightText,
                onValueChange = { weightText = it },
                label = { Text("Weight") },
                modifier = Modifier.padding(bottom = 8.dp)
            )
            OutlinedTextField(
                value = temperatureText,
                onValueChange = { temperatureText = it },
                label = { Text("Temperature") },
                modifier = Modifier.padding(bottom = 8.dp)
            )
            OutlinedTextField(
                value = HumidityText,
                onValueChange = { HumidityText = it },
                label = { Text("Humidity") },
                modifier = Modifier.padding(bottom = 32.dp))
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Submit")
            }
        }
    }

@Preview(showBackground = true)
@Composable
fun SimpleComposablePreview() {
    FnvMockJetpackTheme {



        val time: String = SimpleDateFormat("HH-mm-ss").format(Date())
        DataEntryScreen("itemId-45545",time,"Supplier 1","SKU 1")

    }
}