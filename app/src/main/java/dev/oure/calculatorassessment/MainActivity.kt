package dev.oure.calculatorassessment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    lateinit var btnAdd: Button
    lateinit var btnSubtract: Button
    lateinit var btnModulus: Button
    lateinit var btnDivide: Button
    lateinit var tvAnswer: TextView

    lateinit var etNum1: TextInputEditText
    lateinit var etNum2: TextInputEditText

    lateinit var tilNum1: TextInputLayout
    lateinit var tilNum2: TextInputLayout
    lateinit var tilAnswer: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAdd = findViewById(R.id.btnAdd)
        btnSubtract = findViewById(R.id.btnSubtract)
        btnModulus = findViewById(R.id.btnModulus)
        btnDivide = findViewById(R.id.btnDivide)
        tvAnswer = findViewById(R.id.tvAnswer)

        etNum1 = findViewById(R.id.etNum1)
        etNum2 = findViewById(R.id.etNum2)

        tilNum1 = findViewById(R.id.tilNum1)
        tilNum2 = findViewById(R.id.tilNum2)
        tilAnswer = findViewById(R.id.tilAnswer)


        btnAdd.setOnClickListener {
            var num = etNum1.text.toString().toDouble()
            var num1 = etNum2.text.toString().toDouble()
            Add(num, num1)
        }
        btnSubtract.setOnClickListener {
            var numa = etNum1.text.toString().toDouble()
            var numb = etNum2.text.toString().toDouble()
            Subtract(numa, numb)
        }
        btnModulus.setOnClickListener {
            var numc = etNum1.text.toString().toDouble()
            var numd = etNum2.text.toString().toDouble()
            multiply(numc, numd)
        }
        btnDivide.setOnClickListener {
            var nume = etNum1.text.toString().toDouble()
            var numf = etNum2.text.toString().toDouble()
            divide(nume, numf)
        }

    }

    fun divide(nume: Double, numf: Double) {
        var divide = nume / numf
        tvAnswer.text = divide.toString()
    }

    fun multiply(numc: Double, numd: Double) {
        var multiply = numc * numd
        tvAnswer.text = multiply.toString()
    }

    fun Subtract(numa: Double, numb: Double) {
        var subtract = numb - numb
        tvAnswer.text = subtract.toString()
    }

    fun Add(num: Double, num1: Double) {
        var add = num + num1
        tvAnswer.text = add.toString()

    }

data class MyInputs(var Num1: Double, var Num2: Double)

fun getInputs(): MyInputs?{
    var num1 = etNum1.text.toString()
    var num2 = etNum2.text.toString()
    if (num1.isBlank()){
        etNum1.error = "Number required"
        return null
    }
    if (num2.isBlank()){
        etNum2.error = "Number required"
        return null
    }
    return MyInputs(num1.toDouble(), num2.toDouble())
    }

}