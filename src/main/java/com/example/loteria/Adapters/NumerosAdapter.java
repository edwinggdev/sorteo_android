package com.example.loteria.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.loteria.Entidades.Imagen;
import com.example.loteria.Entidades.Numero;
import com.example.loteria.R;
import com.example.loteria.ViewHolders.MyImageHolder;
import com.example.loteria.ViewHolders.MyNumeroHolder;
import com.example.loteria.ViewHolders.MySorteoHolder;

import java.util.List;

public class NumerosAdapter extends RecyclerView.Adapter<MyNumeroHolder> implements View.OnClickListener {
    Context context;
    List<Numero> items;
    View.OnClickListener listener;
    public NumerosAdapter(Context context, List<Numero> items) {
        this.context = context;
        this.items = items;
    }


    @NonNull
    @Override
    public MyNumeroHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_numeros,parent,false);
        view.setOnClickListener((View.OnClickListener)this);
        return new MyNumeroHolder(view);
        //return new MyNumeroHolder(LayoutInflater.from(context).inflate(R.layout.item_numeros, parent, false));
        //return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyNumeroHolder holder, int position) {

        //holder.imageView.setImageResource(items.get(position).getImage());
        // holder.texto.setText(items.get(position).getTexto());
        holder.numero.setText(items.get(position).getNumero());
    }
    @Override
    public int getItemCount() {
        return items.size();
        //return 0;
    }
    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }
    @Override
    public void onClick(View view) {
        if(listener != null){
            listener.onClick(view);
        }
    }
}
