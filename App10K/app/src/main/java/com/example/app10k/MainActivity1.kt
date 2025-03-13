package com.example.app10k

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity1 : AppCompatActivity() {
    var BTNR1: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_main1)


        BTNR1 = findViewById(R.id.BTNR1)


        BTNR1?.setOnClickListener(View.OnClickListener { v: View? -> regresarAOriginal() })
    }


    private fun regresarAOriginal() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
