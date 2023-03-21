package com.example.fnvMockJetpack.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun SearchBarFilter(   items: List<String>,
                       onItemSelected: (String) -> Unit
) {
    var searchText by remember { mutableStateOf("") }
    var selectedItem by remember { mutableStateOf("") }
    val filteredItems = items.filter { it.contains(searchText, ignoreCase = true) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
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
            LazyColumn(
                horizontalAlignment = Alignment.Start
            ) {
                items(filteredItems) { item ->
                    Text(
                        text = item,
                        modifier = Modifier
                            .padding(16.dp)
                            .clickable {
                                selectedItem = item
                                onItemSelected(item)
                                searchText = item
                            }
                    )
                }
            }
        }
    }
}