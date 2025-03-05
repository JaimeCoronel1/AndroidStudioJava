package com.example.app4k

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {

    private lateinit var txtView1: TextView
    private lateinit var txtView2: TextView
    private lateinit var txtView3: TextView
    private lateinit var Button2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        txtView1 = findViewById(R.id.txtView1)
        txtView2 = findViewById(R.id.txtView2)
        txtView3 = findViewById(R.id.txtView3)
        Button2 = findViewById(R.id.Button2)

        intent.extras?.let {
            txtView1.text = it.getString("Nombre")
            txtView2.text = it.getString("Carrera")
            txtView3.text = it.getString("Grupo")
        }
    }

    fun irActivity1(view: View) {
        val pantalla1 = Intent(this, MainActivity::class.java)
        startActivity(pantalla1)
    }
}