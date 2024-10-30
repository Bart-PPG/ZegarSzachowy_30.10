package com.example.zegarszachowy;

import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.CountDownLatch;

public class Gracz {
    int pozostalySekundy;
    boolean czyDziala;

    Button buttonGracza;
    CountDownTimer countDownTimer;


    public Gracz(boolean czyDziala, Button buttonGracza) {
        this.czyDziala = czyDziala;
        this.buttonGracza = buttonGracza;
        pozostalySekundy = 3*60;
    }
    public void stopTimer(){
        czyDziala = false;
    }
    public void startTimer(){
        czyDziala = true;
        countDownTimer = new CountDownTimer(1000 * pozostalySekundy,1000) {
            @Override
            public void onTick(long l) {
                pozostalySekundy = (int)l/1000;
                buttonGracza.setText(String.valueOf(pozostalySekundy));
                //TODO: poprawic wyswietlanie
            }

            @Override
            public void onFinish() {
            buttonGracza.setText("Koniec");
            }
        };
    }
}
