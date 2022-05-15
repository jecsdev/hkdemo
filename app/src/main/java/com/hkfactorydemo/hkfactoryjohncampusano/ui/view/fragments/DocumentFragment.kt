package com.hkfactorydemo.hkfactoryjohncampusano.ui.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hkfactorydemo.hkfactoryjohncampusano.R
import com.hkfactorydemo.hkfactoryjohncampusano.data.database.entities.PurchaseEntity
import com.hkfactorydemo.hkfactoryjohncampusano.databinding.FragmentDocumentBinding
import com.hkfactorydemo.hkfactoryjohncampusano.domain.model.Details
import com.hkfactorydemo.hkfactoryjohncampusano.domain.model.Purchase
import com.hkfactorydemo.hkfactoryjohncampusano.ui.view.adapters.DetailsAdapter
import com.hkfactorydemo.hkfactoryjohncampusano.ui.viewModels.PurchaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.lang.NumberFormatException

@AndroidEntryPoint
class DocumentFragment : Fragment(){

    private lateinit var binding: FragmentDocumentBinding
    private  var viewManager = LinearLayoutManager(activity)
    private var subtotal = 0

    private var detailsList = mutableListOf<Details>()
    private val purchaseViewModel: PurchaseViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        container?.removeAllViews()

        binding = FragmentDocumentBinding.inflate(inflater, container, false)


        binding.countEt.text = purchaseViewModel.count.toString()

        getArgumentsFromFragment()


        binding.addToCart.setOnClickListener {
            initDetails()
        }

        binding.generateBtn.setOnClickListener {

                val purchase = PurchaseEntity(
                    seller = binding.sellerName.text.toString(),
                    ncf = binding.ncf.text.toString(),
                    customerName = binding.customerName.text.toString(),
                    vatId = binding.vatId.text.toString(),
                    totalItems = purchaseViewModel.detailsModelList.value!!.size,
                    totalSold = purchaseViewModel.total
                )
                purchaseViewModel.createPurchase(purchase)

                closePurchase()



        }

        binding.minusBtn.setOnClickListener {
            purchaseViewModel.minusNumber()
            binding.countEt.text = purchaseViewModel.count.toString()
        }

        binding.plusBtn.setOnClickListener {
             purchaseViewModel.addNumber()
            binding.countEt.text = purchaseViewModel.count.toString()
        }

        binding.btnBackDispatch.setOnClickListener{
            val customerFragment = CustomerFragment()
            parentFragmentManager.commit {
                setCustomAnimations(
                    androidx.appcompat.R.anim.abc_slide_in_bottom,
                    com.google.android.material.R.anim.abc_fade_out,
                )
                replace(R.id.documentFragment, customerFragment)
            }
        }
        return binding.root
    }

    private fun closePurchase() {
        val mainFragment = MainFragment()
        parentFragmentManager.commit {
            setCustomAnimations(
                androidx.appcompat.R.anim.abc_slide_in_bottom,
                com.google.android.material.R.anim.abc_fade_out,
            )
            replace(R.id.documentFragment, mainFragment)
        }
    }

    private fun getArgumentsFromFragment() {
        binding.sellerName.text = arguments?.getString("sellerName")
        binding.ncf.text = arguments?.getString("ncfNumber")
        binding.customerName.text = arguments?.getString("customerName")
        binding.vatId.text = arguments?.getString("customerVatId")
    }

    private fun initDetails() {
        if(binding.productNameEt.text.isNullOrEmpty()){
            binding.productNameEt.error = "Por favor, introduzca el nombre del producto."
            binding.productNameEt.setTextColor(R.color.red)
        }
        if(binding.codePurchaseEt.text.isNullOrEmpty()){
            binding.codePurchaseEt.error = "Por favor, introduzca el codigo de producto."
            binding.codePurchaseEt.setTextColor(R.color.red)
        }

        if(binding.productPrice.text.isNullOrEmpty()){
            binding.productPrice.error = "Por favor, introduzca el precio del producto."
            binding.productPrice.setTextColor(R.color.red)
        }
        if (binding.productPrice.text.isNullOrEmpty() && binding.codePurchaseEt.text.isNullOrEmpty()
            && binding.productNameEt.text.isNullOrEmpty()){
            binding.productPrice.error = "Por favor, introduzca el precio del producto."
            binding.productPrice.setTextColor(R.color.red)
            binding.codePurchaseEt.error = "Por favor, introduzca el codigo de producto."
            binding.codePurchaseEt.setTextColor(R.color.red)
            binding.productNameEt.error = "Por favor, introduzca el nombre del producto."
            binding.productNameEt.setTextColor(R.color.red)
        }else{
            subtotal =  binding.productPrice.text.toString().toInt() * purchaseViewModel.count
            purchaseViewModel.total+=subtotal
            binding.subtotal.text = purchaseViewModel.total.toString()

            val details = Details(productPrice = binding.productPrice.text.toString().toInt(),
                productName = binding.productNameEt.text.toString(), productQuantity = purchaseViewModel.count,
                productCode = binding.codePurchaseEt.text.toString(), subtotal = binding.subtotal.text.toString().toInt())

            detailsList.add(details)

            purchaseViewModel.detailsModelList.value = detailsList
            initAdapter(purchaseViewModel.detailsModelList.value!!)

            clearTextFields()
        }
    }

    private fun clearTextFields() {
        binding.productPrice.text.clear()
        binding.productNameEt.text.clear()
        binding.codePurchaseEt.text.clear()
    }

    private fun initAdapter(details: List<Details>) {
        recyclerView = binding.recyclerDocument
        recyclerView.layoutManager = viewManager
        purchaseViewModel.detailsModelList.observe(viewLifecycleOwner) {
            recyclerView.adapter = DetailsAdapter(details)
            recyclerView.adapter?.notifyDataSetChanged()
    }

    }


}