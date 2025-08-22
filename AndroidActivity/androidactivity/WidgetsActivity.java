package com.example.androidactivity;



import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;
import android.widget.MediaController; // Importar MediaController para controlar el video

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.chip.Chip;

public class WidgetsActivity extends AppCompatActivity {

    private Chip myChip;
    private VideoView videoView;
    private TextView chipMessageTextView;
    private TextView textView5; // El TextView que está debajo del VideoView
    private Button regresarButton;
    private int clickCount = 0; // Para llevar la cuenta de los clics en el Chip

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widgets);


        myChip = findViewById(R.id.myChip);
        videoView = findViewById(R.id.videoView);
        chipMessageTextView = findViewById(R.id.chipMessageTextView);
        textView5 = findViewById(R.id.textView5);
        regresarButton = findViewById(R.id.btnRegresar);


        videoView.setVisibility(View.GONE);
        chipMessageTextView.setVisibility(View.GONE);
        textView5.setVisibility(View.GONE);


        myChip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount++;

                if (clickCount == 1) {
                    chipMessageTextView.setText("¡Estás feliz!");
                    chipMessageTextView.setVisibility(View.VISIBLE);


                    videoView.setVisibility(View.VISIBLE);
                    playVideo(); // Llama al método para reproducir el video


                    textView5.setText("Que tengas buen día");
                    textView5.setVisibility(View.VISIBLE);

                } else if (clickCount == 2) {
                    chipMessageTextView.setText("¡Estás más feliz!");
                }

            }
        });


        regresarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WidgetsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    // Método para reproducir el video
    private void playVideo() {

        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.videofeliz;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);


        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        videoView.start();
    }
}