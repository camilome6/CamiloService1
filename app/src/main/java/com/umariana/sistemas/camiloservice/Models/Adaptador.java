package com.umariana.sistemas.camiloservice.Models;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.umariana.sistemas.camiloservice.R;

import java.util.ArrayList;

/**
 * Created by sistemas on 5/06/17.
 */

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {
    private ArrayList<Presidentes> dataset;

    private Context context;

    public Adaptador(Context context) {
        this.context = context;
        dataset = new ArrayList<>();

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_presidentes, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Presidentes p= dataset.get(position);
        holder.idnombre.setText(p.getIdnombre().toString());
        holder.idnombre.setText(p.getIdnombre().toString());
        holder.idmunicipio.setText(p.getIdmunicipio().toString());
        holder.iddepartamento.setText(p.getIddepartamento().toString());
        holder.idveredabarrio.setText(p.getIdveredabarrio().toString());



    }

    @Override
    public int getItemCount() {

        return dataset.size();
    }

    public void ListaPresidentes(ArrayList<Presidentes> listaPresidentes) {
        dataset.addAll(listaPresidentes);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView idnombre;
        private TextView idmunicipio;
        private TextView iddepartamento;
        private TextView idveredabarrio;


        public ViewHolder(View itemView) {
            super(itemView);


            idnombre= (TextView) itemView.findViewById(R.id.idnombre);
            idmunicipio= (TextView) itemView.findViewById(R.id.idmunicipio);
            iddepartamento= (TextView) itemView.findViewById(R.id.iddepartamento);
            idveredabarrio= (TextView) itemView.findViewById(R.id.idveredabarrio);

        }
    }
}


