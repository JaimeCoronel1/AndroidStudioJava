package com.example.appj4;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    EditText txtEdit1;
    EditText txtEdit2;
    EditText txtEdit3;

    Button Button1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtEdit1 = findViewById(R.id.txtEdit1);

        txtEdit2 = findViewById(R.id.txtEdit2);

        txtEdit3 = findViewById(R.id.txtEdit3);

        Button1 = findViewById(R.id.Button1);


    }

    public void IrActivity2(View view) {
        String Nombre = txtEdit1.getText().toString();
        String Carrera = txtEdit2.getText().toString();
        String Grupo = txtEdit3.getText().toString();

        if(!Nombre.isEmpty() && !Carrera.isEmpty() && !Grupo.isEmpty()) {
            Intent pantalla2 = new Intent(this, MainActivity2.class);
            pantalla2.putExtra("Nombre", Nombre);
            pantalla2.putExtra("Carrera", Carrera);
            pantalla2.putExtra("Grupo", Grupo);
            startActivity(pantalla2);
        }
    }
}