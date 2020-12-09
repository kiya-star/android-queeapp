package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.hbb20.CountryCodePicker;

public class signup extends AppCompatActivity {

    private TextInputLayout userEnteredPhone;
    private CountryCodePicker countryCodePicker;
    public final static String NUMBER_TO_VERIFY="0";

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

        //Check if connected to the internet
        if (!isConnected(this)) {
            showDialog();
       }
        String userEnteredPhonenumber = userEnteredPhone.getEditText().getText().toString();
        String userPhoneNumber = "+" + countryCodePicker.getSelectedCountryCode() + userEnteredPhonenumber;

        Intent intent = new Intent(getApplicationContext(), verifyPhone.class);
          intent.putExtra(NUMBER_TO_VERIFY, userPhoneNumber);
          startActivity(intent);
         Toast.makeText(getApplicationContext(), userPhoneNumber, Toast.LENGTH_LONG).show();

    }

    private boolean isConnected(signup signup) {
        ConnectivityManager connectivityManager = (ConnectivityManager) signup.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiConnection = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileConnection = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if ((wifiConnection != null && wifiConnection.isConnected()) || (mobileConnection != null && mobileConnection.isConnected())) {
            return true;
        } else {
            return false;
        }
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Please, check your internet connection")
                .setCancelable(false)
                .setPositiveButton("Try again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent((Settings.ACTION_WIFI_SETTINGS)));
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(), loginSignup.class));
                        finish();
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

}