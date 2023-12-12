package com.example.onehabits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class addHabit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_habit);
    }

    public void goBackDash (View view){
        Intent goDashboard = new Intent(addHabit.this, dashboard.class);
        startActivity(goDashboard);
    }
}