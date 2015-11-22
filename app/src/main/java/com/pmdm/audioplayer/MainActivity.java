package com.pmdm.audioplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tocarSirena(View v){
        MediaPlayer mp = MediaPlayer.create(this, R.raw.sirena);
        mp.start();
    }

}
