package com.example.fnvMockJetpack.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.fnvMockJetpack.components.SearchBarFilter
import com.example.fnvMockJetpack.ui.theme.FnvMockJetpackTheme

@Composable
fun SkuSearchScreen() {
    var selectedItem by remember { mutableStateOf("") }
    var searchExpanded by remember { mutableStateOf(false) }
    FnvMockJetpackTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            SearchBarFilter(
                items = listOf("SKU 1", "SKU 2", "SKU 3"),
                onItemSelected = {
                    selectedItem = it
                    searchExpanded = false
                }
            )
        }
    }
}