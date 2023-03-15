package com.example.fnvMockJetpack.ViewModels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class TransferOutViewModel : ViewModel() {

    private val _warehouseList = mutableStateOf(listOf<String>())
    val warehouseList: State<List<String>> = _warehouseList

    private val _selectedWarehouse = mutableStateOf("")
    val selectedWarehouse: State<String> = _selectedWarehouse

    private val _checkedState = mutableStateOf(false)
    val checkedState: State<Boolean> = _checkedState

    private val _cratebuttonClicked = mutableStateOf(false)
    val cratebuttonClicked: State<Boolean> = _cratebuttonClicked

    fun loadData() {
        // Load the data from the repository or API
        _warehouseList.value = listOf("Warehouse 1", "Warehouse 2", "Warehouse 3")
    }

    fun onWarehouseSelected(warehouse: String) {
        _selectedWarehouse.value = warehouse
    }

    fun onCheckedStateChanged(checked: Boolean) {
        _checkedState.value = checked
    }

    fun onCrateButtonClicked() {
        _cratebuttonClicked.value = true
    }

    fun onCrateListDisplayed() {
        _cratebuttonClicked.value = false
    }
}
