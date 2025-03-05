package com.example.appj4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    TextView txtView1;
    TextView txtView2;
    TextView txtView3;

    Button Button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtView1 = findViewById(R.id.txtView1);

        txtView2 = findViewById(R.id.txtView2);

        txtView3 = findViewById(R.id.txtView3);

        Button2 = findViewById(R.id.Button2);

        Bundle datos = getIntent().getExtras();
        assert datos != null;
        txtView1.setText(datos.getString("Nombre"));
        txtView2.setText(datos.getString("Carrera"));
        txtView3.setText(datos.getString("Grupo"));


    }

    public void IrActivity1(View view) {

        Intent pantalla1 = new Intent(this, MainActivity.class);
        startActivity(pantalla1);

    }
}