package com.hkfactorydemo.hkfactoryjohncampusano.ui.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hkfactorydemo.hkfactoryjohncampusano.R
import com.hkfactorydemo.hkfactoryjohncampusano.databinding.FragmentDocumentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DocumentFragment : Fragment() {

    private lateinit var binding: FragmentDocumentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        container?.removeAllViews()
        binding = FragmentDocumentBinding.inflate(inflater, container, false)



        return binding.root
    }


}