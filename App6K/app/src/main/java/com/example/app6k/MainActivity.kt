package com.example.app6k

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import com.example.app6k.R

class MainActivity : AppCompatActivity() {

    private lateinit var boxChetosAzules: CheckBox
    private lateinit var boxChetosPalomitas: CheckBox
    private lateinit var boxCrujitosQueso: CheckBox
    private lateinit var boxDoritos3D: CheckBox
    private lateinit var boxFritos: CheckBox
    private lateinit var boxChetosBolitas: CheckBox
    private lateinit var boxRancheritos: CheckBox
    private lateinit var boxSabritones: CheckBox
    private lateinit var boxChurrumais: CheckBox
    private lateinit var boxCrujitosFH: CheckBox
    private lateinit var boxSabritonesR: CheckBox
    private lateinit var boxChetosFH: CheckBox
    private lateinit var boxDoritos3DFH: CheckBox
    private lateinit var boxTostitosFH: CheckBox
    private lateinit var boxChetosColmillos: CheckBox
    private lateinit var boxChurrumaisF: CheckBox
    private lateinit var boxChetosPFH: CheckBox
    private lateinit var boxDoritosIncognitos: CheckBox
    private lateinit var BTN1: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Asignación de los CheckBoxes
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

        // Configurar el clic del botón
        BTN1.setOnClickListener {
            mostrarImagenPaketaxo()
        }
    }

    private fun mostrarImagenPaketaxo() {
        var imageResource = 0

        // Condiciones para establecer la imagen
        imageResource = when {
            boxChetosAzules.isChecked && boxChetosPalomitas.isChecked &&
                    boxCrujitosQueso.isChecked && boxDoritos3D.isChecked -> R.drawable.pka
            boxFritos.isChecked && boxChetosBolitas.isChecked &&
                    boxRancheritos.isChecked && boxSabritones.isChecked -> R.drawable.pkam
            boxChurrumais.isChecked && boxCrujitosFH.isChecked &&
                    boxSabritonesR.isChecked && boxChetosAzules.isChecked -> R.drawable.pkv
            boxDoritos3DFH.isChecked && boxTostitosFH.isChecked &&
                    boxChetosFH.isChecked && boxSabritonesR.isChecked -> R.drawable.pkm
            boxChetosPFH.isChecked && boxDoritosIncognitos.isChecked &&
                    boxChetosColmillos.isChecked && boxChurrumaisF.isChecked -> R.drawable.pkd
            else -> R.drawable.error
        }

        Log.d("MainActivity", "Imagen seleccionada: $imageResource")

        // Crear un Intent para pasar el valor de la imagen
        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("imageResource", imageResource)
        startActivity(intent)
    }
}



