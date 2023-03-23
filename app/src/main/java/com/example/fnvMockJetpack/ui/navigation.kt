package com.example.fnvMockJetpack.ui

sealed class Screen(val route: String) {
    object ProcurementScreen : Screen("ProcurementScreen")
    object DataEntryScreen : Screen("DataEntryScreen")
    object SupplierSummaryScreen : Screen("SupplierSummaryScreen")
}
