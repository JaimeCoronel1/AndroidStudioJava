package com.example.app10k

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var BTN1: Button? = null
    private var BTN2: Button? = null
    private var BTN3: Button? = null
    private var BTN4: Button? = null
    private var BTN5: Button? = null
    private var BTN6: Button? = null
    private var BTN7: Button? = null
    private var BTN8: Button? = null
    private var BTN9: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        BTN1 = findViewById(R.id.BTN1)
        BTN2 = findViewById(R.id.BTN2)
        BTN3 = findViewById(R.id.BTN3)
        BTN4 = findViewById(R.id.BTN4)
        BTN5 = findViewById(R.id.BTN5)
        BTN6 = findViewById(R.id.BTN6)
        BTN7 = findViewById(R.id.BTN7)
        BTN8 = findViewById(R.id.BTN8)
        BTN9 = findViewById(R.id.BTN9)


        BTN1?.setOnClickListener(View.OnClickListener { v: View? ->
            irAplicacion(
                MainActivity1::class.java
            )
        })
        BTN2?.setOnClickListener(View.OnClickListener { v: View? ->
            irAplicacion2(
                MainActivity2::class.java
            )
        })
        BTN3?.setOnClickListener(View.OnClickListener { v: View? ->
            irAplicacion3(
                MainActivity3::class.java
            )
        })
        BTN4?.setOnClickListener(View.OnClickListener { v: View? ->
            irAplicacion41(
                MainActivity41::class.java
            )
        })
        BTN5?.setOnClickListener(View.OnClickListener { v: View? ->
            irAplicacion51(
                MainActivity51::class.java
            )
        })
        BTN6?.setOnClickListener(View.OnClickListener { v: View? ->
            irAplicacion61(
                MainActivity61::class.java
            )
        })
        BTN7?.setOnClickListener(View.OnClickListener { v: View? ->
            irAplicacion7(
                MainActivity7::class.java
            )
        })
        BTN8?.setOnClickListener(View.OnClickListener { v: View? ->
            irAplicacion81(
                MainActivity81::class.java
            )
        })
        BTN9?.setOnClickListener(View.OnClickListener { v: View? ->
            irAplicacion9(
                MainActivity9::class.java
            )
        })
    }


    private fun irAplicacion(activityClass: Class<*>) {
        val intent = Intent(
            this,
            MainActivity1::class.java
        )
        startActivity(intent)
    }

    private fun irAplicacion2(activityClass2: Class<*>) {
        val intent = Intent(
            this,
            MainActivity2::class.java
        )
        startActivity(intent)
    }

    private fun irAplicacion3(activityClass3: Class<*>) {
        val intent = Intent(
            this,
            MainActivity3::class.java
        )
        startActivity(intent)
    }

    private fun irAplicacion41(activityClass41: Class<*>) {
        val intent = Intent(
            this,
            MainActivity41::class.java
        )
        startActivity(intent)
    }

    private fun irAplicacion51(activityClass51: Class<*>) {
        val intent = Intent(
            this,
            MainActivity51::class.java
        )
        startActivity(intent)
    }

    private fun irAplicacion61(activityClass61: Class<*>) {
        val intent = Intent(
            this,
            MainActivity61::class.java
        )
        startActivity(intent)
    }

    private fun irAplicacion7(activityClass7: Class<*>) {
        val intent = Intent(
            this,
            MainActivity7::class.java
        )
        startActivity(intent)
    }

    private fun irAplicacion81(activityClass81: Class<*>) {
        val intent = Intent(
            this,
            MainActivity81::class.java
        )
        startActivity(intent)
    }

    private fun irAplicacion9(activityClass9: Class<*>) {
        val intent = Intent(
            this,
            MainActivity9::class.java
        )
        startActivity(intent)
    }
}
