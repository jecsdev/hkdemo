package com.hkfactorydemo.hkfactoryjohncampusano.ui.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hkfactorydemo.hkfactoryjohncampusano.R
import com.hkfactorydemo.hkfactoryjohncampusano.databinding.FragmentDocumentBinding
import com.hkfactorydemo.hkfactoryjohncampusano.ui.viewModels.PurchaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DocumentFragment : Fragment(){

    private lateinit var binding: FragmentDocumentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        container?.removeAllViews()

        binding = FragmentDocumentBinding.inflate(inflater, container, false)

        val purchaseViewModel: PurchaseViewModel by viewModels()

        binding.countEt.text = purchaseViewModel.number.toString()

        purchaseViewModel.purchaseModel.observe(viewLifecycleOwner

        ) {
            binding.sellerName.text = it.seller
            binding.ncf.text = it.ncf
            binding.customerName.text = it.customerName
            binding.vatId.text = it.vatId
            binding.codeItem.text = it.productCode
            binding.itemName.text = it.productName
            binding.itemCount.text = it.productQuantity.toString()
            binding.subtotalItem.text = it.subtotal.toString()
            binding.subtotal.text = it.totalSold.toString()
        }

        binding.sellerName.text = arguments?.getString("sellerName")
        binding.ncf.text = arguments?.getString("ncfNumber")
        binding.customerName.text = arguments?.getString("customerName")
        binding.vatId.text = arguments?.getString("customerVatId")

        binding.minusBtn.setOnClickListener {
            purchaseViewModel.minusNumber()
            binding.countEt.text = purchaseViewModel.number.toString()
        }

        binding.plusBtn.setOnClickListener {
             purchaseViewModel.addNumber()
            binding.countEt.text = purchaseViewModel.number.toString()
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




}