package com.example.architecturedemo.ui.theme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.architecturedemo.R
import com.example.architecturedemo.databinding.ActivityMainBinding
import com.example.architecturedemo.viewmodel.MainViewModel
import com.example.architecturedemo.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this,MainViewModelFactory(10))[MainViewModel::class.java]



        binding.numberTxt.setText(viewModel.num.toString())




        binding.decreaseBtn.setOnClickListener {
            binding.numberTxt.text = viewModel.decemenet().toString()
        }


        binding.increaseBtn.setOnClickListener{
            binding.numberTxt.text = viewModel.increment().toString()
        }
    }
}