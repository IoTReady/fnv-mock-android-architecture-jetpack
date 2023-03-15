package com.example.fnvMockJetpack.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.fnvMockJetpack.Adapters.RecyclerViewAdapter
import com.example.fnvMockJetpack.GenerateCrateID
import com.example.fnvMockJetpack.ViewModels.ProcurementFragmentViewModel
import com.example.fnvMockJetpack.ViewModels.TransferOutFragmentViewModel
import java.util.*

class RecyclerViewFragment : Fragment() {
    private val procurementFragmentViewModel by viewModels<ProcurementFragmentViewModel>({ requireActivity() })
    private val transferOutFragmentViewModel by viewModels<TransferOutFragmentViewModel>({ requireActivity() })
    private var adapter: RecyclerViewAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Box(
                    modifier = Modifier.fillMaxWidth().padding(4.dp)
                ) {
                    val items = mutableListOf<String>()
//                    val selectedSupplierState = procurementFragmentViewModel.selectedSupplier.collectAsState()
//                    val selectedSKUState = procurementFragmentViewModel.selectedSKU.collectAsState()
//                    val selectedWarehouseState = transferOutFragmentViewModel.selectedWarehouse.collectAsState()
//
//                    when {
//                        selectedSupplierState.value != null && selectedSKUState.value != null -> {
//                            items.add(selectedSupplierState.value!!)
//                            items.add(selectedSKUState.value!!)
//                            generateCrateIDList(items)
//                        }
//                        selectedWarehouseState.value != null -> {
//                            items.add(selectedWarehouseState.value!!)
//                            generateCrateIDList(items)
//                        }
//                    }

                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp, bottom = 8.dp),
                        contentPadding = PaddingValues(bottom = 8.dp),
                        state = rememberLazyListState()
                    ) {
                        itemsIndexed(items) { index, item ->
                            Text(text = item)
                        }
                    }
                }
            }
        }
    }

    private fun generateCrateIDList(items: MutableList<String>) {
        for (i in 0..3) {
            val crateID = "Crate ID: " + GenerateCrateID.generateCrateID().toString()
            items.add(crateID)
        }
    }
}
