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
import com.example.fnvMockJetpack.components.Spinner
import com.example.fnvMockJetpack.ui.theme.FnvMockJetpackTheme
@Composable
fun ProcurementScreen(navController: NavHostController, selectedsku: String) {
    val viewModel: ProcurementViewmodel = viewModel()
    viewModel.loadsupplier()
    viewModel.loadsku()
    Log.d(TAG, "ProcurementScreen: "+selectedsku)
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
                        onClick = {  navController.navigate("Screen2/hello")  }, // TODO: pass onclick event
                        modifier = Modifier.size(48.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search",
                        )
                    }
                }
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
    var selectedsku by remember { mutableStateOf("") }

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "Pricurement"
    ) {
        composable("Pricurement") {
            ProcurementScreen(navController,selectedsku)
        }
          composable(
                "Screen2/{arg}",
        arguments = listOf(navArgument("arg") { type = NavType.StringType })
        ) { backStackEntry ->
        SkuSearchScreen(navController = navController, onItemSelected = { selectedsku = it })
              Log.d(TAG, "MyApp: $selectedsku")
    }
    }
}




