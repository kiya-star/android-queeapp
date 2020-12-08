package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.hbb20.CountryCodePicker;

public class signup extends AppCompatActivity {

    private TextInputLayout userEnteredPhone;
    private CountryCodePicker countryCodePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        countryCodePicker = findViewById(R.id.country);
        userEnteredPhone = findViewById(R.id.phone);
    }

    public void backtologin(View view) {
        Intent intent = new Intent(getApplicationContext(), loginSignup.class);
        startActivity(intent);
        finish();
    }

    public void checkPhoneNumber(View view) {

        String userEnteredPhonenumber = userEnteredPhone.getEditText().getText().toString();
        String userPhoneNumber =  "+" + countryCodePicker.getSelectedCountryCode() + userEnteredPhonenumber;

        Intent intent = new Intent(getApplicationContext(), verifyPhone.class);
        intent.putExtra("number", userPhoneNumber);
        startActivity(intent);
        Toast.makeText(getApplicationContext() , userPhoneNumber , Toast.LENGTH_LONG).show();

    }
}