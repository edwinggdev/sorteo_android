package com.example.loteria.ViewHolders;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.loteria.R;

public class MySorteoHolder  extends RecyclerView.ViewHolder{
    public ImageView imageView;
    public TextView precio, des,sid,nombre,fecha;
    public Bitmap Recycler_theImage;
    public byte[] Recycler_imageByte;

    public MySorteoHolder(@NonNull View itemView) {
        super(itemView);
        sid = itemView.findViewById(R.id.txId);
        nombre = itemView.findViewById(R.id.itv_sorteo);
        imageView = itemView.findViewById(R.id.itv_imagen);
        precio = itemView.findViewById(R.id.itv_precio);
        des = itemView.findViewById(R.id.itv_des);
        fecha = itemView.findViewById(R.id.itv_fecha);
    }
}
