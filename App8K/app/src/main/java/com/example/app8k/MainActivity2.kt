package com.example.app8k

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    var txtAlumnoNombre: TextView? = null
    var BTN2: Button? = null
    var TablaL1: TableLayout? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.main)
        ) { v: View, insets: WindowInsetsCompat ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        txtAlumnoNombre = findViewById(R.id.txtAlumnoNombre)
        BTN2 = findViewById(R.id.BTN2)
        TablaL1 = findViewById(R.id.TablaL1)


        val intent = intent
        val nombreAlumno = intent.getStringExtra("Alumno")
        val fase = intent.getStringExtra("Fase")


        txtAlumnoNombre.setText(String.format("Alumno: %s", nombreAlumno))


        if (fase != null) {
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
            } else if (fase == "Redes") {
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
            } else {
                arrayOf()
            }


            for (row in horario) {
                val tablaRow = TableRow(this)

                val horarioText = TextView(this)
                horarioText.text = row[0]
                horarioText.textSize = 14f
                horarioText.setPadding(90, 16, 16, 16)
                horarioText.gravity = Gravity.CENTER
                horarioText.setTextColor(Color.BLACK)
                horarioText.setBackgroundColor(Color.parseColor("#FFFFFF"))

                val materiaText = TextView(this)
                materiaText.text = row[1]
                materiaText.textSize = 14f
                materiaText.setPadding(90, 16, 16, 16)
                materiaText.gravity = Gravity.CENTER
                materiaText.setTextColor(Color.BLACK)
                materiaText.setBackgroundColor(Color.parseColor("#FFFFFF"))

                val docente = TextView(this)
                docente.text = row[2]
                docente.textSize = 14f
                docente.setPadding(90, 16, 16, 16)
                docente.gravity = Gravity.CENTER
                docente.setTextColor(Color.BLACK)
                docente.setBackgroundColor(Color.parseColor("#FFFFFF"))

                tablaRow.addView(horarioText)
                tablaRow.addView(materiaText)
                tablaRow.addView(docente)

                TablaL1.addView(tablaRow)
            }
        }
        BTN2.setOnClickListener(View.OnClickListener { v: View? -> finish() })
    }
}