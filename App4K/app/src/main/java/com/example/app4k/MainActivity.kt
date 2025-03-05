package com.example.app4k

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var txtEdit1: EditText
    private lateinit var txtEdit2: EditText
    private lateinit var txtEdit3: EditText
    private lateinit var Button1: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        txtEdit1 = findViewById(R.id.txtEdit1)
        txtEdit2 = findViewById(R.id.txtEdit2)
        txtEdit3 = findViewById(R.id.txtEdit3)
        Button1 = findViewById(R.id.Button1)
    }

    fun irActivity2(view: View) {
        val nombre = txtEdit1.text.toString()
        val carrera = txtEdit2.text.toString()
        val grupo = txtEdit3.text.toString()

        if (nombre.isNotEmpty() && carrera.isNotEmpty() && grupo.isNotEmpty()) {
            val pantalla2 = Intent(this, MainActivity2::class.java).apply {
                putExtra("Nombre", nombre)
                putExtra("Carrera", carrera)
                putExtra("Grupo", grupo)
            }
            startActivity(pantalla2)
        }
    }
}