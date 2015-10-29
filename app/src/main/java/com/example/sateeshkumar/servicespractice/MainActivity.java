package com.example.sateeshkumar.servicespractice;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.FileObserver;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

/**
 * Created by Sateesh.Kumar on 10/21/2015.
 */
public class MainActivity extends AppCompatActivity {

    private FileObserver fileObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fileObserver = new FileObserver(Environment.getExternalStorageDirectory().toString()+"/skp", FileObserver.CREATE) {

            @Override
            public void onEvent(int event, String path) {
                Log.d("skp","File created "+path);
                broadcastIntent(path);
            }
        };

        fileObserver.startWatching();

        createNewFile();
        createNewDirectory();
        createNewFileInNewDirectory();
    }

//    public void startService(View view){
//        startService(new Intent(MainActivity.this, MyService.class));
//    }
//
//    public void stopService(View view){
//        stopService(new Intent(MainActivity.this, MyService.class));
//    }

    public void broadcastIntent (String fileName)
    {
        Intent intent = new Intent();
        intent.putExtra("FileName", fileName);
        intent.setAction("com.sateeshKumar.Custom_intent");
        sendBroadcast(intent);
    }

    public void createNewFile()
    {
        File file = new File(Environment.getExternalStorageDirectory()+"/sateesh/five.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            Toast.makeText(MainActivity.this, "createNewFile "+e, Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    public void createNewDirectory()
    {
        File file = new File(Environment.getExternalStorageDirectory()+"/skp");
        file.mkdir();
    }

    public void createNewFileInNewDirectory()
    {
        File file = new File(Environment.getExternalStorageDirectory()+"/skp/one.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            Toast.makeText(MainActivity.this, "createNewFile "+e, Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}
