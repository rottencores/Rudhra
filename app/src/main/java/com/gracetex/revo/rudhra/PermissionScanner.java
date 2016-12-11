package com.gracetex.revo.rudhra;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gracetex.revo.rudhra.R;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;

public class PermissionScanner extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission_scanner);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        /*ArrayList<String> VulnPerms = new ArrayList<String>();

        VulnPerms.add("com.android.launcher.permission.WRITE_SETTINGS");
        VulnPerms.add("com.android.launcher.permission.READ_SETTINGS");
        VulnPerms.add("android.permission.READ_CALL_LOG");
        VulnPerms.add("android.permission.READ_CONTACTS");
        VulnPerms.add("android.permission.READ_EXTERNAL_STORAGE");
        VulnPerms.add("android.permission.WRITE_EXTERNAL_STORAGE");
        VulnPerms.add("android.permission.USE_CREDENTIALS");
        VulnPerms.add("android.permission.MANAGE_ACCOUNTS");
        VulnPerms.add("android.permission.GET_ACCOUNTS");
        VulnPerms.add("android.permission.INTERNET");
        VulnPerms.add("android.permission.ACCESS_NETWORK_STATE");
        VulnPerms.add("android.permission.RECORD_AUDIO");
        VulnPerms.add("android.permission.READ_SMS");
        VulnPerms.add("android.permission.WRITE_SMS");
        VulnPerms.add("android.permission.MMS_SEND_OUTBOX_MSG");
        VulnPerms.add("com.google.android.googleapps.permission.ACCESS_GOOGLE_PASSWORD");

        int vulnLength = VulnPerms.size();*/

        String[] VulnPerms = new String[]{
                "android.permission.READ_CALL_LOG",
                "android.permission.READ_CONTACTS",
                "android.permission.READ_EXTERNAL_STORAGE",
                "android.permission.INTERNET",
                "android.permission.MANAGE_ACCOUNTS",
                "android.permission.READ_SMS",
                "android.permission.WRITE_SMS",
                "com.google.android.googleapps.permission.ACCESS_GOOGLE_PASSWORD",
                "android.permission.MMS_SEND_OUTBOX_MSG",
                "android.permission.GET_ACCOUNTS",
                "android.permission.ACCESS_NETWORK_STATE",
                "android.permission.USE_CREDENTIALS"
        };


        final int N = 100; // total number of textviews to add

        final TextView[] myTextViews = new TextView[N]; // create an empty array;


        PackageManager p = this.getPackageManager();
        final List<PackageInfo> appinstall = p.getInstalledPackages(PackageManager.GET_PERMISSIONS | PackageManager.GET_RECEIVERS |
                PackageManager.GET_SERVICES | PackageManager.GET_PROVIDERS);

        for (PackageInfo pInfo : appinstall) {
            PermissionInfo[] permission = pInfo.permissions;
            String[] reqPermission = pInfo.requestedPermissions;
            ServiceInfo[] services = pInfo.services;
            ProviderInfo[] providers = pInfo.providers;
            int versionCode = pInfo.versionCode;

            Log.d("versionCode-package ", Integer.toString(versionCode));
            Log.d("Installed Applications", pInfo.applicationInfo.loadLabel(p).toString());
            Log.d("packegename", pInfo.packageName.toString());
            LinearLayout layout1 = (LinearLayout) (findViewById(R.id.info));
            final TextView permheader = new TextView(this);
            layout1.addView(permheader);
            permheader.setText(pInfo.packageName);

            if (reqPermission != null) {
                for (int i = 0; i < reqPermission.length; i++) {

                    LinearLayout layout = (LinearLayout) (findViewById(R.id.info));
                    final TextView PermTextView = new TextView(this);
                    layout.addView(PermTextView);
                    PermTextView.setText(reqPermission[i]);
                    Log.d("permission list", reqPermission[i]);

                }

            }

            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        /*fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        }


    }
}
