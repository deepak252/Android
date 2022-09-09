package com.example.a8a_mediaplayer_music;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private FloatingActionButton floatingActionButton;
    private SeekBar seekBar;
    public static boolean playing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playing=false;
        mediaPlayer = MediaPlayer.create(this, R.raw.slowly);
        floatingActionButton = findViewById(R.id.floatingActionButton);
        seekBar = findViewById(R.id.seekBar);

        seekBar.setMax(mediaPlayer.getDuration());

//        mediaPlayer.setVolume(0,0);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
                if(!mediaPlayer.isPlaying()){
                    playing =false;
                }
            }
        },0,1000);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                togglePlay();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void togglePlay(){
        if(playing){
            playing=false;
            floatingActionButton.setImageResource(android.R.drawable.ic_media_play);
            mediaPlayer.pause();
        }else{
            playing=true;
            floatingActionButton.setImageResource(android.R.drawable.ic_media_pause);
            mediaPlayer.start();
        }
    }
}