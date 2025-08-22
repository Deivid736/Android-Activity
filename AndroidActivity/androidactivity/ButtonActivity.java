package com.example.androidactivity;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class ButtonActivity extends AppCompatActivity {

    private Button saludarButton;
    private Button regresarButton;
    private TextView saludoTextView;
    private ImageView imageView;
    private TextView mensajeFinalTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);


        saludarButton = findViewById(R.id.buttonSaludar);
        regresarButton = findViewById(R.id.btnRegresar);
        saludoTextView = findViewById(R.id.textViewSaludo);
        imageView = findViewById(R.id.imageView);
        mensajeFinalTextView = findViewById(R.id.textViewMensajeFinal);


        saludoTextView.setVisibility(View.GONE);
        imageView.setVisibility(View.GONE);
        mensajeFinalTextView.setVisibility(View.GONE);


        saludarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Actualiza el texto y hace visibles los elementos
                saludoTextView.setText("Hola, bienvenido.");
                saludoTextView.setVisibility(View.VISIBLE);
                imageView.setVisibility(View.VISIBLE);
                mensajeFinalTextView.setText("Que tengas buen día.");
                mensajeFinalTextView.setVisibility(View.VISIBLE);
            }
        });


        regresarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ButtonActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Cierra esta actividad para no regresar a ella con el botón de atrás
            }
        });
    }
}