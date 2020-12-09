package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.test.fragments.DashboardFragment;
import com.example.test.fragments.InboxFragment;
import com.example.test.fragments.ProfileFragment;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class Dashboard extends AppCompatActivity {
    
  private ChipNavigationBar chipNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
     
        //bottom navigation bar
        chipNavigationBar = findViewById(R.id.bottomMenu);
        getSupportFragmentManager().beginTransaction().replace(R.id.container ,new DashboardFragment()).commit();
        chipNavigationBar.setItemSelected(R.id.dashboard,true);
       // chipNavigationmenu();
    
    }
/*
    private void chipNavigationmenu() {
        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment = null;
                switch (i){
                    case R.id.dashboard:
                        fragment =  new DashboardFragment();
                        break;
                    case R.id.profile:
                        fragment =  new ProfileFragment();
                        break;
                    case R.id.inbox:
                        fragment =  new InboxFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container ,fragment).commit();

            }
        });
    }
*/

}