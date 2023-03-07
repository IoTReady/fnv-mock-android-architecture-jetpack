package com.example.fnvMockJetpack.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.fnvMockJetpack.Models.ProcurementModel;

import java.util.ArrayList;
import java.util.List;

public class ProcurementFragmentViewModel extends ViewModel {
    List<ProcurementModel> supplierList = new ArrayList<>();
    List<ProcurementModel> skuList = new ArrayList<>();
    private final MutableLiveData<List<ProcurementModel>> supplierListLiveData;
    private final MutableLiveData<List<ProcurementModel>> skuListLiveData;
    private final MutableLiveData<List<ProcurementModel>> procurementListLiveData;

    private final MutableLiveData<String> selectedSupplier;
    private final MutableLiveData<String> selectedSKU;

    public ProcurementFragmentViewModel() {
        supplierListLiveData = new MutableLiveData<>();
        supplierListLiveData.postValue(getSupplierList(getProcurementList()));

        skuListLiveData = new MutableLiveData<>();
        skuListLiveData.postValue(getSKUList(getProcurementList()));

        procurementListLiveData = new MutableLiveData<>();
        procurementListLiveData.postValue(getProcurementList());

        selectedSupplier = new MutableLiveData<>();
        selectedSupplier.postValue("");

        selectedSKU = new MutableLiveData<>();
        selectedSKU.postValue("");
    }

    public List<ProcurementModel> getProcurementList() {
        List<ProcurementModel> procurementList = new ArrayList<>();
        procurementList.add(new ProcurementModel("Farmer 1", "Mushroom"));
        procurementList.add(new ProcurementModel("Farmer 2", "Cabbage"));
        procurementList.add(new ProcurementModel("Farmer 3", "Tomato"));
        return procurementList;
    }

    public List<ProcurementModel> getSupplierList(List<ProcurementModel> procurementList) {
        for (ProcurementModel procurement : procurementList) {
            supplierList.add(new ProcurementModel(procurement.getSupplier(), ""));
        }
        return supplierList;
    }

    public List<ProcurementModel> getSKUList(List<ProcurementModel> procurementList) {
        for (ProcurementModel procurement : procurementList) {
            skuList.add(new ProcurementModel("", procurement.getSKU()));
        }
        return skuList;
    }

    public LiveData<List<ProcurementModel>> getProcurementListLiveData() {
        return procurementListLiveData;
    }
    public LiveData<List<ProcurementModel>> getSupplierListLiveData() {
        return supplierListLiveData;
    }

    public LiveData<List<ProcurementModel>> getSkuListLiveData() {
        return skuListLiveData;
    }

    public MutableLiveData<String> getSelectedSupplier() {
        return selectedSupplier;
    }
    public MutableLiveData<String> getSelectedSKU() { return selectedSKU; }
}