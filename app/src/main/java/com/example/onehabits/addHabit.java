package com.example.onehabits;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class addHabit extends AppCompatActivity {
    //crear variables y su respectivo tipo
    EditText titleTxt, descTxt, dateTxt;
    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_habit);

        //guardamos los elementos del xml en las variables
        titleTxt = findViewById(R.id.title);
        dateTxt = findViewById(R.id.date);
        descTxt = findViewById(R.id.desc);
        add = findViewById(R.id.btnAdd);

        //funcion q se activa al hacer click en el boton q dice "guardar"
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //creava riables de tipo "string" para guardar el texto q se inserte en cada campo
                String title = titleTxt.getText().toString();
                String desc = descTxt.getText().toString();
                String date = dateTxt.getText().toString();

                //si falta alguno de los campos, crea mensaje indicandolo. de lo contrario, llama una funcion
                if (title.isEmpty() || desc.isEmpty() || date.isEmpty()){
                    Toast.makeText(addHabit.this, "Datos faltantes", Toast.LENGTH_SHORT).show();
                }else{
                    addHabit(title, date, desc);
                }
            }
        });

    }

    //funcion para cargar habitos
    private void addHabit(String title, String date, String desc) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String, Object> habit = new HashMap<>();
        habit.put("nombre", title);
        habit.put("Anotaciones", desc);
        habit.put("fecha", date);
        db.collection("habits").add(habit).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(addHabit.this, "Datos guardados", Toast.LENGTH_SHORT).show();
                Log.d("id:", documentReference.getId());
                Intent goDashboard = new Intent(addHabit.this, dashboard.class);
                startActivity(goDashboard);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(addHabit.this, "Error al guardar", Toast.LENGTH_SHORT).show();
                Log.d("problem:", String.valueOf(e));
            }
        });
    }

    public void goBackDash (View view){
        Intent goDashboard = new Intent(addHabit.this, dashboard.class);
        startActivity(goDashboard);
    }
}