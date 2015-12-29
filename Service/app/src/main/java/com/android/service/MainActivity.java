package com.android.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.textView);
        tv.setText("Player stopped");
    }

    public void startPlaying(View view){
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(getApplicationContext(), MyService.class));
        startService(intent);
        tv.setText("Playing...");
    }

    public void stopPlaying(View view){
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(getApplicationContext(), MyService.class));
        stopService(intent);
        tv.setText("Player stopped");
    }
}
