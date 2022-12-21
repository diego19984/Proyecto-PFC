package com.example.myapplication.adapters;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;
import com.example.myapplication.models.eefefe;

import java.util.ArrayList;

public class MensajeAdapter extends RecyclerView.Adapter<MensajeAdapter.ViewHolder> {

    private int resouce;
    private ArrayList<eefefe> mensajesEefefes;

    public MensajeAdapter(ArrayList<eefefe> mensajesEefefes, int resouce){
        this.mensajesEefefes=mensajesEefefes;
        this.resouce=resouce;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resouce,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int index) {

        eefefe mensaje = mensajesEefefes.get(index);
        holder.textViewMensaje.setText(mensaje.getLecturas());


    }

    @Override
    public int getItemCount() {

        return mensajesEefefes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView textViewMensaje;
        public View view;

        public ViewHolder(View view){
            super(view);
            this.view=view;
            this.textViewMensaje = (TextView) view.findViewById(R.id.textViewMensaje);

        }
    }
}
    