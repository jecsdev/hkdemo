package com.hkfactorydemo.hkfactoryjohncampusano.ui.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.hkfactorydemo.hkfactoryjohncampusano.R
import com.hkfactorydemo.hkfactoryjohncampusano.databinding.FragmentCustomerBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CustomerFragment : Fragment() {
    private lateinit var binding: FragmentCustomerBinding
    private lateinit var customerNameEditText: EditText
    private lateinit var customerLastNameEditText: EditText
    private lateinit var customerVatId: EditText
    private lateinit var backBtn: Button
    private lateinit var nextBtn: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
        binding = FragmentCustomerBinding.inflate(inflater, container, false)

        return binding.root
    }
}