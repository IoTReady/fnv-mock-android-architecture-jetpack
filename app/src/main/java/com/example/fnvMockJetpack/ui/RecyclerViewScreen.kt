package com.example.fnvMockJetpack.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.fnvMockJetpack.ui.theme.FnvMockJetpackTheme

class RecyclerViewScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

                }
            }
        }

    @Preview(showBackground = true)
    @Composable
    fun RecyclerViewScreenPreview() {
        FnvMockJetpackTheme {

        }
    }
