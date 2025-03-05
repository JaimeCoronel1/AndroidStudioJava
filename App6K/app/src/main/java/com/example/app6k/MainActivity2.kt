package com.example.app6k

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    private lateinit var imagen: ImageView
    private lateinit var btn2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        imagen = findViewById(R.id.Imagen)
        btn2 = findViewById(R.id.BTN2)


        val intent = intent
        val imageResource = intent.getIntExtra("imageResource", R.drawable.error)


        if (imageResource != 0) {
            imagen.setImageResource(imageResource)
        } else {
            imagen.setImageResource(R.drawable.error)
        }

        btn2.setOnClickListener {
            val returnIntent = Intent(this, MainActivity::class.java)
            startActivity(returnIntent)
        }
    }
}
