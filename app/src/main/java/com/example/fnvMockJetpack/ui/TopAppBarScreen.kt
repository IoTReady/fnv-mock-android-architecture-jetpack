package com.example.fnvMockJetpack.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarScreen(content: @Composable() () -> Unit){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "fnv Mock UI", color = Color.White)
                },
                backgroundColor = Color.Black
            )
        },

        content = {
            Box(modifier = Modifier.padding(top=56.dp)) {
                content()
            }
        }
    )
}