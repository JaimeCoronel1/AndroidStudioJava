package com.example.aplicacionj32;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView txtOnCreate, txtOnStart, txtOnStop, txtOnPause, txtOnResume, txtOnDestroy, txtOnRestart, txtOnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        txtOnCreate = findViewById(R.id.txtOnCreate);
        txtOnStart = findViewById(R.id.txtOnStart);
        txtOnStop = findViewById(R.id.txtOnStop);
        txtOnPause = findViewById(R.id.txtOnPause);
        txtOnResume = findViewById(R.id.txtOnResume);
        txtOnDestroy = findViewById(R.id.txtOnDestroy);
        txtOnRestart = findViewById(R.id.txtOnRestart);
        txtOnClick = findViewById(R.id.txtOnClick);


        Log.d("onCreate", "Método onCreate ejecutado");
        txtOnCreate.setText("Método onCreate");

        Button btnMostrar = findViewById(R.id.BTN1);
        btnMostrar.setOnClickListener(v -> Log.d("BtnClick", "Botón presionado"));
        btnMostrar.setOnClickListener(v -> txtOnClick.setText("Botón presionado"));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("onStart", "Método onStart ejecutado");
        if (txtOnStart != null) txtOnStart.setText("Método onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("onResume", "Método onResume ejecutado");
        if (txtOnResume != null) txtOnResume.setText("Método onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("onPause", "Método onPause ejecutado");
        if (txtOnPause != null) txtOnPause.setText("Método onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("onStop", "Método onStop ejecutado");
        if (txtOnStop != null) txtOnStop.setText("Método onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("onDestroy", "Método onDestroy ejecutado");
        if (txtOnDestroy != null) txtOnDestroy.setText("Método onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("onRestart", "Método onRestart ejecutado");
        if (txtOnRestart != null) txtOnRestart.setText("Método onRestart");
    }
}