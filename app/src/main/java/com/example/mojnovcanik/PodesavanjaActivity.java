package com.example.mojnovcanik;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.mojnovcanik.Adapter.SettingsRecyclerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Locale;

public class PodesavanjaActivity extends AppCompatActivity {
    private RadioButton radioenglis, radioexyu;
    BottomNavigationView bottom_navigation;
    RecyclerView settingsRecyclerView;
    SettingsRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_podesavanja);
        //loadLocale();

        settingsRecyclerView = findViewById(R.id.settingsRecyclerView);
        settingsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SettingsRecyclerAdapter();
        settingsRecyclerView.setAdapter(adapter);



        bottom_navigation = findViewById(R.id.bottom_navigation);

        /*radioenglis = findViewById(R.id.radio_button_1);
        radioexyu = findViewById(R.id.radio_button_2);*/
        settingsRecyclerView = findViewById(R.id.settingsRecyclerView);



       // bottomNavigationView.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);

        bottom_navigation.setSelectedItemId(R.id.page_2);

        bottom_navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.page_1:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        finish();
                        return true;
                    case R.id.page_2:
                        startActivity(new Intent(getApplicationContext(),PodesavanjaActivity.class));
                        overridePendingTransition(0,0);
                }

                return false;
            }
        });


    }




    @Override
    public void onBackPressed() {
        return;

    }
}