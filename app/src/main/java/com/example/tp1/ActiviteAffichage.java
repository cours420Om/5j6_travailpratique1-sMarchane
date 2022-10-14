package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

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
    private ListView ma_liste;
    private adapterReservation adaptateur;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activite_affichage);
        Intent retour = new Intent();


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
        Bundle b_rep = extra.getExtras();
        ArrayList<reservation> listRes = b_rep.getParcelableArrayList("reservation");

        //retour.putExtras(b_rep);
        //ssetResult(RESULT_OK, retour);

        //Log.i("Test2", String.valueOf(resListe.get(0)));
        adaptateur = new adapterReservation(this, listRes);
        ma_liste.setAdapter(adaptateur);

        nom.setText("");
        place.setText("");
        date.setText("");





    }
}