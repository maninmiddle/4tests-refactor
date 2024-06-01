package com.maninmiddle.presentation.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.maninmiddle.presentation.databinding.ActivityMainBinding
import com.maninmiddle.presentation.welcome.WelcomeFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addFragment(WelcomeFragment(), false)

    }

    fun addFragment(fragment: Fragment, addToBackStack: Boolean = true) {
        val supportFragmentManager = supportFragmentManager.beginTransaction()
        supportFragmentManager.add(binding.main.id, fragment)

        if (addToBackStack)
            supportFragmentManager.addToBackStack(null)

        supportFragmentManager.commit()
    }
}