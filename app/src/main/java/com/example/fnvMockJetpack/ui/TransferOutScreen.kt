package com.example.fnvMockJetpack.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fnvMockJetpack.components.SpinnerScreen
import com.example.fnvMockJetpack.ui.ui.theme.FnvMockJetpackTheme

@Composable
fun TransferOutScreen() {
    FnvMockJetpackTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val warehouseList = listOf("Warehouse 1", "Warehouse 2", "Warehouse 3")
            var selectedWarehouse by rememberSaveable() { mutableStateOf("") }
            var checkedState by rememberSaveable() { mutableStateOf(false)}
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                SpinnerScreen(
                    spinnerName = "Select Destination",
                    spinnerList = warehouseList,
                    selectedItem = selectedWarehouse,
                    onItemSelected = { selectedWarehouse = it }
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "Scan", fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
                    Switch(checked = checkedState, onCheckedChange = {checkedState = it})
                }
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(Color.Black),
                    shape = RectangleShape,
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Text(text = "Get Crate")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    TransferOutScreen()
}