package com.hkfactorydemo.hkfactoryjohncampusano.ui.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.hkfactorydemo.hkfactoryjohncampusano.R
import com.hkfactorydemo.hkfactoryjohncampusano.databinding.ActivityMainBinding
import com.hkfactorydemo.hkfactoryjohncampusano.ui.view.fragments.CustomerFragment
import com.hkfactorydemo.hkfactoryjohncampusano.ui.view.fragments.MainFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainFragment = MainFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager.commit {
            setCustomAnimations(
                 androidx.appcompat.R.anim.abc_fade_in,
                 com.google.android.material.R.anim.abc_fade_out,
            )
            replace(R.id.container, mainFragment)
            addToBackStack(null)
        }
    }



}