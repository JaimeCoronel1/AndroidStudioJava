package com.example.app6;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    CheckBox boxChetosAzules, boxChetosPalomitas, boxCrujitosQueso, boxDoritos3D;
    CheckBox boxFritos, boxChetosBolitas, boxRancheritos, boxSabritones;
    CheckBox boxChurrumais, boxCrujitosFH, boxSabritonesR, boxChetosFH;
    CheckBox boxDoritos3DFH, boxTostitosFH, boxChetosColmillos, boxChurrumaisF;
    CheckBox boxChetosPFH, boxDoritosIncognitos;

    Button BTN1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        boxChetosAzules = findViewById(R.id.boxChetosAzules);
        boxChetosPalomitas = findViewById(R.id.boxChetosPalomitas);
        boxCrujitosQueso = findViewById(R.id.boxCrujitosQueso);
        boxDoritos3D = findViewById(R.id.boxDoritos3D);
        boxFritos = findViewById(R.id.boxFritos);
        boxChetosBolitas = findViewById(R.id.boxChetosBolitas);
        boxRancheritos = findViewById(R.id.boxRancheritos);
        boxSabritones = findViewById(R.id.boxSabritones);
        boxChurrumais = findViewById(R.id.boxChurrumais);
        boxCrujitosFH = findViewById(R.id.boxCrujitosFH);
        boxSabritonesR = findViewById(R.id.boxSabritonesR);
        boxChetosFH = findViewById(R.id.boxChetosFH);
        boxDoritos3DFH = findViewById(R.id.boxDoritos3DFH);
        boxTostitosFH = findViewById(R.id.boxTostitosFH);
        boxChetosColmillos = findViewById(R.id.boxChetosColmillos);
        boxChurrumaisF = findViewById(R.id.boxChurrumaisF);
        boxChetosPFH = findViewById(R.id.boxChetosPFH);
        boxDoritosIncognitos = findViewById(R.id.boxDoritosIncognitos);
        BTN1 = findViewById(R.id.BTN1);

        BTN1.setOnClickListener(view -> mostrarImagenPaketaxo());
    }

    private void mostrarImagenPaketaxo() {
        int imageResource = 0;


        if (boxChetosAzules.isChecked() && boxChetosPalomitas.isChecked() &&
                boxCrujitosQueso.isChecked() && boxDoritos3D.isChecked()) {
            imageResource = R.drawable.pka;
        } else if (boxFritos.isChecked() && boxChetosBolitas.isChecked() &&
                boxRancheritos.isChecked() && boxSabritones.isChecked()) {
            imageResource = R.drawable.pkam;
        } else if (boxChurrumais.isChecked() && boxCrujitosFH.isChecked() &&
                boxSabritonesR.isChecked() && boxChetosAzules.isChecked()) {
            imageResource = R.drawable.pkv;
        } else if (boxDoritos3DFH.isChecked() && boxTostitosFH.isChecked() &&
                boxChetosFH.isChecked() && boxSabritonesR.isChecked()) {
            imageResource = R.drawable.pkm;
        } else if (boxChetosPFH.isChecked() && boxDoritosIncognitos.isChecked() &&
                boxChetosColmillos.isChecked() && boxChurrumaisF.isChecked()) {
            imageResource = R.drawable.pkd;
        } else {
            imageResource = R.drawable.error;
        }


        Log.d("MainActivity", "Imagen seleccionada: " + imageResource);


        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("imageResource", imageResource);
        startActivity(intent);
    }
}
