package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button bouton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bouton = (Button) findViewById(R.id.btn_reserver);
        bouton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                openActiviteReservation();
            }
        });


        Spinner sp_liste = (Spinner) findViewById(R.id.spin_liste);
        ArrayList<String> listRestau = new ArrayList<>();
        listRestau.add("MacDonalds");
        listRestau.add("A&W");
        listRestau.add("Harveys");

        ArrayAdapter<String> adaptateur = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, listRestau);

        sp_liste.setAdapter(adaptateur);
    }

    public void openActiviteReservation(){
        Intent intent = new Intent(this, ActiviteReservation.class);
        startActivity(intent);
    }
}