package com.example.loteria.ViewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loteria.ClickListener;
import com.example.loteria.R;

import java.lang.ref.WeakReference;

public class MyElegidoHolder extends RecyclerView.ViewHolder {
        public TextView elegido;
        private WeakReference<ClickListener> listenerRef;
        public MyElegidoHolder(@NonNull View itemView) {
            super(itemView);
            elegido = itemView.findViewById(R.id.it_ele);
        }
}

