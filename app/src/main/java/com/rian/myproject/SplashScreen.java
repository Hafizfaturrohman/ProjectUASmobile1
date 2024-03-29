package com.rian.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.rian.myproject.ClassesUtils.ClosingService;
import com.rian.myproject.Connection.LoginActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.splash_screen);

    }

    @Override
    protected void onStart() {
        super.onStart();

        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(() -> {

            //Check if user is connected to the app
            if (FirebaseAuth.getInstance().getCurrentUser() != null) {
                startService(new Intent(getBaseContext(), ClosingService.class));
                startActivity(new Intent(SplashScreen.this, MainActivity.class));
                finishAffinity();
            } else {
                startActivity(new Intent(SplashScreen.this, LoginActivity.class));
                finishAffinity();
            }
        }, 2500);

    }

}