package com.example.onehabits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void goDash (View view){
        Intent goDashboard = new Intent(settings.this, dashboard.class);
        startActivity(goDashboard);
    }

    public void goLogout(View view){
        Intent goOut = new Intent(settings.this, MainActivity.class);
        startActivity(goOut);
    }

    public void goCalendar(View view){
        Intent goCalendar = new Intent(settings.this, calendar.class);
        startActivity(goCalendar);
    }

}