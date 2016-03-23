package com.roysolberg.android.basketballcheater.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.roysolberg.android.basketballcheater.R;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button_open).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity(getPackageManager().getLaunchIntentForPackage("com.facebook.orca").addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Unable to open Messenger. Sorry, but you gotta do it yourself then.", Toast.LENGTH_LONG).show();
                    Log.e(TAG, "Got exception while trying to start Messenger app. User will have to open it.");
                }
                finish();
            }
        });
    }

}
