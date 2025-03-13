package com.example.app10k

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity

class MainActivity61 : AppCompatActivity() {
    var boxChetosAzules: CheckBox? = null
    var boxChetosPalomitas: CheckBox? = null
    var boxCrujitosQueso: CheckBox? = null
    var boxDoritos3D: CheckBox? = null
    var boxFritos: CheckBox? = null
    var boxChetosBolitas: CheckBox? = null
    var boxRancheritos: CheckBox? = null
    var boxSabritones: CheckBox? = null
    var boxChurrumais: CheckBox? = null
    var boxCrujitosFH: CheckBox? = null
    var boxSabritonesR: CheckBox? = null
    var boxChetosFH: CheckBox? = null
    var boxDoritos3DFH: CheckBox? = null
    var boxTostitosFH: CheckBox? = null
    var boxChetosColmillos: CheckBox? = null
    var boxChurrumaisF: CheckBox? = null
    var boxChetosPFH: CheckBox? = null
    var boxDoritosIncognitos: CheckBox? = null

    var BTN1: Button? = null

    var BTNR6: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main61)


        boxChetosAzules = findViewById(R.id.boxChetosAzules)
        boxChetosPalomitas = findViewById(R.id.boxChetosPalomitas)
        boxCrujitosQueso = findViewById(R.id.boxCrujitosQueso)
        boxDoritos3D = findViewById(R.id.boxDoritos3D)
        boxFritos = findViewById(R.id.boxFritos)
        boxChetosBolitas = findViewById(R.id.boxChetosBolitas)
        boxRancheritos = findViewById(R.id.boxRancheritos)
        boxSabritones = findViewById(R.id.boxSabritones)
        boxChurrumais = findViewById(R.id.boxChurrumais)
        boxCrujitosFH = findViewById(R.id.boxCrujitosFH)
        boxSabritonesR = findViewById(R.id.boxSabritonesR)
        boxChetosFH = findViewById(R.id.boxChetosFH)
        boxDoritos3DFH = findViewById(R.id.boxDoritos3DFH)
        boxTostitosFH = findViewById(R.id.boxTostitosFH)
        boxChetosColmillos = findViewById(R.id.boxChetosColmillos)
        boxChurrumaisF = findViewById(R.id.boxChurrumaisF)
        boxChetosPFH = findViewById(R.id.boxChetosPFH)
        boxDoritosIncognitos = findViewById(R.id.boxDoritosIncognitos)
        BTN1 = findViewById(R.id.BTN1)

        BTN1?.setOnClickListener(View.OnClickListener { view: View? -> mostrarImagenPaketaxo() })

        BTNR6 = findViewById(R.id.BTNR6)
        BTNR6?.setOnClickListener(View.OnClickListener { v: View? -> regresarAOriginal() })
    }

    private fun mostrarImagenPaketaxo() {
        var imageResource = 0


        if (boxChetosAzules!!.isChecked && boxChetosPalomitas!!.isChecked &&
            boxCrujitosQueso!!.isChecked && boxDoritos3D!!.isChecked
        ) {
            imageResource = R.drawable.pka
        } else if (boxFritos!!.isChecked && boxChetosBolitas!!.isChecked &&
            boxRancheritos!!.isChecked && boxSabritones!!.isChecked
        ) {
            imageResource = R.drawable.pkam
        } else if (boxChurrumais!!.isChecked && boxCrujitosFH!!.isChecked &&
            boxSabritonesR!!.isChecked && boxChetosAzules!!.isChecked
        ) {
            imageResource = R.drawable.pkv
        } else if (boxDoritos3DFH!!.isChecked && boxTostitosFH!!.isChecked &&
            boxChetosFH!!.isChecked && boxSabritonesR!!.isChecked
        ) {
            imageResource = R.drawable.pkm
        } else if (boxChetosPFH!!.isChecked && boxDoritosIncognitos!!.isChecked &&
            boxChetosColmillos!!.isChecked && boxChurrumaisF!!.isChecked
        ) {
            imageResource = R.drawable.pkd
        } else {
            imageResource = R.drawable.error
        }


        Log.d("MainActivity", "Imagen seleccionada: $imageResource")


        val intent = Intent(
            this,
            MainActivity62::class.java
        )
        intent.putExtra("imageResource", imageResource)
        startActivity(intent)
    }

    private fun regresarAOriginal() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
