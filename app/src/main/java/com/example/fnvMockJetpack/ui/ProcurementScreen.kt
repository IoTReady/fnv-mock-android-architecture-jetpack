package com.example.fnvMockJetpack.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.fnvMockJetpack.ViewModels.ProcurementViewmodel
import com.example.fnvMockJetpack.ViewModels.TransferOutViewModel
import com.example.fnvMockJetpack.components.SpinnerScreen
import com.example.fnvMockJetpack.ui.theme.FnvMockJetpackTheme
@Composable
fun ProcurementScreen() {
    val viewModel: ProcurementViewmodel = viewModel()
    viewModel.loadsupplier()
    viewModel.loadsku()
    FnvMockJetpackTheme {
    FnvMockJetpackTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
         /*   val supplierList = listOf("Supplier 1", "Supplier 2", "Supplier 3")
            val skuList = listOf("SKU 1", "SKU 2", "SKU 3")*/

            var selectedSupplier by rememberSaveable() { mutableStateOf("") }
            var selectedSKU by rememberSaveable() { mutableStateOf("") }

            Column(modifier = Modifier.padding(16.dp)) {
                SpinnerScreen(
                    spinnerName = "Supplier",
                    spinnerList = viewModel.supplierlist.value,
                    selectedItem = viewModel.selectedSupplier.value,
                    onItemSelected = { viewModel.onsupplierselected(it) }


                )
                Spacer(modifier = Modifier.height(16.dp))
                SpinnerScreen(
                    spinnerName = "SKU",
                    spinnerList = viewModel.Skulist.value,
                    selectedItem = viewModel.selectedSku.value,
                    onItemSelected = { viewModel.onskuselected(it) }

                )
                var completebuttonClicked by remember { mutableStateOf(false) }

                Button(
                    onClick = { completebuttonClicked=true},
                    colors = ButtonDefaults.buttonColors(Color.Black),
                    shape = RectangleShape,
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Text(text = "Complete Activity")
                }
                if (completebuttonClicked)
                {
                    Log.d("TAG", "indie: ")
                    Recycleviewcomponent(item = viewModel.selectedSupplier.value, item1 = viewModel.selectedSku.value, modifier = Modifier
                        .fillMaxSize()
                        .padding(0.dp, 10.dp)
                        .background(Color.Black))


                }
            }
        }
    }
}}
/*
@Preview(showBackground = true, showSystemUi = false)
@Composable
fun ProcurementScreenPreview() {
    ProcurementScreen()
}}
*/
