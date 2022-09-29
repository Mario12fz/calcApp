package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import com.example.app.databinding.ActivityMainBinding
import com.google.android.material.shape.ShapePath

class MainActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityMainBinding

    private var number1: Double = 0.0
    private var number2: Double = 0.0

    private var op: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnUno.setOnClickListener { setNumber("1")}
        binding.btnDos.setOnClickListener { setNumber("2") }
        binding.btnTres.setOnClickListener { setNumber("3") }
        binding.btnCuatro.setOnClickListener { setNumber("4") }
        binding.btnCinco.setOnClickListener { setNumber("5") }
        binding.btnSeis.setOnClickListener { setNumber("6") }
        binding.btnSiete.setOnClickListener { setNumber("7") }
        binding.btnOcho.setOnClickListener { setNumber("8") }
        binding.btnNueve.setOnClickListener { setNumber("9") }
        binding.btnCero.setOnClickListener { setNumber("0") }
        binding.btnPunto.setOnClickListener { setNumber(".") }

        binding.btnSuma.setOnClickListener{ setOperation(SUMA) }
        binding.btnResta.setOnClickListener{ setOperation(RESTA) }
        binding.btnMultiplicacion.setOnClickListener{ setOperation(MULTIPLICACION) }
        binding.btnDividir.setOnClickListener{ setOperation(DIVISION) }

        binding.btnBorrar.setOnClickListener {
            binding.tvResult.text = "0"
            number1 = 0.0
            number2 = 0.0
            op = NO_OPERACION
        }
        binding.btnIgual.setOnClickListener {
            var resultado = when(op){
                SUMA -> number1 + number2
                RESTA -> number1 - number2
                MULTIPLICACION -> number1 * number2
                DIVISION -> number1 / number2
                else -> 0
            }
            binding.tvResult.text = resultado.toString()
        }

    }

        private fun setNumber(digit: String){
            if(binding.tvResult.text.toString().length == 1 &&
                binding.tvResult.text.toString().equals("0")){
                binding.tvResult.text = ""
            }
            binding.tvResult.text = "${binding.tvResult.text}$digit"

            if(op == NO_OPERACION){
                number1 = binding.tvResult.text.toString().toDouble()
            }else{
                number2 = binding.tvResult.text.toString().toDouble()
            }

        }


         private fun setOperation(operation: Int){
             this.op = operation
             binding.tvResult.text = "0"
         }


    companion object{
        const val SUMA = 1
        const val RESTA = 2
        const val MULTIPLICACION = 3
        const val DIVISION = 4
        const val NO_OPERACION = 0
    }

}