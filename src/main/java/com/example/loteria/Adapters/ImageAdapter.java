package com.example.loteria.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.loteria.Entidades.Imagen;
import com.example.loteria.R;
import com.example.loteria.ViewHolders.MyImageHolder;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<MyImageHolder> {
    Context context;
    List<Imagen> items;

    public ImageAdapter(Context context, List<Imagen> items){
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public MyImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyImageHolder(LayoutInflater.from(context).inflate(R.layout.item_images,parent,false));
        //return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyImageHolder holder, int position) {
        Glide
                .with(context)
                .load(items.get(position).getUrl())
                .centerCrop()
                //.placeholder(R.drawable.loading_spinner)
                .into(holder.imageView);
        //holder.imageView.setImageResource(items.get(position).getImage());
       // holder.texto.setText(items.get(position).getTexto());
        holder.texto.setText("");
    }

    @Override
    public int getItemCount() {
        return items.size();
        //return 0;
    }
}