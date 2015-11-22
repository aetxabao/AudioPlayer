package com.pmdm.audioplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

//
//android:configChanges="orientation|screenSize|keyboard|keyboardHidden"
//
//try{}catch(Exception e){}
//
public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;
    Button btn;
    int pos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.BtnCircular);
    }

    public void reset() {
        if (mp != null)
            mp.release();
    }

    public void onIniciarClick(View v){
        reset();
        Toast.makeText(getApplicationContext(), "Iniciar", Toast.LENGTH_SHORT).show();
        mp = MediaPlayer.create(this, R.raw.game);
        mp.start();
        String op = btn.getText().toString();
        if (op.equals(getResources().getString(R.string.nocircular)))
            mp.setLooping(false);
        else
            mp.setLooping(true);

    }
    public void onPausarClick(View v){
        if (mp != null && mp.isPlaying()) {
            try{
                Toast.makeText(getApplicationContext(), "Pausar", Toast.LENGTH_SHORT).show();
                pos = mp.getCurrentPosition();
                mp.pause();
            }catch(Exception e){}
        }
    }
    public void onContinuarClick(View v){
        if (mp != null && mp.isPlaying() == false) {
            try{
                Toast.makeText(getApplicationContext(), "Continuar",Toast.LENGTH_SHORT).show();
                mp.seekTo(pos);
                mp.start();
            }catch(Exception e){}
        }
    }
    public void onDetenerClick(View v){
        if (mp != null) {
            Toast.makeText(getApplicationContext(), "Detener",Toast.LENGTH_SHORT).show();
            mp.stop();
            pos = 0;
        }
    }
    public void onCircularClick(View v){
        onDetenerClick(null);
        Toast.makeText(getApplicationContext(), "Circular",Toast.LENGTH_SHORT).show();
        String op = btn.getText().toString();
        if (op.equals(getResources().getString(R.string.nocircular)))
            btn.setText(getResources().getString(R.string.circular));
        else
            btn.setText(getResources().getString(R.string.nocircular));
    }
}
