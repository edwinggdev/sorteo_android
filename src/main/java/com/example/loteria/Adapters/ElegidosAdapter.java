package com.example.loteria.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loteria.Entidades.Numero;
import com.example.loteria.R;
import com.example.loteria.ViewHolders.MyElegidoHolder;

import java.util.List;

public class ElegidosAdapter extends RecyclerView.Adapter<MyElegidoHolder> implements View.OnClickListener, View.OnLongClickListener {
    Context context;
    List<Numero> items;
    View.OnClickListener listener;
    View.OnLongClickListener lListener;
    private static View.OnClickListener onclicklistner;
    public ElegidosAdapter(Context context, List<Numero> items) {
        this.context = context;
        this.items = items;
    }


    @NonNull
    @Override
    public MyElegidoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_elegidos,parent,false);
        view.setOnClickListener((View.OnClickListener)this);
        return new MyElegidoHolder(view);
        //return new MyNumeroHolder(LayoutInflater.from(context).inflate(R.layout.item_numeros, parent, false));
        //return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyElegidoHolder holder, int position) {

        //holder.imageView.setImageResource(items.get(position).getImage());
        // holder.texto.setText(items.get(position).getTexto());
        holder.elegido.setText(items.get(position).getNumero());
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

    public void setOnLongClickListener(View.OnLongClickListener lListener){ this.lListener = lListener; }
    @Override
    public boolean onLongClick(View view) {
        lListener.onLongClick(view);
        return true;
    }
}
