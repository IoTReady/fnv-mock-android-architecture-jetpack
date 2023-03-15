package com.example.fnvMockJetpack.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fnvMockJetpack.components.ui.theme.FnvMockJetpackTheme

@Composable
fun SpinnerScreen(
    itemList: List<String>,
    selectedItem : String,
    onItemSelected: (selectedItem : String) -> Unit
)
{
    var tempSelectedItem=selectedItem;
    if (tempSelectedItem.isBlank() && itemList.isNotEmpty())
    {
        onItemSelected(itemList[0])
        tempSelectedItem=itemList[0]
    }
    var expanded by rememberSaveable() { mutableStateOf(false) }
    OutlinedButton(onClick = { expanded=true },
        modifier = Modifier
            .background(Color.White)
            .widthIn(min = 60.dp),
        enabled=itemList.isNotEmpty() ) {

        Text(text = tempSelectedItem,
            overflow = TextOverflow.Ellipsis,
            maxLines=1,
            modifier = Modifier.weight(1f,
            ),)
    }
    DropdownMenu(expanded = expanded,
        onDismissRequest = { expanded=false}) {
        itemList.forEach{
            DropdownMenuItem(onClick = { expanded=false
                onItemSelected(it)
            }) {
                Text(text = it)
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
        SpinnerScreen(itemList=names, selectedItem =selectedName) { selectedName = it }
    }
}