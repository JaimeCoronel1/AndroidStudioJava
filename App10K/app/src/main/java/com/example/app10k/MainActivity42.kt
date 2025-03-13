package com.example.app10k

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity42 : AppCompatActivity() {
    var txtView1: TextView? = null
    var txtView2: TextView? = null
    var txtView3: TextView? = null

    var Button2: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_main42)
        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.main)
        ) { v: View, insets: WindowInsetsCompat ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        txtView1 = findViewById(R.id.txtView1)

        txtView2 = findViewById(R.id.txtView2)

        txtView3 = findViewById(R.id.txtView3)

        Button2 = findViewById(R.id.Button2)

        val datos = checkNotNull(intent.extras)
        txtView1?.setText(datos.getString("Nombre"))
        txtView2?.setText(datos.getString("Carrera"))
        txtView3?.setText(datos.getString("Grupo"))
    }

    fun IrActivity1(view: View?) {
        val pantalla1 = Intent(
            this,
            MainActivity41::class.java
        )
        startActivity(pantalla1)
    }
}