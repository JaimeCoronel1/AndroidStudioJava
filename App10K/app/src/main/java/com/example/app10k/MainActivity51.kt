package com.example.app10k

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity51 : AppCompatActivity() {
    private lateinit var chCafe: CheckBox
    private lateinit var chAgua: CheckBox
    private lateinit var chChocolate: CheckBox
    private lateinit var chLeche: CheckBox
    private lateinit var chVainilla: CheckBox
    private lateinit var btn1: Button
    private lateinit var BTNR5: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main51)


        chCafe = findViewById(R.id.chCafe)
        chAgua = findViewById(R.id.chAgua)
        chChocolate = findViewById(R.id.chChocolate)
        chLeche = findViewById(R.id.chLeche)
        chVainilla = findViewById(R.id.chVainilla)
        BTNR5 = findViewById(R.id.BTNR5)
        btn1 = findViewById(R.id.btn1)


        BTNR5.setOnClickListener { regresarAOriginal() }


        btn1.setOnClickListener {
            val tipoCafe = determinarCafe(chCafe, chAgua, chLeche, chChocolate, chVainilla)
            if (tipoCafe == "Desconocido") {
                Toast.makeText(this, "No existe un café con esos ingredientes", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, MainActivity52::class.java)
            intent.putExtra("tipoCafe", tipoCafe)
            startActivity(intent)
        }
    }

    private fun determinarCafe(
        cafe: CheckBox,
        agua: CheckBox,
        leche: CheckBox,
        chocolate: CheckBox,
        vainilla: CheckBox
    ): String {
        return when {
            cafe.isChecked && agua.isChecked && leche.isChecked && chocolate.isChecked -> "Moccha"
            cafe.isChecked && agua.isChecked && leche.isChecked -> "Latte"
            cafe.isChecked && agua.isChecked && vainilla.isChecked -> "Capuccino"
            cafe.isChecked && agua.isChecked -> "Americano"
            else -> "Desconocido"
        }
    }

    private fun regresarAOriginal() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}

