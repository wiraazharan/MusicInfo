package com.music.wiraazharan.dcprojects;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.view.View;

/**
 * Created by wiraazharan on 6/12/15.
 */
public class MusicService
        extends
        Service
        implements
        MediaPlayer.OnPreparedListener,
        MediaPlayer.OnCompletionListener,
        MediaPlayer.OnErrorListener,
        MediaPlayer.OnSeekCompleteListener,
        MediaPlayer.OnInfoListener,
        MediaPlayer.OnBufferingUpdateListener{

    MediaPlayer mp = new MediaPlayer();
    String audiolink;

    @Override
    public void onCreate() {
        mp.setOnPreparedListener(this);
        mp.setOnCompletionListener(this);
        mp.setOnErrorListener(this);
        mp.setOnSeekCompleteListener(this);
        mp.setOnInfoListener(this);
        mp.setOnBufferingUpdateListener(this);
        mp.reset();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        return super.onStartCommand(intent, flags, startId);
        audiolink = intent.getExtras().getString("sentaudiolink");
        mp.reset();

        if(!mp.isPlaying())
        {
            try{
                mp.setDataSource("http://main.purplez.pw/music/"+audiolink);

                mp.prepareAsync();

            }catch (Exception e)
            {

            }
        }

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mp != null){
            if(mp.isPlaying())
            {
                mp.stop();
            }
            mp.release();
        }
    }

    @Override
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {

    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        stopmedia();
        stopSelf(); //stop the service itself
    }


    @Override
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        return false;
    }

    @Override
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        return false;
    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {

        playmedia();
    }


    @Override
    public void onSeekComplete(MediaPlayer mediaPlayer) {

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    private void playmedia() {

        if(!mp.isPlaying())
        {
            mp.start();
        }
    }

    private void stopmedia() {
        if(mp.isPlaying())
        {
            mp.stop();
        }
    }



}
