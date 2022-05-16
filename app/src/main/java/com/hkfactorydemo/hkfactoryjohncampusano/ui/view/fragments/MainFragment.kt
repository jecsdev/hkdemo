package com.hkfactorydemo.hkfactoryjohncampusano.ui.view.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.commit
import com.hkfactorydemo.hkfactoryjohncampusano.R
import com.hkfactorydemo.hkfactoryjohncampusano.databinding.FragmentMainBinding
import com.hkfactorydemo.hkfactoryjohncampusano.ui.view.activities.PurchaseListActivity
import com.hkfactorydemo.hkfactoryjohncampusano.ui.view.activities.ReportActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        container?.removeAllViews()
        binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.btnStartPurchase.setOnClickListener {
            val customerFragment = CustomerFragment()
                parentFragmentManager.commit {
                    setCustomAnimations(
                        androidx.appcompat.R.anim.abc_slide_in_bottom,
                        com.google.android.material.R.anim.abc_fade_out,
                    )

                    replace(R.id.container, customerFragment)
                }
        }

        binding.btnGetSells.setOnClickListener {
            val intent = Intent(activity, PurchaseListActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }

}