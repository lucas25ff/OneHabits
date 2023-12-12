package com.example.onehabits;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

    }

    public void goAdd(View view){
        Intent goAdd = new Intent(dashboard.this, addHabit.class);
        startActivity(goAdd);
    }

    public void goSettings (View view){
        Intent goDashboard = new Intent(dashboard.this, settings.class);
        startActivity(goDashboard);
    }

    public void goCalendar (View view){
        Intent goCalendar = new Intent(dashboard.this, calendar.class);
        startActivity(goCalendar);
    }
}