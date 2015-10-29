package com.example.sateeshkumar.servicespractice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Sateesh.Kumar on 10/21/2015.
 */
public class MyService extends Service {


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(MyService.this, "Service started", Toast.LENGTH_SHORT).show();
//        for(int i=0; i<555555; i++)
//        {
//            Log.d("skpp", "At "+i);
//        }
        return START_STICKY;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("skp", "Stopped ");
        Toast.makeText(MyService.this, "Stopped", Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

