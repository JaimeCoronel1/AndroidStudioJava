package com.example.actividad03;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("onCreate", "metodo onCreate.");
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }


    protected void onStart() {
        super.onStart();
        Log.i("onStart", "metodo onStart.");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("onResume", "metodo onResume.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("onPause", "metodo onPause.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("onStop", "metodo onStop.");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("onRestart", "metodo onRestart.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("onDestroy", "metodo onDestroy.");
    }
}