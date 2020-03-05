package com.example.tasca1_so;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    private int song;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        final SeekBar barraVolumen;
        final SoundPool sp;
        final Button music1;


        sp = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){

        }else{

        }*/
        final int idDisparo = sp.load(this, R.raw.devil, 0);
        final int idPoker = sp.load(this,R.raw.poker,0);

        barraVolumen = findViewById(R.id.seekBar);




        final Button buttonMusic1= (Button)findViewById(R.id.music1);
        buttonMusic1.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                // click handling code
                song= sp.play(idDisparo,(float)barraVolumen.getProgress()/100,(float)barraVolumen.getProgress()/100,1,0,1);
            }
        });
        final Button buttonMusic2 = (Button)findViewById(R.id.music2);
        buttonMusic2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                song= sp.play(idPoker, (float)barraVolumen.getProgress()/100,(float)barraVolumen.getProgress()/100,1,0,1);
            }
        });
        barraVolumen.setMin(1);
        barraVolumen.setMax(100);
        barraVolumen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sp.setVolume(song,(float)progress/100,(float)progress/100);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        final Button buttonStop = (Button)findViewById(R.id.stopButton);
        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sp.stop(song);
                //sp.pause(idPoker);
            }

        });

    }

}
