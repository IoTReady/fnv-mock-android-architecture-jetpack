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
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.fnvMockJetpack.QRCodeScannerActivity
import com.example.fnvMockJetpack.ViewModels.ProcurementViewmodel
import com.example.fnvMockJetpack.ui.theme.FnvMockJetpackTheme

@Composable
fun ProcurementScreen(
    navController: NavHostController, selectedSku: String, selectedSupplier: String,
) {

    val viewModel: ProcurementViewmodel = viewModel()
    viewModel.loadsupplier()
    viewModel.loadsku()

    var isSupplierSearch by remember { mutableStateOf(false) }
    var isSkuSearch by remember { mutableStateOf(false) }
    FnvMockJetpackTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = "Supplier\n$selectedSupplier",
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Bold,
                    )
                    IconButton(
                        onClick = {
                            navController.navigate("Screen2/supplier")
                            isSupplierSearch=true
                            isSkuSearch=false
                                  },
                        modifier = Modifier.size(48.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search",
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = "SKU\n$selectedSku",
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Bold,
                    )
                    IconButton(
                        onClick = {
                            navController.navigate("Screen2/sku")
                          },
                        modifier = Modifier.size(48.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search",
                        )
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
                    viewModel.onCompleteButtonClicked()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    var selectedSku by remember { mutableStateOf("") }
    var selectedSupplier by remember { mutableStateOf("") }
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "Procurement"
    ) {
        composable("Procurement") {
            ProcurementScreen(navController, selectedSku, selectedSupplier)
        }

        composable("Screen2/{arg}", arguments = listOf(navArgument("arg") { type = NavType.StringType }))
        { backStackEntry ->
              val screen = backStackEntry.arguments?.getString("arg")
              if(screen == "sku"){
                  val items= listOf("sku 1", "sku 2", "sku 3")
                  SkuSearchScreen(navController = navController, { selectedSku = it }, items)
              }
              else {
                  val items= listOf("supplier 1", "supplier 2", "supplier 3")
                  SkuSearchScreen(navController = navController,{ selectedSupplier = it },items)
              }
        }
    }
}