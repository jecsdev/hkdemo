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
    private val getPurchaseCase: GetPurchaseCase):
    ViewModel() {

    var purchaseModelList = MutableLiveData<MutableList<Purchase>>()
    private val purchaseModel = MutableLiveData<Purchase>()
    val detailsModelList = MutableLiveData<MutableList<Details>>()
    var total = 0
    var count = 1

    fun getPurchase(){
        viewModelScope.launch {
            val list = getPurchaseCase.invoke()
            purchaseModelList.postValue(list as MutableList<Purchase>?)
        }
    }


    fun createPurchase(purchase: PurchaseEntity){
        viewModelScope.launch {
              getPurchaseCase.insertPurchase(purchase)
        }
    }

    fun removePurchase(purchase: Int){
        viewModelScope.launch {
            getPurchaseCase.deleteAllPurchases(purchase)
            getPurchase()
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