package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ActiviteAffichage extends AppCompatActivity {

    restaurant restau;
    TextView tv_aff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activite_affichage);

        tv_aff = (TextView)findViewById(R.id.tv_titreAffichage);

        Intent extra = getIntent();
        restau = extra.getParcelableExtra("restaurant");

        tv_aff.setText("Affichage des réservation chez " + restau.getNomRestaurant());


    }
}