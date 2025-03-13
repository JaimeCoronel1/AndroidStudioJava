package com.example.app5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    CheckBox chCafe, chAgua, chChocolate, chLeche, chVainilla;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        chCafe = findViewById(R.id.chCafe);
        chAgua = findViewById(R.id.chAgua);
        chChocolate = findViewById(R.id.chChocolate);
        chLeche = findViewById(R.id.chLeche);
        chVainilla = findViewById(R.id.chVainilla);

        btn1 = findViewById(R.id.btn1);


        btn1.setOnClickListener(view -> {

            String tipoCafe = determinarCafe(chCafe, chAgua, chLeche, chChocolate, chVainilla);

            if (tipoCafe.equals("Desconocido")) {
                Toast.makeText(this, "No existe un café con esos ingredientes", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("tipoCafe", tipoCafe);
            startActivity(intent);
        });
    }

    private String determinarCafe(CheckBox cafe, CheckBox agua, CheckBox leche, CheckBox chocolate, CheckBox vainilla) {

        if (cafe.isChecked() && agua.isChecked() && leche.isChecked() && chocolate.isChecked()) {
            return "Moccha";
        } else if (cafe.isChecked() && agua.isChecked() && leche.isChecked()) {
            return "Latte";
        } else if (cafe.isChecked() && agua.isChecked() && vainilla.isChecked()) {
            return "Capuccino";
        } else if (cafe.isChecked() && agua.isChecked()) {
            return "Americano";
        }
        return "Desconocido";
    }
}

