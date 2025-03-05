package com.example.app5k

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var chCafe: CheckBox
    private lateinit var chAgua: CheckBox
    private lateinit var chChocolate: CheckBox
    private lateinit var chLeche: CheckBox
    private lateinit var chVainilla: CheckBox
    private lateinit var btn1: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        chCafe = findViewById(R.id.chCafe)
        chAgua = findViewById(R.id.chAgua)
        chChocolate = findViewById(R.id.chChocolate)
        chLeche = findViewById(R.id.chLeche)
        chVainilla = findViewById(R.id.chVainilla)


        btn1 = findViewById(R.id.btn1)


        btn1.setOnClickListener {

            val tipoCafe = determinarCafe(chCafe, chAgua, chLeche, chChocolate, chVainilla)

            if (tipoCafe == "Desconocido") {
                Toast.makeText(this, "No existe un café con esos ingredientes", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("tipoCafe", tipoCafe)
            startActivity(intent)
        }
    }

    private fun determinarCafe(cafe: CheckBox, agua: CheckBox, leche: CheckBox, chocolate: CheckBox, vainilla: CheckBox): String {
        return when {
            cafe.isChecked && agua.isChecked && leche.isChecked && chocolate.isChecked -> "Moccha"
            cafe.isChecked && agua.isChecked && leche.isChecked -> "Latte"
            cafe.isChecked && agua.isChecked && vainilla.isChecked -> "Capuccino"
            cafe.isChecked && agua.isChecked -> "Americano"
            else -> "Desconocido"
        }
    }
}
