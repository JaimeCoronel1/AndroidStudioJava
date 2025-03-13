package com.example.app7k

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var txtEdit: EditText? = null
    var View1: TextView? = null
    var radioTemperatura: RadioButton? = null
    var radioDolar: RadioButton? = null
    var BTN1: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        txtEdit = findViewById(R.id.txtEdit)
        View1 = findViewById(R.id.View1)
        radioTemperatura = findViewById(R.id.radioTemperatura)
        radioDolar = findViewById(R.id.radioDolar)
        BTN1 = findViewById(R.id.BTN1)


        BTN1.setOnClickListener(View.OnClickListener { convert() })
    }

    private fun convert() {
        val input = txtEdit!!.text.toString()
        if (input.isEmpty()) {
            View1!!.text = "Por favor, ingrese un valor"
            return
        }


        val value = input.toDouble()
        val result: Double


        if (radioTemperatura!!.isChecked) {
            result = (value * 9.0 / 5.0) + 32
            View1!!.text = "Resultado: $result °F"
        } else if (radioDolar!!.isChecked) {
            val exchangeRate = 20.0
            result = value / exchangeRate
            View1!!.text = "Resultado: $$result USD"
        } else {
            View1!!.text = "Seleccione una opción de conversión"
        }
    }
}
