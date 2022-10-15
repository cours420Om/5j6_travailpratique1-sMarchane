package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActiviteAffichage extends AppCompatActivity {

    restaurant restau;
    reservation res;
    EditText et_date;
    EditText et_heureDepart;
    EditText et_nomRes;
    EditText et_num;
    Spinner spn_heureDebut;
    TextView tv_aff;
    ImageView iv_table;
    TextView nom;
    TextView place;
    TextView date;
    ArrayList<reservation> listReservation = new ArrayList<reservation>();
    //ArrayList<reservation> listRes = new ArrayList<reservation>();
    private ListView ma_liste;
    private adapterReservation adaptateur;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activite_affichage);
        Intent retour = new Intent();
        Context contexte = getApplicationContext();
        int duree = Toast.LENGTH_SHORT;


        tv_aff = (TextView)findViewById(R.id.tv_titreAffichage);
        iv_table = (ImageView)findViewById(R.id.iv_imageListe);
        nom = (TextView)findViewById(R.id.tv_nomListe);
        place = (TextView)findViewById(R.id.tv_placeListe);
        date = (TextView)findViewById(R.id.tv_dateListe);
        et_date = (EditText)findViewById(R.id.et_date);
        et_heureDepart = (EditText)findViewById(R.id.et_heureDepart);
        et_nomRes = (EditText)findViewById(R.id.et_nom);
        et_num = (EditText)findViewById(R.id.et_Phone);
        spn_heureDebut = (Spinner)findViewById(R.id.sp_heureDebut);

        Intent extra = getIntent();
        restau = extra.getParcelableExtra("restaurant");




        tv_aff.setText("Affichage des réservation chez " + restau.getNomRestaurant());

        ma_liste = (ListView) findViewById(R.id.lv_reservation);

        /*resListe.add(new reservation(1, " " + et_date.getText(), restau.getNbPlacesRestantes(),
                " " + spn_heureDebut.getSelectedItem(),
                " " + et_heureDepart.getText(), " " + et_nomRes.getText(), " " + et_num.getText()));*/


        /*Intent extra2 = getIntent();
        resListe = extra2.getParcelableExtra("reservation");*/
        //Bundle b_rep = extra.getExtras();


        //retour.putExtras(b_rep);
        //ssetResult(RESULT_OK, retour);



        Bundle b_rep = new Bundle();
        listReservation = b_rep.getParcelableArrayList("res");
        //b_rep.getParcelableArrayList("res");
        retour.putExtras(b_rep);
        setResult(RESULT_OK, retour);
        adaptateur = new adapterReservation(this, listReservation);
        ma_liste.setAdapter(adaptateur);
        Log.i("testeur", String.valueOf(listReservation));

        /*Bundle bReservation = extra.getBundleExtra("res");
        ArrayList<reservation> listReservation = bReservation.getParcelableArrayList("res");
        Log.i("testeur", String.valueOf(listReservation));*/




        //ArrayList<reservation> listReservation = b_rep.getParcelableArrayList("res");
        //listReservation.add(res);
        //b_rep.putParcelableArrayList("res", listReservation);

        //retour.putExtra("reservation", res);




        //Log.i("Test2", String.valueOf(resListe.get(0)));
        //Log.i("testeur", String.valueOf(listReservation.get(0)));

        /*nom.setText("" + res.getNomPersonne());
        place.setText("" + res.getNbPlace());
        date.setText("" + res.getBlocReservationDebut() + "" + res.getBlocReservationFin());*/



        //String reservation = extra.getParcelableExtra("res");



        /*Intent intent = getIntent();
        listReservation = intent.getParcelableArrayListExtra("res");
        Log.i("testeur", String.valueOf(listReservation));*/




    }
}