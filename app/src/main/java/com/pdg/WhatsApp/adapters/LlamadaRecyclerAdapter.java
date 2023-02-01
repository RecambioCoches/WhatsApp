package com.pdg.WhatsApp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pdg.WhatsApp.R;

import java.util.List;

public class LlamadaRecyclerAdapter extends RecyclerView.Adapter<LlamadaRecyclerAdapter.LlamadasDataHolder>{

    private final List<Llamada> llamadaList;
    private final OnItemClickListener itemListener;

    public LlamadaAdapter(List<Llamada> llamadas, OnItemClickListener itemListener) {
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
        TextView type;
        TextView title;
        TextView note;

        public LlamadasDataHolder(@NonNull View itemView) {
            super(itemView);
            type = (TextView) itemView.findViewById(R.id.textoTipo);
            title = (TextView) itemView.findViewById(R.id.textoTitulo);
            note = (TextView) itemView.findViewById(R.id.textoNota);
        }

        public void assignData(Llamada llamada, OnItemClickListener itemListener){

            this.type.setText(llamada.getTipo());
            this.title.setText(llamada.getNombre());
            this.note.setText(String.valueOf(llamada.getNota()));

            itemView.setOnClickListener(view -> itemListener.onItemClick(llamada,getAdapterPosition()));
        }
    }

    public interface OnItemClickListener{
        void onItemClick(Llamada llamada, int position);
    }

}
