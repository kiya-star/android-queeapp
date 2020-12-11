package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
//    private Button loginbtn;
//    private TextInputLayout username, password,phone;

    private  static int SPLASH_SCREEN_TIME = 6000;
    private Animation topAnimation , bottomAnimation;
    private ImageView logo;
    private TextView logotxt ,slogan;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Animation Hooks
        topAnimation = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        logo = findViewById(R.id.logo);
        logotxt = findViewById(R.id.logotxt);
        slogan = findViewById(R.id.slogan);

        logo.setAnimation(topAnimation);
        logotxt.setAnimation(bottomAnimation);
        slogan.setAnimation(bottomAnimation);


    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            Intent intent =  new Intent(MainActivity.this , loginSignup.class);
            startActivity(intent);
            finishAfterTransition();
//            Pair[] pairs = new Pair[2];
//            pairs[0] = new Pair<View , String> (logo , "ourlogo");
//            pairs[1] = new Pair<View , String> (slogan , "ourslogan");
//            ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this , pairs);
//            startActivity(intent ,activityOptions.toBundle());


        }
    },SPLASH_SCREEN_TIME);
    }
}