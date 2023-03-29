package org.mattiasduarte.example.tresenraya;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Random rand = new Random();

    Integer[] fichas;
    int[] tablero = new int[]{
            0, 0, 0,
            0, 0, 0,
            0, 0, 0
    };

    private enum STATE { WIN, OVER, GAMING };
    private STATE state = STATE.GAMING;

    private int turno = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            fichas = new Integer[]{
                R.id.button, R.id.button2, R.id.button3,
                R.id.button4, R.id.button5, R.id.button6,
                R.id.button7, R.id.button8, R.id.button9,
        };
    }
    public void colocarFicha(View v){
        switch ( state ){
            case GAMING:
                int indexBoton = Arrays.asList(fichas).indexOf(v.getId());
                v.setBackgroundResource(R.drawable.cruz);
                tablero[indexBoton] = 1;
                turno += 1;
                if (state == STATE.GAMING){
                    computadoraJugador();
                    turno += 1;
                }
        }

    }

    private void computadoraJugador(){
        int position = rand.nextInt(tablero.length);

        while (tablero[position] != 0 ){
            position = rand.nextInt(tablero.length);
        }

        Button btn = (Button) findViewById(fichas[position]);
        btn.setBackgroundResource(R.drawable.circle);
        tablero[position] = -1;

    }

    private int comprobarState(){
        if( turno < 9 ){
            return 0;
        } else{
            return 2;
        }
    }
}