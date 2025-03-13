package com.example.app10k

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity52 : AppCompatActivity() {
    var txtView1: TextView? = null
    var btn2: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main52)


        txtView1 = findViewById(R.id.txtView1)
        btn2 = findViewById(R.id.btn2)


        val tipoCafe = intent.getStringExtra("tipoCafe")


        txtView1?.setText(tipoCafe)


        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.main)
        ) { v: View, insets: WindowInsetsCompat ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btn2?.setOnClickListener(View.OnClickListener { view: View? ->
            finish()
        })
    }
}
