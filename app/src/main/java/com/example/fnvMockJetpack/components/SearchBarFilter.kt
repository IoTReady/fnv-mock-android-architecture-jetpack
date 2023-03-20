package com.example.fnvMockJetpack.components

import android.content.ContentValues
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
/*
val items = listOf("Item 1", "Item 2", "Item 3")
var selectedItem by remember { mutableStateOf("") }
SearchableDropDownMenu(items){
    selectedItem->
    Log.d(ContentValues.TAG, "SupplierSummaryScreen: "+selectedItem)*/
@Composable
fun SearchBarFilter(   items: List<String>,
                       onItemSelected: (String) -> Unit
) {
    var searchText by remember { mutableStateOf("") }
    var selectedItem by remember { mutableStateOf("") }
    val filteredItems = items.filter { it.contains(searchText, ignoreCase = true) }

    Column {
        TextField(
            value = searchText,
            onValueChange = { newText ->
                searchText = newText
            },
            label = { Text("Search") },
            singleLine = true,
            modifier = Modifier.padding(8.dp)
        )

        if (searchText.isNotEmpty()) {
            LazyColumn {
                items(filteredItems) { item ->
                    Text(
                        text = item,
                        modifier = Modifier
                            .padding(16.dp)
                            .clickable {
                                selectedItem = item
                                onItemSelected(item)
                                searchText = ""
                            }
                    )
                }
            }
        }
    }
}