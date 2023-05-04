package com.example.loteria.ViewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.loteria.ClickListener;
import com.example.loteria.R;

import java.lang.ref.WeakReference;

public class MyCompradorHolder {
    public TextView elegido;
    private WeakReference<ClickListener> listenerRef;
    public MyCompradorHolder(@NonNull View itemView) {
        elegido = itemView.findViewById(R.id.it_ele);
    }
}
