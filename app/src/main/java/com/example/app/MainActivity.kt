package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import com.example.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityMainBinding

    private var number1: Double = 0.0
    private var number2: Double = 0.0

    private var op: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        binding.btnUno.setOnClickListener{ setNumer("1")}
        binding.btnDos.setOnClickListener{ setNumer("2")}
        binding.btnTres.setOnClickListener{ setNumer("3")}
        binding.btnCuatro.setOnClickListener{ setNumer("4")}
        binding.btnCinco.setOnClickListener{ setNumer("5")}
        binding.btnSeis.setOnClickListener{ setNumer("6")}
        binding.btnSiete.setOnClickListener{ setNumer("7")}
        binding.btnOcho.setOnClickListener{ setNumer("8")}
        binding.btnNueve.setOnClickListener{ setNumer("9")}
        binding.btnCero.setOnClickListener{ setNumer("0")}
    }

    private fun setNumer(digit: String){
        if(binding.tvResult.text.toString().length == 1 &&
                binding.tvResult.text.toString().equals("0")){
            binding.tvResult.text = ""
        }
    }
}