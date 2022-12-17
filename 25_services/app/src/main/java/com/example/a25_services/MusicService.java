package com.example.a25_services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

import androidx.annotation.Nullable;

public class MusicService extends Service {
    MediaPlayer mediaPlayer;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
//        mediaPlayer.setLooping(true);
        mediaPlayer.start();

//        return super.onStartCommand(intent, flags, startId);
        return START_NOT_STICKY; //Service will automatically destroy after execution
    }

    @Override
    public void onDestroy() {
        //Stop music on destroy service
        mediaPlayer.stop();
        super.onDestroy();
    }
}
