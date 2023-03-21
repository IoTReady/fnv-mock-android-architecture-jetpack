package com.example.fnvMockJetpack.ui

import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.fnvMockJetpack.QRCodeScannerActivity
import com.example.fnvMockJetpack.ViewModels.ProcurementViewmodel
import com.example.fnvMockJetpack.components.Spinner
import com.example.fnvMockJetpack.ui.theme.FnvMockJetpackTheme
@Composable
fun ProcurementScreen() {
    val viewModel: ProcurementViewmodel = viewModel()
    viewModel.loadsupplier()
    viewModel.loadsku()
    var selectedItem by remember { mutableStateOf("") }
    var searchExpanded by remember { mutableStateOf(false) }
    var itemSelected by remember { mutableStateOf(false) }
    FnvMockJetpackTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spinner(
                    spinnerName = "Supplier",
                    spinnerList = viewModel.supplierlist.value,
                    selectedItem = viewModel.selectedSupplier.value,
                    onItemSelected = { viewModel.onsupplierselected(it) }
                )

                Spacer(modifier = Modifier.height(16.dp))

                SearchFilter("SKU", "SKU 1")

                Button(
                    onClick = { viewModel.onCompleteButtonClicked() },
                    colors = ButtonDefaults.buttonColors(Color.Black),
                    shape = RectangleShape,
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Text(text = "Scan Item")
                }
                if (viewModel.completebuttonClicked.value) {
                    val context = LocalContext.current
                    context.startActivity(
                        Intent(
                            context,
                            QRCodeScannerActivity::class.java
                        )
                    )
                }
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = false)
@Composable
fun ProcurementScreenPreview() {
    ProcurementScreen()
}

