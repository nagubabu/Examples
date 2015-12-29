package com.android.bcr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Nag on 28/12/15.
 */
public class MyReceiver extends BroadcastReceiver {

    MainActivity mainActivity;

    @Override
    public void onReceive(Context context, Intent intent) {

        mainActivity = (MainActivity) context;
        TextView tv=(TextView)mainActivity.findViewById(R.id.tv);

        if(intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)){
            Toast.makeText(context, "Airplane Mode Changed", Toast.LENGTH_LONG).show();
            tv.setText("Airplane Mode Changed");
        }

        if(intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)){
            Toast.makeText(context, "Power Connected!", Toast.LENGTH_LONG).show();
            tv.setText("Power Connected!");
        }

        if(intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)){
            Toast.makeText(context, "Power Disconnected!", Toast.LENGTH_LONG).show();
            tv.setText("Power Disconnected!");
        }

    }
}
