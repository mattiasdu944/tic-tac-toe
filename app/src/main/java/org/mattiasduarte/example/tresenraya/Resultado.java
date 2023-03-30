package org.mattiasduarte.example.tresenraya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;


public class Resultado extends AppCompatActivity {

    private TextView ganadorTextView;
    private Button reiniciarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Intent i = getIntent();


        LottieAnimationView animationLottieView = findViewById(R.id.animationLottieView);

        reiniciarButton = findViewById(R.id.reiniciarButton);
        reiniciarButton.setOnClickListener(reiniciarJuego);

        int ganador = i.getIntExtra(MainActivity.GANADOR, 0);
        ganadorTextView = findViewById(R.id.ganadorTextView);

        if( ganador == 1 ){
            ganadorTextView.setText("¡El jugador 1 gano la partida!");
            animationLottieView.setAnimation(R.raw.win);
        } else if ( ganador == 2 ) {
            ganadorTextView.setText("¡El jugador 2 gano la partida!");
            animationLottieView.setAnimation(R.raw.win);

        }else {
            ganadorTextView.setText("Ambos jugadores empataron");
            animationLottieView.setAnimation(R.raw.over);

        }

    }

    private final View.OnClickListener reiniciarJuego = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(Resultado.this, MainActivity.class);
            startActivity(i);
        }
    };
}