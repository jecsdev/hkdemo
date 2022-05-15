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
    private val ncfPrefixes = listOf("B01", "B02", "B14", "B15")
    private lateinit var ncfSpinnerValue: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        container?.removeAllViews()
        binding = FragmentCustomerBinding.inflate(inflater, container, false)
        val mainFragment = MainFragment()
        val spinnerAdapter =
            ArrayAdapter(context!!, android.R.layout.simple_spinner_item, ncfPrefixes)


        binding.btnNextPurchasePage


        binding.spNcf.adapter = spinnerAdapter

        binding.spNcf.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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

        binding.btnNextPurchasePage.setOnClickListener {
            if(binding.etCustomerName.text.isNullOrEmpty()){
                binding.etCustomerName.error = "Por favor, introduzca un nombre."
                binding.etCustomerName.hint = "Por favor, introduzca un nombre."
                binding.etCustomerName.setTextColor(R.color.red)
            }
            if(binding.etNCf.text.isNullOrEmpty()){
                binding.etNCf.error = "Por favor, introduzca un numero NCF."
                binding.etNCf.hint = "Por favor, introduzca un numero NCF."
                binding.etNCf.setTextColor(R.color.red)
            }
            if(binding.etRncId.text.isNullOrEmpty()){
                binding.etRncId.error = "Por favor, introduzca un numero de RNC."
                binding.etRncId.hint = "Por favor, introduzca un numero de RNC."
                binding.etRncId.setTextColor(R.color.red)
            }
            if(binding.etSeller.text.isNullOrEmpty()){
                binding.etSeller.error = "Por favor, introduzca el nombre del suplidor."
                binding.etSeller.hint = "Por favor, introduzca el nombre del suplidor."
                binding.etSeller.setTextColor(R.color.red)
            }

            if(binding.etSeller.text.isNullOrEmpty() && binding.etRncId.text.isNullOrEmpty() &&
                binding.etCustomerName.text.isNullOrEmpty()){
                binding.etCustomerName.error = "Por favor, introduzca un nombre."
                binding.etCustomerName.hint = "Por favor, introduzca un nombre."
                binding.etCustomerName.setTextColor(R.color.red)
                binding.etSeller.error = "Por favor, introduzca el nombre del suplidor."
                binding.etSeller.hint = "Por favor, introduzca el nombre del suplidor."
                binding.etSeller.setTextColor(R.color.red)
                binding.etRncId.error = "Por favor, introduzca un numero de RNC."
                binding.etRncId.hint = "Por favor, introduzca un numero de RNC."
                binding.etRncId.setTextColor(R.color.red)
            }

            if(binding.etSeller.text.isNullOrEmpty() && binding.etRncId.text.isNullOrEmpty() &&
                binding.etRncId.text.isNullOrEmpty() && binding.etNCf.text.isNullOrEmpty()
                && binding.etCustomerName.text.isNullOrEmpty()){
                binding.etSeller.error = "Por favor, introduzca el nombre del suplidor."
                binding.etSeller.hint = "Por favor, introduzca el nombre del suplidor."
                binding.etSeller.setTextColor(R.color.red)
                binding.etRncId.error = "Por favor, introduzca un numero de RNC."
                binding.etRncId.hint = "Por favor, introduzca un numero de RNC."
                binding.etRncId.setTextColor(R.color.red)
                binding.etNCf.error = "Por favor, introduzca un numero NCF."
                binding.etNCf.hint = "Por favor, introduzca un numero NCF."
                binding.etNCf.setTextColor(R.color.red)
                binding.etCustomerName.error = "Por favor, introduzca un nombre."
                binding.etCustomerName.hint = "Por favor, introduzca un nombre."
                binding.etCustomerName.setTextColor(R.color.red)
            }else {

                saveDocumentGeneralInformation()
            }


        }


        binding.btnBackCustomerPage.setOnClickListener {
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


        bundle.putString("customerName", binding.etCustomerName.text.toString())
        bundle.putString("customerVatId", binding.etRncId.text.toString())
        bundle.putString("sellerName", binding.etSeller.text.toString())
        bundle.putString("ncfNumber", ncfSpinnerValue + binding.etNCf.text.toString())


        parentFragmentManager.commit {
            setCustomAnimations(
                androidx.appcompat.R.anim.abc_slide_in_bottom,
                com.google.android.material.R.anim.abc_fade_out,
            )

            replace(R.id.container, documentFragment)
            addToBackStack(null)
            documentFragment.arguments = bundle
        }
    }
}