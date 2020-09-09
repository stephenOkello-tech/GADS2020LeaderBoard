package com.comptechnoid.gads2020leaderboard.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import com.comptechnoid.gads2020leaderboard.R;

public class Main2Activity extends AppCompatActivity {

    private TabLayout tab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tab = (TabLayout)findViewById(R.id.pagerTabs);

        //tab.addOnTabSelectedListener(OnTa);
    }
}
