package com.pdg.WhatsApp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pdg.WhatsApp.R;

import java.util.List;

public class EstadoRecyclerAdapter extends RecyclerView.Adapter<EstadoRecyclerAdapter.EstadosDataHolder>{


    private final List<Hobby> estadoList;
    private final OnItemClickListener itemListener;

    public EstadoAdapter(List<Estado> hobbies, OnItemClickListener itemListener) {
        this.estadoList = hobbies;
        this.itemListener = itemListener;
    }

    @NonNull
    @Override
    public EstadosDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hobby_item, parent, false);
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
        TextView type;
        TextView title;
        TextView note;

        public EstadosDataHolder(@NonNull View itemView) {
            super(itemView);
            type = (TextView) itemView.findViewById(R.id.textoTipo);
            title = (TextView) itemView.findViewById(R.id.textoTitulo);
            note = (TextView) itemView.findViewById(R.id.textoNota);
        }

        public void assignData(Estado estado, OnItemClickListener itemListener){

            this.type.setText(estado.getTipo());
            this.title.setText(estado.getNombre());
            this.note.setText(String.valueOf(estado.getNota()));

            itemView.setOnClickListener(view -> itemListener.onItemClick(estado,getAdapterPosition()));
        }
    }

    public interface OnItemClickListener{
        void onItemClick(Estado estado, int position);
    }
}
