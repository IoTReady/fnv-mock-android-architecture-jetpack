package com.example.fnvMockJetpack.ui

import android.content.Intent
import androidx.compose.animation.Crossfade
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
    var selectedItem by remember { mutableStateOf("") }
    var searchExpanded by remember { mutableStateOf(false) }
    var itemSelected by remember { mutableStateOf(false)}
    FnvMockJetpackTheme {
        FnvMockJetpackTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Column(modifier = Modifier.padding(),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    SpinnerScreen(
                        spinnerName = "Supplier",
                        spinnerList = viewModel.supplierlist.value,
                        selectedItem = viewModel.selectedSupplier.value,
                        onItemSelected = { viewModel.onsupplierselected(it) }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),

                        ) {
                        Crossfade(targetState = searchExpanded) { expanded ->
                            if (expanded) {
                                SearchBarFilter(
                                    items = listOf("SKU 1", "SKU 2", "SKU 3"),
                                    onItemSelected = {
                                        selectedItem = it
                                        searchExpanded = false
                                    }
                                )
                            } else {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.Center,
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
                                        IconButton(
                                            onClick = { searchExpanded = true
                                                itemSelected = true },
                                            modifier = Modifier.size(48.dp)
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.Search,
                                                contentDescription = "Search",
                                            )
                                        }
                                        if (selectedItem.isNotBlank() && itemSelected) {
                                            Text(
                                                text = selectedItem,
                                                modifier = Modifier.padding(start = 8.dp)
                                            )
                                        }
                                    }
                                }
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

