package com.example.onehabits;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.onehabits.adapters.listItemAdapter;
import com.example.onehabits.entities.Items;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class dashboard extends AppCompatActivity {
    RecyclerView listItemRecycler;
    listItemAdapter mAdapter;
    FirebaseFirestore mFirestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        mFirestore = FirebaseFirestore.getInstance();
        listItemRecycler = findViewById(R.id.listItem);
        listItemRecycler.setLayoutManager(new LinearLayoutManager(this));
        Query query = mFirestore.collection("habits");

        FirestoreRecyclerOptions <Items> firestoreRecyclerOptions =
                new FirestoreRecyclerOptions.Builder<Items>().setQuery(query, Items.class).build();

        mAdapter = new listItemAdapter(firestoreRecyclerOptions, this);
        mAdapter.notifyDataSetChanged();
        listItemRecycler.setAdapter(mAdapter);
    }
    //metodo para que el usuario pueda añadir un habito nuevo "addhabit"
    public void goAdd(View view){
        Intent goAdd = new Intent(dashboard.this, addHabit.class);
        startActivity(goAdd);
    }
    //metodo que dirige al usuario a ajustes
    public void goSettings (View view){
        Intent goDashboard = new Intent(dashboard.this, settings.class);
        startActivity(goDashboard);
    }
    //metodo que dirige al usuario a calendario
    public void goCalendar (View view){
        Intent goCalendar = new Intent(dashboard.this, calendar.class);
        startActivity(goCalendar);
    }
    //revisa que traer
    @Override
    protected void onStart() {
        super.onStart(); //se muestra de forma activa en pant
        mAdapter.startListening();//trae y muestra
    }

    @Override
    protected void onStop() {
        super.onStop();//deja de traer
        mAdapter.stopListening();//contrario
    }
}