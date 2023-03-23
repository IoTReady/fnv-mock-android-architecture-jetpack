package com.example.fnvMockJetpack.ui

import android.content.ContentValues.TAG
import android.content.Intent
import android.util.Log
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
    navController: NavHostController, selectedsku: String, selectedsupplier: String,
) {

    val viewModel: ProcurementViewmodel = viewModel()
    viewModel.loadsupplier()
    viewModel.loadsku()

    Log.d(TAG, "selected sku: "+selectedsku)
    Log.d(TAG, "selected supplier: "+selectedsupplier)

    var selectedItem by remember { mutableStateOf("") }
    var searchExpanded by remember { mutableStateOf(false) }
    var itemSelected by remember { mutableStateOf(false) }
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
                        text = "Supplier" + "\n" + selectedsupplier,
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Bold,
                    )
                    IconButton(
                        onClick = {  navController.navigate("Screen2/supplier")
                                 isSupplierSearch=true
                                  isSkuSearch=false}, // TODO: pass onclick event
                        modifier = Modifier.size(48.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search",
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                var clickeda by remember { mutableStateOf(false) }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = "SKU" + "\n" + selectedsku,
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Bold,
                    )
                    IconButton(
                        onClick = {  navController.navigate("Screen2/sku")
                          }, // TODO: pass onclick event
                        modifier = Modifier.size(48.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search",
                        )
                    }
                }
//
                /*  if(clickeda)
                  {

                  }
  */
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
@Preview(showBackground = true, showSystemUi = false)
@Composable
fun ProcurementScreenPreview() {
  //  ProcurementScreen(navController = NavHostController)
}


@Composable
fun MyApp() {
    val viewModel: ProcurementViewmodel = viewModel()

    viewModel.loadsupplier()
    viewModel.loadsku()
    var selectedsku by remember { mutableStateOf("") }
    var selectedsupplier by remember { mutableStateOf("") }
    var s=""
    val navController = rememberNavController()
    var isSupplierSearch by remember { mutableStateOf(false) }
    var isSkuSearch by remember { mutableStateOf(false) }
    NavHost(
        navController = navController,
        startDestination = "Pricurement"
    ) {
        composable("Pricurement") {
            ProcurementScreen(navController,selectedsku,selectedsupplier)
        }
          composable(
                "Screen2/{arg}",

        arguments = listOf(navArgument("arg") { type = NavType.StringType }
        ,)
        ) { backStackEntry ->
              val screen = backStackEntry.arguments?.getString("arg")
              if(screen=="sku"){
                  var items= viewModel.Skulist.value

                  SkuSearchScreen(navController = navController, { selectedsku = it }, items)
                  Log.d(TAG, "MyApp: $selectedsku")
                  viewModel.setSku(selectedsku)
                  Log.d(TAG, "MyAppselectedsku: "+viewModel.selectedsku.value.toString())
              }
              else
              {
                   var items= viewModel.supplierlist.value
                  SkuSearchScreen(navController = navController,{ selectedsupplier = it },items)
                  viewModel.setSuppier(selectedsupplier)
                  Log.d(TAG, "selected Supplier in app: "+viewModel.selectedsupplier.value.toString())


              }


    }
    }
}




