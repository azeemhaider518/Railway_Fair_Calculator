package com.abis_creations.android.railfarecanculator.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.abis_creations.android.railfarecanculator.R;

import static java.lang.Thread.sleep;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        final Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(2000);

                }catch (Exception ex){

                }finally {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                }
            }
        });
        thread.start();
    }
}
