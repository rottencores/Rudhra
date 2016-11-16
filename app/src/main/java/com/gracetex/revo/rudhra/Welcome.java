package com.gracetex.revo.rudhra;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.gracetex.revo.rudhra.R;


public class Welcome extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(2000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent i = new Intent("com.gracetex.revo.rudhra.MAINACTIVITY");
                    startActivity(i);
                }
            }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

}

