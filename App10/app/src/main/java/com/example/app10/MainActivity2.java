package com.example.actividad02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView View01;
    EditText Edit01;
    Button aceptarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        View01 = findViewById(R.id.View01);

        Edit01 = findViewById(R.id.Edit01);

        aceptarButton = findViewById(R.id.aceptarButton);


        if (savedInstanceState != null) {
            String TextString = savedInstanceState.getString("textoGuardado", "");
            View01.setText(TextString);
        }

        aceptarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String TextString = Edit01.getText().toString();
                View01.setText(TextString);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("textoGuardado", View01.getText().toString());
    }
}
