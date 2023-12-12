package com.example.onehabits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText email;
    private EditText pass;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.emailText);
        pass = findViewById(R.id.passText);
        loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().isEmpty() || pass.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Datos incorrectos o faltantes", Toast.LENGTH_SHORT).show();
                }else{
                    if (email.getText().toString().equals("ppedersoli@gmail.com") || pass.getText().toString().equals("holaprofe")) {
                        Intent goDashboard = new Intent(MainActivity.this, dashboard.class);
                        startActivity(goDashboard);
                        Toast.makeText(MainActivity.this, "Inicio Correcto", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}