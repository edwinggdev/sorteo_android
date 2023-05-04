package com.example.loteria.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loteria.R;

public class MyImageHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public TextView texto;
    public MyImageHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.it_im_imagen);
        texto = itemView.findViewById(R.id.it_im_texto);
    }
}
