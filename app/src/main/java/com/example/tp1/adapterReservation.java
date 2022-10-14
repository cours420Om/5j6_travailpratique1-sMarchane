package com.example.tp1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class adapterReservation extends BaseAdapter {

    private Context dContexte;
    private List<reservation> resListe = new ArrayList<>();
    private TextView tv_nom, tv_place, tv_date;
    private ImageView iv_table;


    public adapterReservation(Context _context, ArrayList<reservation> _liste){
        this.resListe = _liste;
        this.dContexte = _context;

    }

    @Override
    public int getCount() {
        return resListe.size();
    }

    @Override
    public reservation getItem(int i) {
        return resListe.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {

        view = LayoutInflater.from(dContexte).inflate(R.layout.list_view_row, parent, false);
        tv_nom = view.findViewById(R.id.tv_nomListe);
        tv_nom.setText(this.getItem(i).getNomPersonne());

        tv_place = view.findViewById(R.id.tv_placeListe);
        tv_place.setText(this.getItem(i).getNbPlace());

        tv_date = view.findViewById(R.id.tv_dateListe);
        tv_date.setText(this.getItem(i).getBlocReservationDebut());

        return view;
    }
}
