package com.example.glovo.SplashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.glovo.R;
import com.example.glovo.loginInicio.vista.LoginVista;

public class SplashScreenVista extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_vista);

        final Handler handler = new Handler();
        handler.postDelayed(() -> {
            Intent navegar = new Intent(getBaseContext(), LoginVista.class);
            startActivity(navegar);
        }, 5000);
    }
}