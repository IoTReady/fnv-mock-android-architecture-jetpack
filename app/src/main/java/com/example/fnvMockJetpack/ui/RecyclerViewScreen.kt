package com.example.fnvMockJetpack.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.util.*


@Composable
fun Recycleviewcomponent(item : String ,modifier: Modifier) {
    val itemsList1 = (0..5).toList()
    val itemsIndexedList = listOf(item, item, item)

    LazyColumn(modifier = Modifier
        .height(200.dp)
        .padding(0.dp, 20.dp)) {
        items(itemsList1) {
            Text("crate "+ UUID.randomUUID().toString().substring(0,5)
                    + " in $item",modifier.background(Color.White), color = Color.Black)
        }


    }
}


