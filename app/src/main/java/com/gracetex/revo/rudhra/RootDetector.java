package com.gracetex.revo.rudhra;

import android.content.Intent;
import android.os.Build;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.system.Os;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class RootDetector extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root_detector);

        ToggleButton rootb = (ToggleButton) (findViewById(R.id.Roottb));
        Button rtools = (Button)(findViewById(R.id.broottools));
        TextView roottv = (TextView) (findViewById(R.id.roottv));

        String yesdesc = "Your device has root access.Rooted devices allow lot of customizations but as well pose serious security issues.You can choose to unroot the device or install security-enhancing tools. Here is a list : ";
        String nodesc = "No root access detected !";
        //SUBinFinder();

        //SURuntimeCheck();
        //TestKeysChecker();

        boolean isRooted = FindRoot();

        if (isRooted == true) {
            rootb.setChecked(true);
            roottv.setText(yesdesc);
            rtools.setOnClickListener(new Button.OnClickListener()
            {
                public void onClick(View v)
                {
                    Intent i = new Intent(RootDetector.this, RootTools.class);
                    startActivity(i);
                }
            });

            rtools.setVisibility(View.VISIBLE);

        } else if(isRooted == false) {
            rootb.setChecked(false);
            roottv.setText(nodesc);
        }
    }

    public boolean FindRoot() {
        return TestKeysChecker() || SUBinFinder() || SURuntimeCheck();
    }

    public boolean TestKeysChecker() {
        String keys = Build.TAGS;
        if (keys != null && keys.contains("test-keys")) {

            Toast.makeText(this, " Test-keys found ", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Root not found", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    //Check within the paths for the existance of su binary
    public boolean SUBinFinder() {
        String[] paths = {"/system/app/Superuser.apk",
                "/sbin/su",
                "/system/bin/su",
                "/system/xbin/su",
                "/data/local/xbin/su",
                "/data/local/bin/su",
                "/system/sd/xbin/su",
                "/system/bin/failsafe/su",
                "/data/local/su",
                "/su/bin/su"
        };

        int dircount = 0;

        for (String path : paths) {
            if (new File(path).exists()) {
                dircount = dircount++;
            }
        }

        if (dircount >= 1) {

            Toast.makeText(this, " SU binary found ", Toast.LENGTH_SHORT).show();
            return true;

        } else {

            Toast.makeText(this, "Root not found", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    //Executing the su binary
    public boolean SURuntimeCheck() {
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(new String[]{"/system/xbin/which", "su"});
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            if (in.readLine() != null) {
                Toast.makeText(this, " SU execution successfull ! ", Toast.LENGTH_SHORT).show();
                return true;
            }
            Toast.makeText(this, "Root not found", Toast.LENGTH_SHORT).show();


        } catch (Throwable t) {

        } finally {
            if (process != null) process.destroy();
        }
        return false;
    }

}

