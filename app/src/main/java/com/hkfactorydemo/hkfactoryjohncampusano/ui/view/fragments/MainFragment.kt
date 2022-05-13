package com.hkfactorydemo.hkfactoryjohncampusano.ui.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.commit
import com.hkfactorydemo.hkfactoryjohncampusano.R
import com.hkfactorydemo.hkfactoryjohncampusano.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var btnStartPurchase: Button
    private lateinit var btnPurchaseList: Button
    private val customerFragment = CustomerFragment()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)
        btnStartPurchase = binding.btnStartPurchase
        btnPurchaseList = binding.btnGetSells
        btnStartPurchase.setOnClickListener {
            parentFragmentManager.commit {
                setCustomAnimations(
                    androidx.appcompat.R.anim.abc_slide_in_bottom,
                    com.google.android.material.R.anim.abc_fade_out,
                )
                replace(R.id.container, customerFragment)
                addToBackStack(null)
            }
        }

        btnPurchaseList.setOnClickListener {
            //TODO
        }

        return binding.root
    }

}