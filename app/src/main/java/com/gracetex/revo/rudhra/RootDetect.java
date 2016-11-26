package com.gracetex.revo.rudhra;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ToggleButton;

import java.io.IOException;

/**
 * Created by r3v0 on 24/11/16.
 */

public class RootDetect extends AppCompatActivity  {

    ToggleButton rootb =  (ToggleButton) (findViewById(R.id.Roottb));
    boolean isRooted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root_detector);
        isRooted = FindRoot();

        if(isRooted == true )
        {
            rootb.setChecked(true);
        }
        else
            rootb.setChecked(false);
    }

    public boolean FindRoot()
    {
        return SuCheck();
    }


    public boolean SuCheck()
    {
        try {
            Process process = new ProcessBuilder()
                    .command("/system/bin/su")
                    .redirectErrorStream(false)
                    .start();
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
