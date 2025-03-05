package com.example.app6;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    ImageView Imagen;
    Button BTN2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Imagen = findViewById(R.id.Imagen);
        BTN2 = findViewById(R.id.BTN2);

        // Obtener el valor del Intent
        Intent intent = getIntent();
        int imageResource = intent.getIntExtra("imageResource", R.drawable.error); // Usar la misma clave

        // Asegúrate de que no haya un valor no válido para la imagen
        if (imageResource != 0) {
            Imagen.setImageResource(imageResource);
        } else {
            Imagen.setImageResource(R.drawable.error);  // Si no se pasa la imagen, muestra un error
        }

        BTN2.setOnClickListener(v -> {
            // Regresar a la MainActivity
            Intent returnIntent = new Intent(SecondActivity.this, MainActivity.class);
            startActivity(returnIntent);
        });
    }
}