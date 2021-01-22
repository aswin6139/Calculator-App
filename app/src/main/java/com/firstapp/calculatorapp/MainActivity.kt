package com.firstapp.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn00 = findViewById<Button>(R.id.btn00)
        val btn0 = findViewById<Button>(R.id.btn0)
        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)
        val btn4 = findViewById<Button>(R.id.btn4)
        val btn5 = findViewById<Button>(R.id.btn5)
        val btn6 = findViewById<Button>(R.id.btn6)
        val btn7 = findViewById<Button>(R.id.btn7)
        val btn8 = findViewById<Button>(R.id.btn8)
        val btn9 = findViewById<Button>(R.id.btn9)
        val btnDot = findViewById<Button>(R.id.btnDot)

        // Number listeners
        btn00.setOnClickListener { appendOnClick(true,"00") }
        btn0.setOnClickListener { appendOnClick(true,"0") }
        btn1.setOnClickListener { appendOnClick(true,"1") }
        btn2.setOnClickListener { appendOnClick(true,"2") }
        btn3.setOnClickListener { appendOnClick(true,"3") }
        btn4.setOnClickListener { appendOnClick(true,"4") }
        btn5.setOnClickListener { appendOnClick(true,"5") }
        btn6.setOnClickListener { appendOnClick(true,"6") }
        btn7.setOnClickListener { appendOnClick(true,"7") }
        btn8.setOnClickListener { appendOnClick(true,"8") }
        btn9.setOnClickListener { appendOnClick(true,"9") }
        btnDot.setOnClickListener { appendOnClick(true,".") }

        val btnAddition = findViewById<Button>(R.id.btnAddition)
        val btnSubtract = findViewById<Button>(R.id.btnSubtract)
        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        val btnDivision = findViewById<Button>(R.id.btnDivision)
        val btnEqualTo = findViewById<Button>(R.id.btnEqualTo)
        val btnLeftBracket = findViewById<Button>(R.id.btnLeftBracket)
        val btnRightBracket = findViewById<Button>(R.id.btnRightBracket)
        val btnClear = findViewById<Button>(R.id.btnClear)

        // Operator Listeners
        btnAddition.setOnClickListener { appendOnClick(false,"+") }
        btnSubtract.setOnClickListener { appendOnClick(false,"-") }
        btnMultiply.setOnClickListener { appendOnClick(false,"*") }
        btnDivision.setOnClickListener { appendOnClick(false,"/") }
        btnLeftBracket.setOnClickListener { appendOnClick(false,"(") }
        btnRightBracket.setOnClickListener { appendOnClick(false,")") }


        btnClear.setOnClickListener {
            clear()
        }


        btnEqualTo.setOnClickListener {
            calculate()
        }


    }

    private fun appendOnClick(clear: Boolean, string: String){
        val tvInput = findViewById<TextView>(R.id.tvInput)
        val tvOutput = findViewById<TextView>(R.id.tvOutput)

        if(clear){
            tvOutput.text = ""
            tvInput.append(string)
        }else{
            tvInput.append(tvOutput.text)
            tvInput.append(string)
            tvOutput.text = ""
        }
    }

    private fun calculate(){
        val tvInput = findViewById<TextView>(R.id.tvInput)
        val tvOutput = findViewById<TextView>(R.id.tvOutput)
        try {
            // Import Expression Builder Dependency
            val input  = ExpressionBuilder(tvInput.text.toString()).build()
            val output = input.evaluate()
            val longOutput = output.toLong()

            if(output == longOutput.toDouble()){
                tvOutput.text = longOutput.toString()
            }else{
                tvOutput.text = output.toString()
            }
        }catch (e: Exception){
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }
    }

    private fun clear(){
        val tvInput = findViewById<TextView>(R.id.tvInput)
        val tvOutput = findViewById<TextView>(R.id.tvOutput)
            tvInput.text = ""
            tvOutput.text = ""
    }
}