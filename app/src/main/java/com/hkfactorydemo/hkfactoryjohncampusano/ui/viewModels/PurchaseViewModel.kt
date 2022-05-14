package com.hkfactorydemo.hkfactoryjohncampusano.ui.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hkfactorydemo.hkfactoryjohncampusano.data.database.entities.PurchaseEntity
import com.hkfactorydemo.hkfactoryjohncampusano.domain.GetPurchaseCase
import com.hkfactorydemo.hkfactoryjohncampusano.domain.model.Details
import com.hkfactorydemo.hkfactoryjohncampusano.domain.model.Purchase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PurchaseViewModel @Inject constructor(
    val getPurchaseCase: GetPurchaseCase):
    ViewModel() {

    val purchaseModelList = MutableLiveData<MutableList<Purchase>>()
    val purchaseModel = MutableLiveData<Purchase>()
    val detailsModel = MutableLiveData<MutableList<Details>>()
    var count = 1
    fun getPurchase(){
        viewModelScope.launch {
           val result = getPurchaseCase()
            if(result.isNotEmpty()){
                purchaseModel.value
            }
        }
    }

    fun getDetails(){
        viewModelScope.launch {
            detailsModel.value
        }
    }

    fun insertDetails(){
        viewModelScope.launch {
            detailsModel
        }
    }

    fun createPurchase(purchase: PurchaseEntity){
        viewModelScope.launch {
            val result = getPurchaseCase()
            if(result.isNotEmpty()){
                getPurchaseCase.insertPurchase(purchase)
            }
        }
    }

    fun addPurchase(purchase: Purchase){
        viewModelScope.launch {
            purchase.productName
        }
    }

    fun removePurchase(purchase: List<PurchaseEntity>){
        viewModelScope.launch {
            val result = getPurchaseCase()
            if(result.isNotEmpty()){
                getPurchaseCase.deleteAllPurchases()
            }
        }
    }

    fun addNumber(){
        count++
    }

    fun minusNumber(){
        count--
        if(count <0){
            count = 0
        }
    }
}