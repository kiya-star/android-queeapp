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
    public String NUMBER_TO_VERIFY = "0";
    public final static String EXTRA_MESSAGE = "com.example.test.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        userEnteredPhone = findViewById(R.id.phone);
        countryCodePicker = findViewById(R.id.country);
    }

    public void backtologin(View view) {
        Intent intent = new Intent(getApplicationContext(), loginSignup.class);
        startActivity(intent);
        finish();
    }

    public void checkPhoneNumber(View view) {

        //Check if connected to the internet
//        if (!isConnected(this)) {
//            showDialog();
//        } else {
        String userEnteredPhonenumber = userEnteredPhone.getEditText().getText().toString();
        String userPhoneNumber = "+" + countryCodePicker.getSelectedCountryCodeAsInt()+ userEnteredPhonenumber;

        Intent intent = new Intent(getApplicationContext(), phoneVerification.class);
        intent.putExtra(EXTRA_MESSAGE, userPhoneNumber);
        startActivity(intent);

        // }

    }

    private boolean isConnected(signup context) {
        int[] networkTypes = {ConnectivityManager.TYPE_MOBILE,
                ConnectivityManager.TYPE_WIFI};
        try {
            ConnectivityManager connectivityManager =
                    (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            for (int networkType : networkTypes) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null &&
                        activeNetworkInfo.getType() == networkType)
                    return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
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