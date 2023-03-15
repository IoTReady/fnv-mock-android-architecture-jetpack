package com.example.fnvMockJetpack.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fnvMockJetpack.components.ui.theme.FnvMockJetpackTheme

@Composable
fun SpinnerScreen(
    spinnerName: String,
    spinnerList: List<String>,
    selectedItem : String,
    onItemSelected: (selectedItem : String) -> Unit
)
{
    var tempSelectedItem = selectedItem

    if (tempSelectedItem.isBlank() && spinnerList.isNotEmpty())
    {
        onItemSelected(spinnerList[0])
        tempSelectedItem=spinnerList[0]
    }

    var expanded by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = spinnerName,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )

        OutlinedButton(
            onClick = { expanded = true },
            enabled = spinnerList.isNotEmpty(),
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp)
        ) {
            Text(
                text = tempSelectedItem,
                maxLines = 1,
                fontWeight = FontWeight.SemiBold
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            spinnerList.forEach { item ->
                DropdownMenuItem(
                    onClick = {
                        expanded = false
                        onItemSelected(item)
                        tempSelectedItem = item
                    }
                ) {
                    Text(text = item)
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun DefaultPreview2() {
    FnvMockJetpackTheme {
        val names= listOf("Warehouse 1", "Warehouse 2", "Warehouse 3")
        var selectedName by rememberSaveable() {
            mutableStateOf("")
        }
        SpinnerScreen("Warehouse", spinnerList=names, selectedItem =selectedName) { selectedName = it }
    }
}