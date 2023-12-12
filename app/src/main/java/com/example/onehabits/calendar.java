package com.example.onehabits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class calendar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
    }

    public void goSettingss (View view){
        Intent settings = new Intent(calendar.this, settings.class);
        startActivity(settings);
    }

    public void goBack(View view){
        Intent back = new Intent(calendar.this, dashboard.class);
        startActivity(back);
    }
}