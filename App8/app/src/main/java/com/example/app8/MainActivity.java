package com.example.app8;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Spinner BoxCombo1;
    private TextView txtAlumnofase;
    private Button BTN1;

    @SuppressLint("MissingInflatedId")
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

        BoxCombo1 = findViewById(R.id.BoxCombo1);

        txtAlumnofase = findViewById(R.id.txtAlumnofase);

        BTN1 = findViewById(R.id.BTN1);


        String[] lista = {
                "Selecciona un Alumno",
                "Danna Paola Butchart Iribe",
                "Heber Eduardo Guzman Tapia",
                "Jose David Santana Esparza",
                "Jesus Manuel Valverde Perez",
                "Jaime Coronel Benitez"
        };


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, lista);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        BoxCombo1.setAdapter(adapter);


        BoxCombo1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String nombre = parent.getItemAtPosition(position).toString();


                if (nombre.equals("Heber Eduardo Guzman Tapia") || nombre.equals("Danna Paola Butchart Iribe")) {
                    txtAlumnofase.setText("Redes");
                } else if (nombre.equals("Jesus Manuel Valverde Perez") || nombre.equals("Jaime Coronel Benitez") || nombre.equals("Jose David Santana Esparza")) {
                    txtAlumnofase.setText("Programación");
                } else {
                    txtAlumnofase.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        BTN1.setOnClickListener(v -> {
            String nombre = BoxCombo1.getSelectedItem().toString();
            if (!nombre.equals("Selecciona un Alumno")) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("Alumno", nombre);
                intent.putExtra("Fase", txtAlumnofase.getText().toString());
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "Seleccione un estudiante", Toast.LENGTH_SHORT).show();
            }
        });
    }
}