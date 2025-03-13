package com.example.app9;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

     Spinner comboBox;
     TextView txtFaseAlumno;
     Button BTN1;
     EditText editTextCorreo;

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

        comboBox = findViewById(R.id.spinnerAlumnos);
        txtFaseAlumno = findViewById(R.id.txtFaseAlumno);
        BTN1 = findViewById(R.id.BTN1);
        editTextCorreo = findViewById(R.id.editTextCorreo);

        String[] lista = {
                "Selecciona un Alumno",
                "Jaime Coronel Benitez",
                "Heber Eduardo Guzman Tapia",
                "Jose David Santana Esparza",
                "Danna Paola Butchart Iribe",
                "Jesus Manuel Valverde Perez"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, lista);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        comboBox.setAdapter(adapter);

        comboBox.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String nombre = parent.getItemAtPosition(position).toString();

                if (nombre.equals("Danna Paola Butchart Iribe") || nombre.equals("Heber Eduardo Guzman Tapia")) {
                    txtFaseAlumno.setText("Redes");
                } else if (nombre.equals("Jose David Santana Esparza") || nombre.equals("Jesus Manuel Valverde Perez") || nombre.equals("Jaime Coronel Benitez")) {
                    txtFaseAlumno.setText("Programación");
                } else {
                    txtFaseAlumno.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void enviar(View view) {
        String nombre = comboBox.getSelectedItem().toString();
        String nombreApp = getString(R.string.app_name) + "_JaimeCoronel";
        String asunto = "Horario de la Fase - " + nombreApp;
        String fase = txtFaseAlumno.getText().toString();
        String correoDestinatario = editTextCorreo.getText().toString();

        if (!nombre.equals("Selecciona un Alumno")) {
            if (!fase.isEmpty()) {
                if (!correoDestinatario.isEmpty()) {
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
                    } else {
                        horario = new String[][]{
                                {"08:00 - 08:50 AM", "Derecho Informático", "M.C Delma Lidia Mendoza Tirado"},
                                {"08:50 - 09:40 AM", "Innovaciones Tecnológicas", "Dr. Jose Alfonso Aguilar Calderon"},
                                {"09:40 - 10:30 AM", "Desarrollo de Aplicaciones Móviles", "M.C Juan Jose Rodriguez Malpica Garcia"},
                                {"10:30 - 11:20 AM", "Sistemas Operativos", "Lic. Alan Segura Rojo"},
                                {"11:20 - 12:10 PM", "Telemática 2", "Lic. Esteban Bernal"},
                                {"12:10 - 1:00 PM", "Interacción Hombre-Máquina", "Lic. Esteban Bernal"}
                        };
                    }

                    StringBuilder mensajeMarkdown = new StringBuilder();
                    mensajeMarkdown.append("**Horario de la fase de ").append(nombre).append(":**\n\n");
                    mensajeMarkdown.append("| Hora | Materia | Profesor |\n");
                    mensajeMarkdown.append("|-------------------------------|\n");

                    for (String[] fila : horario) {
                        mensajeMarkdown.append("| ").append(fila[0]).append(" | ").append(fila[1]).append(" | ").append(fila[2]).append(" |\n");
                    }

                    mensajeMarkdown.append("\nSaludos,\n").append(nombreApp);

                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{correoDestinatario});
                    intent.putExtra(Intent.EXTRA_SUBJECT, asunto);
                    intent.putExtra(Intent.EXTRA_TEXT, mensajeMarkdown.toString());

                    try {
                        startActivity(Intent.createChooser(intent, "Enviar correo con..."));
                    } catch (android.content.ActivityNotFoundException e) {
                        Toast.makeText(this, "No hay aplicaciones de correo instaladas.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Por favor ingresa un correo electrónico", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(MainActivity.this, "No hay fase asignada", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(MainActivity.this, "Por favor selecciona un integrante", Toast.LENGTH_SHORT).show();
        }
    }
}