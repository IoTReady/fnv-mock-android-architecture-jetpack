package com.example.fnvMockJetpack.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
@Composable
fun RecyclerView(items: List<String>) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 8.dp),
            contentPadding = PaddingValues(bottom = 8.dp),
            state = rememberLazyListState(),
        ) {
            itemsIndexed(items) { index, item ->
                Text(text = item)
            }
        }
    }
}
