package com.example.app8;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    TextView txtAlumnoNombre;
    Button BTN2;
    TableLayout TablaL1;

    @SuppressLint("MissingInflatedId")
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


        txtAlumnoNombre = findViewById(R.id.txtAlumnoNombre);
        BTN2 = findViewById(R.id.BTN2);
        TablaL1 = findViewById(R.id.TablaL1);


        Intent intent = getIntent();
        String nombreAlumno = intent.getStringExtra("Alumno");
        String fase = intent.getStringExtra("Fase");


        txtAlumnoNombre.setText(String.format("Alumno: %s", nombreAlumno));


        if (fase != null) {
            String[][] horario;

            if (fase.equals("Programación")) {
                horario = new String[][]{
                        {"08:00 - 08:50 AM", "Derecho Informático", "M.C Delma Lidia Mendoza Tirado"},
                        {"08:50 - 09:40 AM", "Sistemas de información geográfica", "Lic. Erik Iván Sánchez Valdez"},
                        {"09:40 - 10:30 AM", "Desarrollo de aplicaciones móviles", "Dr. Juan Jose Rodriguez Malpica Garcia"},
                        {"10:30 - 11:20 AM", "Programación de videojuegos", "Prof. Ulises Zaldívar colado"},
                        {"11:20 - 12:10 PM", "Administración de páginas web", "Dr. Juan Francisco Peraza Garzón"},
                        {"12:10 - 1:00 PM", "Interacción Hombre-Máquina", "Lic. Esteban Bernal Malagon"}
                };
            } else if (fase.equals("Redes")) {
                horario = new String[][]{
                        {"08:00 - 08:50 AM", "Derecho Informático", "M.C Delma Lidia Mendoza Tirado"},
                        {"08:50 - 09:40 AM", "Innovaciones Tecnológicas", "Dr. Jose Alfonso Aguilar Calderon"},
                        {"09:40 - 10:30 AM", "Desarrollo de Aplicaciones Móviles", "M.C Juan Jose Rodriguez Malpica Garcia"},
                        {"10:30 - 11:20 AM", "Sistemas Operativos", "Lic. Alan Segura Rojo"},
                        {"11:20 - 12:10 PM", "Telemática 2", "Lic. Esteban Bernal"},
                        {"12:10 - 1:00 PM", "Interacción Hombre-Máquina", "Lic. Esteban Bernal"}
                };
            } else {
                horario = new String[][]{};
            }


            for (String[] row : horario) {
                TableRow tablaRow = new TableRow(this);

                TextView horarioText = new TextView(this);
                horarioText.setText(row[0]);
                horarioText.setTextSize(14);
                horarioText.setPadding(90, 16, 16, 16);
                horarioText.setGravity(Gravity.CENTER);
                horarioText.setTextColor(Color.BLACK);
                horarioText.setBackgroundColor(Color.parseColor("#FFFFFF"));

                TextView materiaText = new TextView(this);
                materiaText.setText(row[1]);
                materiaText.setTextSize(14);
                materiaText.setPadding(90, 16, 16, 16);
                materiaText.setGravity(Gravity.CENTER);
                materiaText.setTextColor(Color.BLACK);
                materiaText.setBackgroundColor(Color.parseColor("#FFFFFF"));

                TextView docente = new TextView(this);
                docente.setText(row[2]);
                docente.setTextSize(14);
                docente.setPadding(90, 16, 16, 16);
                docente.setGravity(Gravity.CENTER);
                docente.setTextColor(Color.BLACK);
                docente.setBackgroundColor(Color.parseColor("#FFFFFF"));

                tablaRow.addView(horarioText);
                tablaRow.addView(materiaText);
                tablaRow.addView(docente);

                TablaL1.addView(tablaRow);
            }
        }
        BTN2.setOnClickListener(v -> finish());
    }
}