package org.mattiasduarte.example.tresenraya;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Arrays;



public class JuegoActivity extends AppCompatActivity {

    private int puntajeJugador1 = 0;
    private int puntajeJugador2 = 0;

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
        setContentView(R.layout.activity_juego);

        fichas = new Integer[]{
                R.id.button, R.id.button2, R.id.button3,
                R.id.button4, R.id.button5, R.id.button6,
                R.id.button7, R.id.button8, R.id.button9,
        };

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
            v.setBackgroundResource(R.drawable.circle);
            tablero[indexBoton] = -1;
            ficha += 1;
            turno = TURNO.JUGADOR1;
        }
    }

    private void verificarVictoria(){

        Intent i = new Intent(JuegoActivity.this, Resultado.class);

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