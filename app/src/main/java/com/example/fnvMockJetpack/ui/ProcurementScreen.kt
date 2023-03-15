package com.example.fnvMockJetpack.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fnvMockJetpack.components.SpinnerScreen
import com.example.fnvMockJetpack.ui.ui.theme.FnvMockJetpackTheme

class ProcurementScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FnvMockJetpackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // TODO: setting the data in the ui, probably have to change
                    val supplierList = listOf("Supplier 1", "Supplier 2", "Supplier 3")
                    val skuList = listOf("SKU 1", "SKU 2", "SKU 3")

                    var selectedSupplier by rememberSaveable() { mutableStateOf("") }
                    var selectedSKU by rememberSaveable() { mutableStateOf("") }

                    Column(modifier = Modifier.padding(16.dp)) {
                        SpinnerScreen(
                            spinnerName = "Supplier",
                            spinnerList = supplierList,
                            selectedItem = selectedSupplier
                        ) {
                            selectedSupplier = it
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        SpinnerScreen(
                            spinnerName = "SKU",
                            spinnerList = skuList,
                            selectedItem = selectedSKU
                        ) {
                            selectedSKU = it
                        }
                        OutlinedButton(
                            onClick = {  },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp, vertical = 24.dp)
                        ) {
                            Text(text = "Complete Activity")
                        }
                    }
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true, showSystemUi = false)
@Composable
fun DefaultPreview() {
    FnvMockJetpackTheme {
        // TODO: setting the data in the ui, probably have to change
        val supplierList = listOf("Supplier 1", "Supplier 2", "Supplier 3")
        val skuList = listOf("SKU 1", "SKU 2", "SKU 3")

        var selectedSupplier by rememberSaveable() { mutableStateOf("") }
        var selectedSKU by rememberSaveable() { mutableStateOf("") }

        Column(modifier = Modifier.padding(16.dp)) {
            SpinnerScreen(
                spinnerName = "Supplier",
                spinnerList = supplierList,
                selectedItem = selectedSupplier
            ) {
                selectedSupplier = it
            }
            Spacer(modifier = Modifier.height(16.dp))
            SpinnerScreen(
                spinnerName = "SKU",
                spinnerList = skuList,
                selectedItem = selectedSKU
            ) {
                selectedSKU = it
            }
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(Color.Black),
                shape = RectangleShape,
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(text = "Complete Activity")
            }
        }
    }
}
