package com.example.app10k

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity41 : AppCompatActivity() {
    var txtEdit1: EditText? = null
    var txtEdit2: EditText? = null
    var txtEdit3: EditText? = null

    var Button1: Button? = null

    var BTNR4: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_main41)
        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.main)
        ) { v: View, insets: WindowInsetsCompat ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        txtEdit1 = findViewById(R.id.txtEdit1)

        txtEdit2 = findViewById(R.id.txtEdit2)

        txtEdit3 = findViewById(R.id.txtEdit3)

        Button1 = findViewById(R.id.Button1)

        BTNR4 = findViewById(R.id.BTNR4)

        BTNR4?.setOnClickListener(View.OnClickListener { v: View? -> regresarAOriginal() })
    }

    fun IrActivity2(view: View?) {
        val Nombre = txtEdit1!!.text.toString()
        val Carrera = txtEdit2!!.text.toString()
        val Grupo = txtEdit3!!.text.toString()

        if (!Nombre.isEmpty() && !Carrera.isEmpty() && !Grupo.isEmpty()) {
            val pantalla2 = Intent(
                this,
                MainActivity42::class.java
            )
            pantalla2.putExtra("Nombre", Nombre)
            pantalla2.putExtra("Carrera", Carrera)
            pantalla2.putExtra("Grupo", Grupo)
            startActivity(pantalla2)
        }
    }

    private fun regresarAOriginal() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}