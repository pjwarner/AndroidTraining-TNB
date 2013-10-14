package com.uuarner.thenewboston;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

/**
 * Created by pwarner on 10/5/13.
 */
public class Splash extends Activity{
    MediaPlayer ourSong;
    @Override
    protected void onCreate(Bundle PaulLoveBacon) {
        super.onCreate(PaulLoveBacon);
        setContentView(R.layout.splash);
        ourSong = MediaPlayer.create(Splash.this, R.raw.splashsound);
        ourSong.start();
        Thread timer = new Thread (){
          public void run(){
              try{
                sleep(2000);
              } catch(InterruptedException e){
                  e.printStackTrace();
              } finally {
                Intent openMainActivity = new Intent("com.uuarner.thenewboston.MENU");
                startActivity(openMainActivity);
              }
          }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        ourSong.release();
        finish();
    }
}
