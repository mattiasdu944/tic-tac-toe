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

    private int puntajeJugador1 = 0;
    private int puntajeJugador2 = 0;
    private TextView jugador1TextView;
    private TextView jugador2TextView;

    public static final String GANADOR= "org.mattiasduarte.example.tresenraya.MENSAJE";

    Integer[] fichas;
    int[] tablero = new int[]{
            0, 0, 0,
            0, 0, 0,
            0, 0, 0
    };

    private enum STATE { END, GAMING };
    private enum TURNO { JUGADOR1, JUGADOR2 };
    private STATE state = STATE.GAMING;
    private TURNO turno = TURNO.JUGADOR1;

    private int ficha = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                verificarVictoria();
                return;
            }
            if (turno == TURNO.JUGADOR2) {
                turnoJugador2(v);
                verificarVictoria();
                return;
            }
        }
    }

    private void turnoJugador1(View v){
        int indexBoton = Arrays.asList(fichas).indexOf(v.getId());
        if( tablero[indexBoton] == 0 ){
            puntajeJugador1 += 1;
            jugador1TextView.setText(getString( R.string.puntaje1, puntajeJugador1 ));
            v.setBackgroundResource(R.drawable.cruz);
            tablero[indexBoton] = 1;
            ficha += 1;
            turno = TURNO.JUGADOR2;
            return;
        }
    }

    private void turnoJugador2(View v){
        int indexBoton = Arrays.asList(fichas).indexOf(v.getId());
        if( tablero[indexBoton] == 0 ){
            puntajeJugador2 += 1;
            jugador2TextView.setText(getString( R.string.puntaje2, puntajeJugador2 ));
            v.setBackgroundResource(R.drawable.circle);
            tablero[indexBoton] = -1;
            ficha += 1;
            turno = TURNO.JUGADOR1;
        }
    }

    private void verificarVictoria(){

        Intent i = new Intent(MainActivity.this, Resultado.class);

        //VERIFICAR SI GANO POR FILA
        if( Math.abs( tablero[0] + tablero[1] + tablero[2] ) == 3 ){
            state = STATE.END;
            if( turno == TURNO.JUGADOR1 ){
                i.putExtra(GANADOR,2 );
                state = STATE.END;
            }
            if( turno == TURNO.JUGADOR2 ){
                i.putExtra(GANADOR,1 );
                state = STATE.END;
            }
            startActivity(i);
        }

        if( Math.abs( tablero[3] + tablero[4] + tablero[5] ) == 3 ){
            state = STATE.END;
            if( turno == TURNO.JUGADOR1 ){
                i.putExtra(GANADOR,2 );
                state = STATE.END;
            }
            if( turno == TURNO.JUGADOR2 ){
                i.putExtra(GANADOR,1 );
                state = STATE.END;
            }
            startActivity(i);

        }

        if( Math.abs( tablero[6] + tablero[7] + tablero[8] ) == 3 ){
            state = STATE.END;
            if( turno == TURNO.JUGADOR1 ){
                i.putExtra(GANADOR,2 );
                state = STATE.END;
            }
            if( turno == TURNO.JUGADOR2 ){
                i.putExtra(GANADOR,1 );
                state = STATE.END;
            }
            startActivity(i);

        }

        //VERIFICAR SI GANO POR COLUMNA
        if( Math.abs( tablero[0] + tablero[3] + tablero[6] ) == 3 ){
            state = STATE.END;
            if( turno == TURNO.JUGADOR1 ){
                i.putExtra(GANADOR,2 );
                state = STATE.END;
            }
            if( turno == TURNO.JUGADOR2 ){
                i.putExtra(GANADOR,1 );
                state = STATE.END;
            }
            startActivity(i);

        }

        if( Math.abs( tablero[1] + tablero[4] + tablero[7] ) == 3 ){
            state = STATE.END;
            if( turno == TURNO.JUGADOR1 ){
                i.putExtra(GANADOR,2 );
                state = STATE.END;
            }
            if( turno == TURNO.JUGADOR2 ){
                i.putExtra(GANADOR,1 );
                state = STATE.END;
            }
            startActivity(i);

        }

        if( Math.abs( tablero[2] + tablero[5] + tablero[8] ) == 3 ){
            state = STATE.END;
            if( turno == TURNO.JUGADOR1 ){
                i.putExtra(GANADOR,2 );
                state = STATE.END;
            }
            if( turno == TURNO.JUGADOR2 ){
                i.putExtra(GANADOR,1 );
                state = STATE.END;
            }
            startActivity(i);

        }

        //VERIFICAR SI GANO POR DIAGONAL
        if( Math.abs( tablero[0] + tablero[4] + tablero[8] ) == 3 ){
            state = STATE.END;
            if( turno == TURNO.JUGADOR1 ){
                i.putExtra(GANADOR,2 );
                state = STATE.END;
            }
            if( turno == TURNO.JUGADOR2 ){
                i.putExtra(GANADOR,1 );
                state = STATE.END;
            }
            startActivity(i);

        }

        if( Math.abs( tablero[2] + tablero[4] + tablero[6] ) == 3 ){
            state = STATE.END;
            if( turno == TURNO.JUGADOR1 ){
                i.putExtra(GANADOR,2 );
                state = STATE.END;
            }
            if( turno == TURNO.JUGADOR2 ){
                i.putExtra(GANADOR,1 );
                state = STATE.END;
            }
            startActivity(i);

        }

        if( ficha == 9){
            state = STATE.END;
            //animationLottieView.setAnimation(R.raw.over);
            i.putExtra(GANADOR,0 );
            startActivity(i);

        }
    }

}