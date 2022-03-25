package com.example.managementtrader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.lang.invoke.MethodHandle;

public class MainActivity extends AppCompatActivity {
    private int progresoBar = 0;
    private Handler mhandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView Logo = (ImageView) findViewById(R.id.imageView);
        inicicaSplash();
    }


    public void inicicaSplash()
    {
        setContentView(R.layout.activity_main);
        final ProgressBar progressBar = findViewById(R.id.progressBar);
    new Thread(new Runnable() {
        @Override
        public void run() {
                while (progresoBar < 100) {
                    progresoBar++;
                    android.os.SystemClock.sleep(15);
                    mhandler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(progresoBar);
                        }
                    });
                }
            if(progresoBar == 100)
            {
                Intent intent = new Intent(MainActivity.this,Act_Login.class);
                startActivity(intent);
                finish();
            }
        }
    }).start();
    }
}
