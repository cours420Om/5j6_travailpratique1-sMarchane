package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Spinner sp_liste = (Spinner) findViewById(R.id.spin_liste);
        ArrayList<String> listRestau = new ArrayList<>();
        listRestau.add("MacDonalds");
        listRestau.add("A&W");
        listRestau.add("Harveys");

        ArrayAdapter<String> adaptateur = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, listRestau);

        sp_liste.setAdapter(adaptateur);
    }
}