package org.mattiasduarte.example.tresenraya;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button empezarJuego;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        empezarJuego = findViewById(R.id.jugarButton);
        empezarJuego.setOnClickListener(reiniciarJuego);
    }


    private final View.OnClickListener reiniciarJuego = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(MainActivity.this, JuegoActivity.class);
            startActivity(i);
        }
    };

}