package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var first: Double = 0.0;
    private var second: Double = 0.0;
    private var operation: String = "";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnOne.setOnClickListener{ clickNumber("1")}
        btnTwo.setOnClickListener{ clickNumber("2")}
        btnThree.setOnClickListener{ clickNumber("3")}
        btnFor.setOnClickListener{ clickNumber("4")}
        btnFive.setOnClickListener{ clickNumber("5")}
        btnSix.setOnClickListener{ clickNumber("6")}
        btnSeven.setOnClickListener{ clickNumber("7")}
        btnEight.setOnClickListener{ clickNumber("8")}
        btnNine.setOnClickListener{ clickNumber("9")}
        btnZero.setOnClickListener{ clickNumber("0")}
        btnDot.setOnClickListener{ clickNumber(".")}

        btnSplit.setOnClickListener{ operation("/")}
        btnMultiply.setOnClickListener{ operation("X")}
        btnSubstraction.setOnClickListener{ operation("-")}
        btnPlus.setOnClickListener{ operation("+")}

        btnClean.setOnClickListener{
            txtResult.setText("")
            first = 0.0
            second = 0.0
            operation = ""
        }
        btnEqual.setOnClickListener{ equals() }
    }
    private fun clickNumber(number: String){
        txtResult.setText("${txtResult.text}$number")
        if (operation == ""){
            first = txtResult.text.toString().toDouble()
        }else{
            second = txtResult.text.toString().toDouble()
        }

    }
    private fun operation(symbol: String){
        operation = symbol
        txtResult.setText("")
    }
    private fun equals(){
        var result = 0.0
        if (operation == "+"){
            result = first+second
        }else if (operation == "-"){
            result = first-second
        }else if (operation == "X"){
            result = first*second
        }else if (operation == "/"){
            result = first/second
        }
        txtResult.setText(result.toString())

    }
}