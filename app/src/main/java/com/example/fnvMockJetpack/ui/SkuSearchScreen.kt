package com.example.fnvMockJetpack.ui

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.fnvMockJetpack.components.SearchBarFilter
import com.example.fnvMockJetpack.ui.theme.FnvMockJetpackTheme

@Composable
fun SkuSearchScreen(
    navController: NavHostController,
    onItemSelected: (String) -> Unit,
    items: List<String>,

    ) {
    var selectedItem by remember { mutableStateOf("") }
    var searchExpanded by remember { mutableStateOf(false) }
    FnvMockJetpackTheme {
        Surface(
            modifier = Modifier.fillMaxHeight(),

            color = MaterialTheme.colorScheme.background
        ) {


            SearchBarFilter(
                items = items,
                onItemSelected = {
                    selectedItem = it
                    searchExpanded = false
                    onItemSelected(it) // Pass the selected item back to the ProcurementScreen
                    Log.d(TAG, "SkuSearchScreen: "+it)
                    navController.navigate("Pricurement")
                }
            )
        }

    }
}
/*
@Preview
@Composable
fun previewsearch()
{
    SkuSearchScreen(NavController, "selectedsku")
}*/
