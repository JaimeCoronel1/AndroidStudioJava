package com.example.app10k

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity9 : AppCompatActivity() {
    var comboBox: Spinner? = null
    var txtFaseAlumno: TextView? = null
    var BTN1: Button? = null
    var editTextCorreo: EditText? = null

    var BTNR9: Button? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_main9)
        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.main)
        ) { v: View, insets: WindowInsetsCompat ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        comboBox = findViewById(R.id.spinnerAlumnos)
        txtFaseAlumno = findViewById(R.id.txtFaseAlumno)
        BTN1 = findViewById(R.id.BTN1)
        editTextCorreo = findViewById(R.id.editTextCorreo)
        BTNR9 = findViewById(R.id.BTNR9)
        BTNR9?.setOnClickListener(View.OnClickListener { v: View? -> regresarAOriginal() })

        val lista = arrayOf(
            "Selecciona un Alumno",
            "Jaime Coronel Benitez",
            "Heber Eduardo Guzman Tapia",
            "Jose David Santana Esparza",
            "Danna Paola Butchart Iribe",
            "Jesus Manuel Valverde Perez"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, lista)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        comboBox?.setAdapter(adapter)

        comboBox?.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                val nombre = parent.getItemAtPosition(position).toString()

                if (nombre == "Danna Paola Butchart Iribe" || nombre == "Heber Eduardo Guzman Tapia") {
                    txtFaseAlumno?.setText("Redes")
                } else if (nombre == "Jose David Santana Esparza" || nombre == "Jesus Manuel Valverde Perez" || nombre == "Jaime Coronel Benitez") {
                    txtFaseAlumno?.setText("Programación")
                } else {
                    txtFaseAlumno?.setText("")
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        })
    }

    fun enviar(view: View?) {
        val nombre = comboBox!!.selectedItem.toString()
        val nombreApp = getString(R.string.app_name) + "_JaimeCoronel"
        val asunto = "Horario de la Fase - $nombreApp"
        val fase = txtFaseAlumno!!.text.toString()
        val correoDestinatario = editTextCorreo!!.text.toString()

        if (nombre != "Selecciona un Alumno") {
            if (!fase.isEmpty()) {
                if (!correoDestinatario.isEmpty()) {
                    val horario = if (fase == "Programación") {
                        arrayOf(
                            arrayOf(
                                "08:00 - 08:50 AM",
                                "Derecho Informático",
                                "M.C Delma Lidia Mendoza Tirado"
                            ),
                            arrayOf(
                                "08:50 - 09:40 AM",
                                "Sistemas de información geográfica",
                                "Lic. Erik Iván Sánchez Valdez"
                            ),
                            arrayOf(
                                "09:40 - 10:30 AM",
                                "Desarrollo de aplicaciones móviles",
                                "Dr. Juan Jose Rodriguez Malpica Garcia"
                            ),
                            arrayOf(
                                "10:30 - 11:20 AM",
                                "Programación de videojuegos",
                                "Prof. Ulises Zaldívar colado"
                            ),
                            arrayOf(
                                "11:20 - 12:10 PM",
                                "Administración de páginas web",
                                "Dr. Juan Francisco Peraza Garzón"
                            ),
                            arrayOf(
                                "12:10 - 1:00 PM",
                                "Interacción Hombre-Máquina",
                                "Lic. Esteban Bernal Malagon"
                            )
                        )
                    } else {
                        arrayOf(
                            arrayOf(
                                "08:00 - 08:50 AM",
                                "Derecho Informático",
                                "M.C Delma Lidia Mendoza Tirado"
                            ),
                            arrayOf(
                                "08:50 - 09:40 AM",
                                "Innovaciones Tecnológicas",
                                "Dr. Jose Alfonso Aguilar Calderon"
                            ),
                            arrayOf(
                                "09:40 - 10:30 AM",
                                "Desarrollo de Aplicaciones Móviles",
                                "M.C Juan Jose Rodriguez Malpica Garcia"
                            ),
                            arrayOf(
                                "10:30 - 11:20 AM",
                                "Sistemas Operativos",
                                "Lic. Alan Segura Rojo"
                            ),
                            arrayOf(
                                "11:20 - 12:10 PM",
                                "Telemática 2",
                                "Lic. Esteban Bernal"
                            ),
                            arrayOf(
                                "12:10 - 1:00 PM",
                                "Interacción Hombre-Máquina",
                                "Lic. Esteban Bernal"
                            )
                        )
                    }

                    val mensajeMarkdown = StringBuilder()
                    mensajeMarkdown.append("**Horario de la fase de ").append(nombre)
                        .append(":**\n\n")
                    mensajeMarkdown.append("| Hora | Materia | Profesor |\n")
                    mensajeMarkdown.append("|-------------------------------|\n")

                    for (fila in horario) {
                        mensajeMarkdown.append("| ").append(fila[0]).append(" | ").append(fila[1])
                            .append(" | ").append(
                                fila[2]
                            ).append(" |\n")
                    }

                    mensajeMarkdown.append("\nSaludos,\n").append(nombreApp)

                    val intent = Intent(Intent.ACTION_SEND)
                    intent.setType("text/plain")
                    intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(correoDestinatario))
                    intent.putExtra(Intent.EXTRA_SUBJECT, asunto)
                    intent.putExtra(Intent.EXTRA_TEXT, mensajeMarkdown.toString())

                    try {
                        startActivity(Intent.createChooser(intent, "Enviar correo con..."))
                    } catch (e: ActivityNotFoundException) {
                        Toast.makeText(
                            this,
                            "No hay aplicaciones de correo instaladas.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    Toast.makeText(
                        this,
                        "Por favor ingresa un correo electrónico",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Toast.makeText(this, "No hay fase asignada", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Por favor selecciona un integrante", Toast.LENGTH_SHORT).show()
        }
    }

    private fun regresarAOriginal() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}