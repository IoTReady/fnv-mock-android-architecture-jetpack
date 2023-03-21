package com.example.fnvMockJetpack.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fnvMockJetpack.components.SearchBarFilter
import com.example.fnvMockJetpack.ui.theme.FnvMockJetpackTheme
import java.text.SimpleDateFormat
import java.util.*



@Composable

fun SupplierSummaryScreen(
    supplier: String,
    No_Of_Crates : String,
    Total_Weigts: String,
    NO_Of_Sku : String,


    ) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp, 75.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

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
            label = { Text("$supplier") },
            modifier = Modifier.padding(bottom = 8.dp)

        )
        Row(Modifier) {
            Text(text = "SKU",Modifier.padding(40.dp,13.dp))
            var searchClicked by remember { mutableStateOf(false) }
            IconButton(
                onClick = { searchClicked = !searchClicked },
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search"
                )
            }
            if (searchClicked) {
                var selectedItem by remember { mutableStateOf("") }
                SearchBarFilter(
                    items = listOf("Supplier 1", "Supplier 2", "Supplier 3"),
                    onItemSelected = {
                        selectedItem = it
                        searchClicked = false
                    }
                )
            }

        }

        OutlinedTextField(
            value = "",
            enabled = false,
            onValueChange = { timestampmutable = it },
            label = { Text("$No_Of_Crates") },
            modifier = Modifier.padding(bottom = 8.dp)

        )


        OutlinedTextField(
            value = "",
            enabled = false,
            onValueChange = { supplierText = it },
            label = { Text("$Total_Weigts") },
            modifier = Modifier.padding(bottom = 8.dp)

        )
        OutlinedTextField(
            value = "",
            enabled = false,
            onValueChange = { supplierText = it },
            label = { Text("$NO_Of_Sku") },
            modifier = Modifier.padding(bottom = 8.dp)

        )
Row(modifier = Modifier) {

    Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(15.dp)) {
        Text(text = "Add Item")
    }
    Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(15.dp)) {
        Text(text = "Complete")
    }
    
}
    }
}

@Preview(showBackground = true)
@Composable
fun suppliersummaryPreview() {
    FnvMockJetpackTheme {



        SupplierSummaryScreen("Supplier 1","25","250","3")

    }
}