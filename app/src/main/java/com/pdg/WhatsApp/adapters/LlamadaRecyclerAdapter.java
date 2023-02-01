package com.pdg.WhatsApp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pdg.WhatsApp.R;
import com.pdg.WhatsApp.model.Llamada;

import java.util.List;

public class LlamadaRecyclerAdapter extends RecyclerView.Adapter<LlamadaRecyclerAdapter.LlamadasDataHolder>{

    private final List<Llamada> llamadaList;
    private final OnItemClickListener itemListener;

    public LlamadaRecyclerAdapter(List<Llamada> llamadas, OnItemClickListener itemListener) {
        this.llamadaList = llamadas;
        this.itemListener = itemListener;
    }

    @NonNull
    @Override
    public LlamadasDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.llamada_item, parent, false);
        return new LlamadasDataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LlamadasDataHolder holder, int position) {
        holder.assignData(llamadaList.get(position),itemListener);
    }

    @Override
    public int getItemCount() {
        return llamadaList.size();
    }

    public static class LlamadasDataHolder extends RecyclerView.ViewHolder {
        TextView nombre;
        TextView fecha;
        TextView estado;
        ImageView foto;

        public LlamadasDataHolder(@NonNull View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.nombreLlamada);
            fecha = (TextView) itemView.findViewById(R.id.fechaLlamada);
            estado = (TextView) itemView.findViewById(R.id.estadoLlamada);
            foto = (ImageView) itemView.findViewById(R.id.fotoLlamada);
        }

        public void assignData(Llamada llamada, OnItemClickListener itemListener){

            this.nombre.setText(llamada.getNombreUsuario());
            this.fecha.setText(llamada.getFecha());
            this.estado.setText(llamada.getEstadoLlamada());
            //this.foto;

            itemView.setOnClickListener(view -> itemListener.onItemClick(llamada,getAdapterPosition()));
        }
    }

    public interface OnItemClickListener{
        void onItemClick(Llamada llamada, int position);
    }

}
