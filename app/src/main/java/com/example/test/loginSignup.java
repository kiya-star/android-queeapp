package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class loginSignup extends AppCompatActivity {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_signup);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    public void login(View view) {
        progressBar = findViewById(R.id.progress);
        progressBar.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext() , Dashboard.class);
                startActivity(intent);
                finishAfterTransition();
            }
        },3000);
    }
    public void newUserregister(View view) {
        Intent intent = new Intent(getApplicationContext() , signup.class);
        startActivity(intent);
    }

    public void forgotPassword(View view) {
        //forgot password
    }
}