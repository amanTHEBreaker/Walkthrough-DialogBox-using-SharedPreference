package com.amanthebreaker.sharedprefexample;

import static android.widget.Toast.LENGTH_SHORT;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.widget.Toast;

import java.util.prefs.PreferenceChangeEvent;
import java.util.prefs.PreferenceChangeListener;

public class MainActivity extends AppCompatActivity {

    // shared Preferences
    private SharedPreferences mPreferences;
    private int firstTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // private mode
        mPreferences = getSharedPreferences("com.amanthebreaker.sharedPrefExample.mySharedPrefs", MODE_PRIVATE);
        // default value of firstTime variable
        firstTime = mPreferences.getInt("firstTime", 1);
        if (firstTime == 1) {
                SharedPreferences.Editor editor = mPreferences.edit();
                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                builder1.setMessage("Welcome to Shared Prefs App! \nthis AlertDialog would appear once " +
                        "after installation of this App. On next launch this Dialog box won't appear.");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();

                editor.apply();
            }

        }

        @Override
        protected void onPause() {
            super.onPause();
            SharedPreferences.Editor editor = mPreferences.edit();
            editor.putInt("firstTime", 2);
            editor.apply();
        }



}