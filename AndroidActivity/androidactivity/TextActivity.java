package com.example.androidactivity;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TextActivity extends AppCompatActivity {

    private EditText nombresEditText;
    private EditText apellidosEditText;
    private EditText correoEditText;
    private EditText contrasenaEditText;
    private Button iniciarButton;
    private Button regresarButton;
    private TextView resultadoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);


        nombresEditText = findViewById(R.id.editTextText);
        apellidosEditText = findViewById(R.id.editTextText2);
        correoEditText = findViewById(R.id.editTextTextEmailAddress);
        contrasenaEditText = findViewById(R.id.editTextTextPassword);
        iniciarButton = findViewById(R.id.btnIniciar);
        resultadoTextView = findViewById(R.id.textView8);
        regresarButton = findViewById(R.id.btnRegresar);


        iniciarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombres = nombresEditText.getText().toString().trim();
                String apellidos = apellidosEditText.getText().toString().trim();
                String correo = correoEditText.getText().toString().trim();
                String contrasena = contrasenaEditText.getText().toString().trim();

                if (nombres.isEmpty() || apellidos.isEmpty() || correo.isEmpty() || contrasena.isEmpty()) {
                    Toast.makeText(TextActivity.this, "Por favor, completa todos los campos.", Toast.LENGTH_SHORT).show();
                    resultadoTextView.setText("Error: campos vacíos.");
                } else {
                    resultadoTextView.setText("¡Felicidades, el programa funcionó correctamente!");
                }
            }
        });


        regresarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TextActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}