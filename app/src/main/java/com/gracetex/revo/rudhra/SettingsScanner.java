package com.gracetex.revo.rudhra;

import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.widget.ToggleButton;

import com.gracetex.revo.rudhra.R;

public class SettingsScanner extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_scanner);
    }

    public void checkSettings() throws Settings.SettingNotFoundException {
        if(Settings.Secure.getInt(getContentResolver(), Settings.Secure.INSTALL_NON_MARKET_APPS, 0) != 1) {
            ToggleButton US = (ToggleButton) (findViewById(R.id.USt));
            US.setChecked(true);
        }

        if(Settings.Secure.getInt(getContentResolver(), Settings.Global.ADB_ENABLED, 0)!= 1) {
            ToggleButton ADBe = (ToggleButton) (findViewById(R.id.ADBt));
            ADBe.setChecked(true);
        }

        if(Settings.Secure.getInt(getContentResolver(), Settings.Global.DEVELOPMENT_SETTINGS_ENABLED, 0) != 1) {
            ToggleButton DevS = (ToggleButton) (findViewById(R.id.DevB));
            DevS.setChecked(true);
        }
    }
}
