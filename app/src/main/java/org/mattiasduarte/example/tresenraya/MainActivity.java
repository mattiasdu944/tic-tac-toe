package org.mattiasduarte.example.tresenraya;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int puntajeJugador1 = 0;
    private int puntajeJugador2 = 0;
    private TextView ganadorTextView;
    private TextView jugador1TextView;
    private TextView jugador2TextView;
    private Button reiniciarButton;

    Integer[] fichas;
    int[] tablero = new int[]{
            0, 0, 0,
            0, 0, 0,
            0, 0, 0
    };

    int[] jugadaGanadora = new int []{-1, -1, -1};

    private enum STATE { END, GAMING };
    private enum TURNO { JUGADOR1, JUGADOR2 };
    private STATE state = STATE.GAMING;
    private TURNO turno = TURNO.JUGADOR1;

    private int ficha = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ganadorTextView = findViewById(R.id.ganadorTextView);
        reiniciarButton = findViewById(R.id.reiniciarButton);
        reiniciarButton.setVisibility(View.INVISIBLE);

        fichas = new Integer[]{
            R.id.button, R.id.button2, R.id.button3,
            R.id.button4, R.id.button5, R.id.button6,
            R.id.button7, R.id.button8, R.id.button9,
        };

        jugador1TextView = findViewById(R.id.jugador1TextView);
        jugador1TextView.setText(getString( R.string.puntaje1, puntajeJugador1 ));

        jugador2TextView = findViewById(R.id.jugador2TextView);
        jugador2TextView.setText(getString( R.string.puntaje2, puntajeJugador2 ));

    }
    public void colocarFicha(View v){
        if (state == STATE.GAMING) {
            if (turno == TURNO.JUGADOR1) {
                turnoJugador1(v);
                turno = TURNO.JUGADOR2;
                verificarVictoria();
                return;
            }
            if (turno == TURNO.JUGADOR2) {
                turnoJugador2(v);
                turno = TURNO.JUGADOR1;
                verificarVictoria();
                return;
            }
        }
    }

    private void turnoJugador1(View v){
        int indexBoton = Arrays.asList(fichas).indexOf(v.getId());
        puntajeJugador1 += 1;
        jugador1TextView.setText(getString( R.string.puntaje1, puntajeJugador1 ));
        v.setBackgroundResource(R.drawable.cruz);
        tablero[indexBoton] = 1;
        ficha += 1;
    }

    private void turnoJugador2(View v){
        int indexBoton = Arrays.asList(fichas).indexOf(v.getId());
        puntajeJugador2 += 1;
        jugador2TextView.setText(getString( R.string.puntaje2, puntajeJugador2 ));
        v.setBackgroundResource(R.drawable.circle);
        tablero[indexBoton] = -1;
        ficha += 1;
    }

    private void verificarVictoria(){

        LottieAnimationView animationLottieView = findViewById(R.id.animationLottieView);


        //VERIFICAR SI GANO POR FILA
        if( Math.abs( tablero[0] + tablero[1] + tablero[2] ) == 3 ){
            state = STATE.END;
            animationLottieView.setAnimation(R.raw.win);
            reiniciarButton.setVisibility(View.VISIBLE);
            if( turno == TURNO.JUGADOR1 ){
                ganadorTextView.setText("Gano el jugador 2");
                state = STATE.END;
            }
            if( turno == TURNO.JUGADOR2 ){
                ganadorTextView.setText("Gano el jugador 1");
                state = STATE.END;
            }
        }

        if( Math.abs( tablero[3] + tablero[4] + tablero[5] ) == 3 ){
            state = STATE.END;
            animationLottieView.setAnimation(R.raw.win);
            reiniciarButton.setVisibility(View.VISIBLE);
            if( turno == TURNO.JUGADOR1 ){
                ganadorTextView.setText("Gano el jugador 2");
                state = STATE.END;
            }
            if( turno == TURNO.JUGADOR2 ){
                ganadorTextView.setText("Gano el jugador 1");
                state = STATE.END;
            }
        }

        if( Math.abs( tablero[6] + tablero[7] + tablero[8] ) == 3 ){
            state = STATE.END;
            animationLottieView.setAnimation(R.raw.win);
            reiniciarButton.setVisibility(View.VISIBLE);
            if( turno == TURNO.JUGADOR1 ){
                ganadorTextView.setText("Gano el jugador 2");
                state = STATE.END;
            }
            if( turno == TURNO.JUGADOR2 ){
                ganadorTextView.setText("Gano el jugador 1");
                state = STATE.END;
            }
        }

        //VERIFICAR SI GANO POR COLUMNA
        if( Math.abs( tablero[0] + tablero[3] + tablero[6] ) == 3 ){
            state = STATE.END;
            animationLottieView.setAnimation(R.raw.win);
            reiniciarButton.setVisibility(View.VISIBLE);
            if( turno == TURNO.JUGADOR1 ){
                ganadorTextView.setText("Gano el jugador 2");
                state = STATE.END;
            }
            if( turno == TURNO.JUGADOR2 ){
                ganadorTextView.setText("Gano el jugador 1");
                state = STATE.END;
            }
        }

        if( Math.abs( tablero[1] + tablero[4] + tablero[7] ) == 3 ){
            state = STATE.END;
            animationLottieView.setAnimation(R.raw.win);
            reiniciarButton.setVisibility(View.VISIBLE);
            if( turno == TURNO.JUGADOR1 ){
                ganadorTextView.setText("Gano el jugador 2");
                state = STATE.END;
            }
            if( turno == TURNO.JUGADOR2 ){
                ganadorTextView.setText("Gano el jugador 1");
                state = STATE.END;
            }
        }

        if( Math.abs( tablero[2] + tablero[5] + tablero[8] ) == 3 ){
            state = STATE.END;
            animationLottieView.setAnimation(R.raw.win);
            reiniciarButton.setVisibility(View.VISIBLE);
            if( turno == TURNO.JUGADOR1 ){
                ganadorTextView.setText("Gano el jugador 2");
                state = STATE.END;
            }
            if( turno == TURNO.JUGADOR2 ){
                ganadorTextView.setText("Gano el jugador 1");
                state = STATE.END;
            }
        }

        //VERIFICAR SI GANO POR DIAGONAL
        if( Math.abs( tablero[0] + tablero[4] + tablero[8] ) == 3 ){
            state = STATE.END;
            animationLottieView.setAnimation(R.raw.win);
            reiniciarButton.setVisibility(View.VISIBLE);
            if( turno == TURNO.JUGADOR1 ){
                ganadorTextView.setText("Gano el jugador 2");
                state = STATE.END;
            }
            if( turno == TURNO.JUGADOR2 ){
                ganadorTextView.setText("Gano el jugador 1");
                state = STATE.END;
            }
        }

        if( Math.abs( tablero[2] + tablero[4] + tablero[6] ) == 3 ){
            state = STATE.END;
            animationLottieView.setAnimation(R.raw.win);
            reiniciarButton.setVisibility(View.VISIBLE);
            if( turno == TURNO.JUGADOR1 ){
                ganadorTextView.setText("Gano el jugador 2");
                state = STATE.END;
            }
            if( turno == TURNO.JUGADOR2 ){
                ganadorTextView.setText("Gano el jugador 1");
                state = STATE.END;
            }
        }

        if( ficha == 9){
            state = STATE.END;
            reiniciarButton.setVisibility(View.VISIBLE);
            animationLottieView.setAnimation(R.raw.over);
            ganadorTextView.setText("Ambos jugadores empataron");

        }
    }
}