package com.example.loteria.ViewHolders;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loteria.ClickListener;
import com.example.loteria.R;

import java.lang.ref.WeakReference;

public class MyNumeroHolder extends RecyclerView.ViewHolder {
    public TextView numero;
    private WeakReference<ClickListener> listenerRef;
    public MyNumeroHolder(@NonNull View itemView) {
        super(itemView);
        numero = itemView.findViewById(R.id.it_num);
    }

    /*@Override
    public void onClick(View v) {
        if (v.getId() == numero.getId()) {
            Toast.makeText(v.getContext(), "ITEM PRESSED = " + String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(v.getContext(), "ROW PRESSED = " + String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
        }

        listenerRef.get().onPositionClicked(getAdapterPosition());
    }*/
}
