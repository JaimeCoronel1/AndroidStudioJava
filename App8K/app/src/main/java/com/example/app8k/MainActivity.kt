package com.example.app8k

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var BoxCombo1: Spinner? = null
    private var txtAlumnofase: TextView? = null
    private var BTN1: Button? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.main)
        ) { v: View, insets: WindowInsetsCompat ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        BoxCombo1 = findViewById(R.id.BoxCombo1)

        txtAlumnofase = findViewById(R.id.txtAlumnofase)

        BTN1 = findViewById(R.id.BTN1)


        val lista = arrayOf(
            "Selecciona un Alumno",
            "Danna Paola Butchart Iribe",
            "Heber Eduardo Guzman Tapia",
            "Jose David Santana Esparza",
            "Jesus Manuel Valverde Perez",
            "Jaime Coronel Benitez"
        )


        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, lista)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        BoxCombo1.setAdapter(adapter)


        BoxCombo1.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                val nombre = parent.getItemAtPosition(position).toString()


                if (nombre == "Heber Eduardo Guzman Tapia" || nombre == "Danna Paola Butchart Iribe") {
                    txtAlumnofase.setText("Redes")
                } else if (nombre == "Jesus Manuel Valverde Perez" || nombre == "Jaime Coronel Benitez" || nombre == "Jose David Santana Esparza") {
                    txtAlumnofase.setText("Programación")
                } else {
                    txtAlumnofase.setText("")
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        })


        BTN1.setOnClickListener(View.OnClickListener { v: View? ->
            val nombre = BoxCombo1.getSelectedItem().toString()
            if (nombre != "Selecciona un Alumno") {
                val intent = Intent(
                    this@MainActivity,
                    MainActivity2::class.java
                )
                intent.putExtra("Alumno", nombre)
                intent.putExtra("Fase", txtAlumnofase.getText().toString())
                startActivity(intent)
            } else {
                Toast.makeText(this@MainActivity, "Seleccione un estudiante", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }
}