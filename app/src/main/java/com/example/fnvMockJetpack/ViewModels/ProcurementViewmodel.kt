package com.example.fnvMockJetpack.ViewModels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProcurementViewmodel : ViewModel() {

    private val _supplierlist = mutableStateOf(listOf<String>())
    val supplierlist: State<List<String>> = _supplierlist
    private val _Skulist = mutableStateOf(listOf<String>())
    val Skulist: State<List<String>> = _Skulist

    private val _selectedsku = MutableLiveData<String>()
    val selectedsku: LiveData<String> = _selectedsku

    private val _selectedsupplier = MutableLiveData<String>()
    val selectedsupplier: LiveData<String> = _selectedsupplier



    private val _checkedState = mutableStateOf(false)
    val checkedState: State<Boolean> = _checkedState

    private val _completebuttonClicked = mutableStateOf(false)
    val completebuttonClicked: State<Boolean> = _completebuttonClicked

    fun loadsupplier() {
        // Load the data from the repository or API
        _supplierlist.value = listOf("Supplier 1", "Supplier 2", "Supplier 3")
    } fun loadsku() {
        // Load the data from the repository or API
        _Skulist.value = listOf("SKU 1", "SKU 2", "SKU 3")
    }
    fun setSku(selectedsku: String)
    {
_selectedsku.value=selectedsku
    }
    fun onsupplierselected(supplier: String) {
        _selectedsupplier.value = supplier
    }
   /* fun onskuselected(sku: String) {
        _selectedSku.value = sku
    }*/

    fun onCheckedStateChanged(checked: Boolean) {
        _checkedState.value = checked
    }

    fun onCompleteButtonClicked() {
        _completebuttonClicked.value = !_completebuttonClicked.value
    }

    fun setSuppier(selectedsupplier: String) {
        _selectedsupplier.value=selectedsupplier

    }


}