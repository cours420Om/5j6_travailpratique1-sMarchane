package com.example.tp1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    restaurant restau;
    reservation res;
    List<restaurant> listRestau = new ArrayList<restaurant>();
    restaurant chezPierre;
    restaurant MacDonalds;
    restaurant boustan;
    ArrayList<reservation> listReservation = new ArrayList<reservation>();
    Button btnAfficher;


    int i;

    private Button bouton;


    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    if(result.getResultCode() == Activity.RESULT_OK){
                        Bundle bundle = result.getData().getExtras();

                        listReservation = bundle.getParcelableArrayList("res");
                        Log.i("Test", String.valueOf(listReservation.get(0)));
                    }



                }
            }
    );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAfficher = (Button)findViewById(R.id.btn_afficher);


        chezPierre = new restaurant(1, "chezPierre", 24, 24);
        MacDonalds = new restaurant(1, "MacDonalds", 30, 30);
        boustan = new restaurant(1, "boustan", 12, 12);
        listRestau.add(0, chezPierre);
        listRestau.add(1, MacDonalds);
        listRestau.add(2, boustan);

        Spinner sp_liste = (Spinner) findViewById(R.id.spin_liste);

        TextView tv_placerestante = (TextView) findViewById(R.id.tv_placeRestante);



        bouton = (Button) findViewById(R.id.btn_reserver);
        bouton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {



                Intent intent_afficherRestau = new Intent(MainActivity.this, ActiviteReservation.class);
                intent_afficherRestau.putExtra("restaurant", restau);
                activityResultLauncher.launch(intent_afficherRestau);

            }
        });
        btnAfficher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent_afficher = new Intent(MainActivity.this, ActiviteAffichage.class);
                intent_afficher.putExtra("res", listReservation );
                intent_afficher.putExtra("restaurant", restau);
                startActivity(intent_afficher);
                Log.i("Test4", String.valueOf(listReservation));


            }
        });



        ArrayAdapter<restaurant> adaptateur = new ArrayAdapter<restaurant>(this, android.R.layout.simple_spinner_dropdown_item, listRestau);
        sp_liste.setAdapter(adaptateur);

        sp_liste.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if((listRestau.get((i)).nbPlacesRestantes) > 5){
                    tv_placerestante.setText(listRestau.get((i)).nbPlacesRestantes + " places restantes");
                    tv_placerestante.setTextColor(getResources().getColor(R.color.jaune));

                    restau = listRestau.get(i);
                }else{
                    tv_placerestante.setText(listRestau.get((i)).nbPlacesRestantes + " places restantes");
                    tv_placerestante.setTextColor(getResources().getColor(R.color.rouge));

                    restau = listRestau.get(i);
                }




            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }




}