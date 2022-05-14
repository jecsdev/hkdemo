package com.hkfactorydemo.hkfactoryjohncampusano.ui.view.fragments

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.commit
import com.hkfactorydemo.hkfactoryjohncampusano.R
import com.hkfactorydemo.hkfactoryjohncampusano.databinding.FragmentCustomerBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CustomerFragment : Fragment() {
    private lateinit var binding: FragmentCustomerBinding
    private lateinit var customerNameEditText: EditText
    private lateinit var customerVatIdEditText: EditText
    private lateinit var ncfIdEditText: EditText

    private lateinit var backBtn: Button
    private lateinit var nextBtn: Button
    private lateinit var nfcSpinner: Spinner
    private val ncfPrefixes = listOf("B01", "B02", "B14", "B15")
    private lateinit var ncfSpinnerValue: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCustomerBinding.inflate(inflater, container, false)
        val mainFragment = MainFragment()
        val spinnerAdapter =
            ArrayAdapter(context!!, android.R.layout.simple_spinner_item, ncfPrefixes)


        backBtn = binding.btnBackCustomerPage
        nextBtn = binding.btnNextPurchasePage

        nfcSpinner = binding.spNcf
        nfcSpinner.adapter = spinnerAdapter

        nfcSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                ncfSpinnerValue = ncfPrefixes[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(
                    view!!.context, "Debe seleccionar un tipo de comprobante fiscal",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }

        nextBtn.setOnClickListener {
            saveDocumentGeneralInformation()
        }


        backBtn.setOnClickListener {
            val builder = AlertDialog.Builder(it.context)
            builder.setTitle("Aviso")
            builder.setMessage(
                "Esta seguro que desea salir? Al hacer esto se perdera todo el proceso hasta ahora."
            )
            builder.setPositiveButton("Si") { _, _ ->
                parentFragmentManager.commit {
                    setCustomAnimations(
                        androidx.appcompat.R.anim.abc_slide_in_bottom,
                        com.google.android.material.R.anim.abc_fade_out,
                    )

                    replace(R.id.container, mainFragment)
                    addToBackStack(null)
                }
            }
            builder.setNegativeButton("No", null).create()
            builder.show()
        }
        return binding.root
    }

    private fun saveDocumentGeneralInformation() {
        val documentFragment = DocumentFragment()
        val bundle = Bundle()
        customerNameEditText = binding.etCustomerName
        customerVatIdEditText = binding.etRncId
        ncfIdEditText = binding.etNCf

        bundle.putString("customerName", customerNameEditText.text.toString())
        bundle.putString("customerVatId", customerVatIdEditText.text.toString())
        bundle.putString("ncfNumber", ncfIdEditText.text.toString())

        parentFragmentManager.commit {
            setCustomAnimations(
                androidx.appcompat.R.anim.abc_slide_in_bottom,
                com.google.android.material.R.anim.abc_fade_out,
            )

            replace(R.id.container, documentFragment)
            addToBackStack(null)
        }
    }

}