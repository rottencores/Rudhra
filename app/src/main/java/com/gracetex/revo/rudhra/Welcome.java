package com.gracetex.revo.rudhra;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;


public class Welcome extends Activity {

    private final int SPLASH_DISPLAY_LENGTH = 2000;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(com.gracetex.revo.rudhra.Welcome.this, com.gracetex.revo.rudhra.MainActivity.class);
                Welcome.this.startActivity(i);
                Welcome.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}

