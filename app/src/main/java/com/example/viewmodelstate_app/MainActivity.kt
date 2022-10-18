package com.example.viewmodelstate_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.viewmodelstate_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel: SaveStateViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.incrementButton.setOnClickListener { viewModel.increment() }
        viewModel.counterLiveData.observe(this) {
            binding.counterTV.text = it.toString()
        }
    }
}