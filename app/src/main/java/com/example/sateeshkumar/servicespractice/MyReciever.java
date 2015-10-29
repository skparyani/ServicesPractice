package com.example.sateeshkumar.servicespractice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Sateesh.Kumar on 10/23/2015.
 */
public class MyReciever extends BroadcastReceiver {

    private Context mContext;


    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
//        Toast.makeText(context, "received", Toast.LENGTH_SHORT).show();
        mContext = context;
        String fileName = bundle.getString("FileName");
        Toast.makeText(mContext, "FileName: "+fileName, Toast.LENGTH_SHORT).show();
//        startServiceFromNonActivity();
    }

    public void startServiceFromNonActivity()
    {
        mContext.startService(new Intent(mContext, MyService.class));
    }

}
