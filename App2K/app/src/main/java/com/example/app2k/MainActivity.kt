package com.example.app2k

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var View01: TextView
    private lateinit var Edit01: EditText
    private lateinit var aceptarButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        View01 = findViewById(R.id.View01)
        Edit01 = findViewById(R.id.Edit01)
        aceptarButton = findViewById(R.id.aceptarButton)

        savedInstanceState?.getString("textoGuardado")?.let {
            View01.text = it
        }

        aceptarButton.setOnClickListener {
            val textString = Edit01.text.toString()
            View01.text = textString
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("textoGuardado", View01.text.toString())
    }
}

