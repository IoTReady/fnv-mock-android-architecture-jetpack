package com.example.fnvMockJetpack.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchFilter(
    searchBarName : String,
    selectedItem : String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = searchBarName + "\n" + selectedItem,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Bold,
        )
        IconButton(
            onClick = { }, // TODO: pass onclick event
            modifier = Modifier.size(48.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun SearchFilterPreview() {
    SearchFilter("SKU", "SKU 1")
}