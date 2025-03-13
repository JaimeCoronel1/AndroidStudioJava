package com.example.app10k

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    var View01: TextView? = null
    var Edit01: EditText? = null
    var aceptarButton: Button? = null

    var BTNR2: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        View01 = findViewById(R.id.View01)

        Edit01 = findViewById(R.id.Edit01)

        aceptarButton = findViewById(R.id.aceptarButton)

        BTNR2 = findViewById(R.id.BTNR2)

        BTNR2?.setOnClickListener(View.OnClickListener { v: View? -> regresarAOriginal() })


        if (savedInstanceState != null) {
            val TextString = savedInstanceState.getString("textoGuardado", "")
            View01?.setText(TextString)
        }

        aceptarButton?.setOnClickListener(View.OnClickListener {
            val TextString = Edit01?.getText().toString()
            View01?.setText(TextString)
        })
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("textoGuardado", View01!!.text.toString())
    }


    private fun regresarAOriginal() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
