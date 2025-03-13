package com.example.app10k

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {
    private var txtOnCreate: TextView? = null
    private var txtOnStart: TextView? = null
    private var txtOnStop: TextView? = null
    private var txtOnPause: TextView? = null
    private var txtOnResume: TextView? = null
    private var txtOnDestroy: TextView? = null
    private var txtOnRestart: TextView? = null
    private var txtOnClick: TextView? = null

    var BTNR3: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        txtOnCreate = findViewById(R.id.txtOnCreate)
        txtOnStart = findViewById(R.id.txtOnStart)
        txtOnStop = findViewById(R.id.txtOnStop)
        txtOnPause = findViewById(R.id.txtOnPause)
        txtOnResume = findViewById(R.id.txtOnResume)
        txtOnDestroy = findViewById(R.id.txtOnDestroy)
        txtOnRestart = findViewById(R.id.txtOnRestart)
        txtOnClick = findViewById(R.id.txtOnClick)

        BTNR3 = findViewById(R.id.BTNR3)

        BTNR3?.setOnClickListener(View.OnClickListener { v: View? -> regresarAOriginal() })


        Log.d("onCreate", "Método onCreate ejecutado")
        txtOnCreate?.setText("Método onCreate")

        val btnMostrar = findViewById<Button>(R.id.BTN1)
        btnMostrar.setOnClickListener { v: View? ->
            Log.d(
                "BtnClick",
                "Botón presionado"
            )
        }
        btnMostrar.setOnClickListener { v: View? -> txtOnClick?.setText("Botón presionado") }

        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.main)
        ) { v: View, insets: WindowInsetsCompat ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("onStart", "Método onStart ejecutado")
        if (txtOnStart != null) txtOnStart!!.text = "Método onStart"
    }

    override fun onResume() {
        super.onResume()
        Log.d("onResume", "Método onResume ejecutado")
        if (txtOnResume != null) txtOnResume!!.text = "Método onResume"
    }

    override fun onPause() {
        super.onPause()
        Log.d("onPause", "Método onPause ejecutado")
        if (txtOnPause != null) txtOnPause!!.text = "Método onPause"
    }

    override fun onStop() {
        super.onStop()
        Log.d("onStop", "Método onStop ejecutado")
        if (txtOnStop != null) txtOnStop!!.text = "Método onStop"
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("onDestroy", "Método onDestroy ejecutado")
        if (txtOnDestroy != null) txtOnDestroy!!.text = "Método onDestroy"
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("onRestart", "Método onRestart ejecutado")
        if (txtOnRestart != null) txtOnRestart!!.text = "Método onRestart"
    }

    private fun regresarAOriginal() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}