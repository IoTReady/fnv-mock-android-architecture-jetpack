package com.example.fnvMockJetpack.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import com.example.fnvMockJetpack.R
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.fnvMockJetpack.Adapters.RecyclerViewAdapter
import com.example.fnvMockJetpack.GenerateCrateID
import com.example.fnvMockJetpack.ViewModels.ProcurementFragmentViewModel
import com.example.fnvMockJetpack.ViewModels.TransferOutFragmentViewModel
import java.util.*

class RecyclerViewFragment : Fragment() {

    private var adapter: RecyclerViewAdapter? = null
    private val newItems = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                val items = remember { mutableStateOf(listOf<String>()) }
                RecyclerView(items.value)
            }
        }
    }

    @Composable
    fun RecyclerView(items: List<String>) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 8.dp),
                state = rememberLazyListState()
            ) {
                items.forEach { item ->
                    item {
                        ListItem(item = item)
                        Divider()
                    }
                }
            }
        }
    }

    @Composable
    fun ListItem(item: String) {
        Text(text = item)
    }

    private fun generateCrateIDList(items: MutableState<List<String>>) {
        for (i in 0..3) {
            val crateID = "Crate ID: " + GenerateCrateID.generateCrateID().toString()
            newItems += crateID
        }
        items.value = newItems
        adapter?.notifyDataSetChanged()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val procurementFragmentViewModel =
            ViewModelProvider(requireActivity()).get(ProcurementFragmentViewModel::class.java)
        val transferOutFragmentViewModel =
            ViewModelProvider(requireActivity()).get(TransferOutFragmentViewModel::class.java)

        adapter = RecyclerViewAdapter(Arrays.asList())
        if (requireActivity().findViewById<View?>(R.id.fragment_procurement_id) != null) {
            procurementFragmentViewModel.selectedSupplier.observe(viewLifecycleOwner) { selectedSupplier ->
                val selectedSKU = procurementFragmentViewModel.selectedSKU.value
                val newItems = mutableListOf<String>()
                newItems += selectedSupplier
                if (selectedSKU != null) {
                    newItems += selectedSKU
                }
                generateCrateIDList(items = items)
            }
            procurementFragmentViewModel.selectedSKU.observe(viewLifecycleOwner) { selectedSKU ->
                val selectedSupplier = procurementFragmentViewModel.selectedSupplier.value
                val newItems = mutableListOf<String>()
                newItems += selectedSupplier
                if (selectedSKU != null) {
                    newItems += selectedSKU
                }
                generateCrateIDList(items = items)

            }
        }
    }
}