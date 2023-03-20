package com.example.fnvMockJetpack.ui

import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.fnvMockJetpack.QRCodeScannerActivity
import com.example.fnvMockJetpack.ViewModels.ProcurementViewmodel
import com.example.fnvMockJetpack.components.SearchBarFilter
import com.example.fnvMockJetpack.components.SpinnerScreen
import com.example.fnvMockJetpack.ui.theme.FnvMockJetpackTheme
@Composable
fun ProcurementScreen() {
    val viewModel: ProcurementViewmodel = viewModel()
    viewModel.loadsupplier()
    viewModel.loadsku()
    FnvMockJetpackTheme {
        FnvMockJetpackTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    SpinnerScreen(
                        spinnerName = "Supplier",
                        spinnerList = viewModel.supplierlist.value,
                        selectedItem = viewModel.selectedSupplier.value,
                        onItemSelected = { viewModel.onsupplierselected(it) }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            modifier = Modifier.weight(1f),
                            text = "SKU",
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold
                        )
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 8.dp)
                        ) {
                            var searchClicked by remember { mutableStateOf(false) }
                            IconButton(
                                onClick = { searchClicked = !searchClicked },
                                modifier = Modifier.size(48.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = "Search"
                                )
                            }
                            if (searchClicked) {
                                var selectedItem by remember { mutableStateOf("") }
                                SearchBarFilter(
                                    items = listOf("Supplier 1", "Supplier 2", "Supplier 3"),
                                    onItemSelected = {
                                        selectedItem = it
                                        searchClicked = false
                                    }
                                )
                            }
                        }
                    }

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
}
@Preview(showBackground = true, showSystemUi = false)
@Composable
fun ProcurementScreenPreview() {
    ProcurementScreen()
}

