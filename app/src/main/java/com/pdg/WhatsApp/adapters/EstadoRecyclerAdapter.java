package com.pdg.WhatsApp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pdg.WhatsApp.R;
import com.pdg.WhatsApp.model.Estado;

import java.util.List;

public class EstadoRecyclerAdapter extends RecyclerView.Adapter<EstadoRecyclerAdapter.EstadosDataHolder>{
    private final List<Estado> estadoList;
    private final OnItemClickListener itemListener;

    public EstadoRecyclerAdapter(List<Estado> estados, OnItemClickListener itemListener) {
        this.estadoList = estados;
        this.itemListener = itemListener;
    }

    @NonNull
    @Override
    public EstadosDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.estado_item, parent, false);
        return new EstadosDataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EstadosDataHolder holder, int position) {
        holder.assignData(estadoList.get(position),itemListener);
    }

    @Override
    public int getItemCount() {
        return estadoList.size();
    }

    public static class EstadosDataHolder extends RecyclerView.ViewHolder {
        TextView nombreUsuario;
        TextView tiempo;
        ImageView fotoEstado;

        public EstadosDataHolder(@NonNull View itemView) {
            super(itemView);
            nombreUsuario = (TextView) itemView.findViewById(R.id.nombreEstado);
            tiempo = (TextView) itemView.findViewById(R.id.tiempoEstado);
            fotoEstado = (ImageView) itemView.findViewById(R.id.fotoEstado);
        }

        public void assignData(Estado estado, OnItemClickListener itemListener){

            this.nombreUsuario.setText(estado.getNombreUsuario());
            this.tiempo.setText(estado.getTiempo());
            //this.fotoEstado

            itemView.setOnClickListener(view -> itemListener.onItemClick(estado,getAdapterPosition()));
        }
    }

    public interface OnItemClickListener{
        void onItemClick(Estado estado, int position);
    }
}
