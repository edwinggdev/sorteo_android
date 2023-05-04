package com.example.loteria.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.loteria.Entidades.Imagen;
import com.example.loteria.R;
import com.example.loteria.ViewHolders.MyImageHolder;

import java.util.List;

public class CompradoresAdapter {
    Context context;
    List<Imagen> items;

    public CompradoresAdapter(Context context, List<Imagen> items){
        this.context = context;
        this.items = items;
    }


}
