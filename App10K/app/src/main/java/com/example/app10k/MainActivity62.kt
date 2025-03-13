package com.example.app10k

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity62 : AppCompatActivity() {
    var Imagen: ImageView? = null
    var BTN2: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main62)

        Imagen = findViewById(R.id.Imagen)
        BTN2 = findViewById(R.id.BTN2)


        val intent = intent
        val imageResource = intent.getIntExtra("imageResource", R.drawable.error)


        if (imageResource != 0) {
            Imagen?.setImageResource(imageResource)
        } else {
            Imagen?.setImageResource(R.drawable.error)
        }

        BTN2?.setOnClickListener(View.OnClickListener { v: View? ->
            val returnIntent = Intent(
                this,
                MainActivity61::class.java
            )
            startActivity(returnIntent)
        })
    }
}