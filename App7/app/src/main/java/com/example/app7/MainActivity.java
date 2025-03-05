package com.example.app7;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.app7.R;

public class MainActivity extends AppCompatActivity {

    private EditText txtEdit;
    private TextView View1;
    private RadioButton radioTemperatura, radioDolar;
    private Button BTN1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtEdit = findViewById(R.id.txtEdit);
        View1 = findViewById(R.id.View1);
        radioTemperatura = findViewById(R.id.radioTemperatura);
        radioDolar = findViewById(R.id.radioDolar);
        BTN1 = findViewById(R.id.BTN1);

        BTN1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convert();
            }
        });
    }

    private void convert() {
        String input = txtEdit.getText().toString();
        if (input.isEmpty()) {
            View1.setText("Por favor, ingrese un valor");
            return;
        }

        double value = Double.parseDouble(input);
        double result;

        if (radioTemperatura.isChecked()) {
            result = (value * 9/5) + 32;
            View1.setText("Resultado: " + result + " °F");
        } else if (radioDolar.isChecked()) {
            double exchangeRate = 20;
            result = value / exchangeRate;
            View1.setText("Resultado: $" + result + " USD");
        } else {
            View1.setText("Seleccione una opción de conversión");
        }
    }
}