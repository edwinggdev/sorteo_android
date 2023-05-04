package com.example.loteria.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.loteria.Entidades.Sorteo;
import com.example.loteria.R;
import com.example.loteria.ViewHolders.MySorteoHolder;

import java.io.ByteArrayInputStream;
import java.util.List;

public class SorteoAdapter extends RecyclerView.Adapter<MySorteoHolder> implements View.OnClickListener {
    Context context;
    List<Sorteo> items;
    View.OnClickListener listener;
    private Object Recycler_adapter_image;

    public SorteoAdapter(Context context, List<Sorteo> items){
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public MySorteoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        view.setOnClickListener((View.OnClickListener)this);
        return new MySorteoHolder(view);
        //return new MySorteoHolder(LayoutInflater.from(context).inflate(R.layout.item,parent,false));

        //return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MySorteoHolder holder, int position) {
       /* Log.d("sorteo","onBind");
        String base64String = items.get(position).getImagen();
        Log.d("sorteo","imagebytes: " + base64String);
        byte[] imageByteArray = Base64.decode(base64String, Base64.DEFAULT);
        Log.d("sorteo","imageByteArray: " + imageByteArray); */
        Glide
                .with(context)
                .load(items.get(position).getImagen())
               // .load(imageByteArray)
                .centerCrop()
                //.placeholder(R.drawable.loading_spinner)
                .into(holder.imageView);
        //Base64.decode(base64String, Base64.DEFAULT)
       /* byte[] decodeResponse = Base64.decode(base64String, Base64.DEFAULT | Base64.NO_WRAP);
        Log.d("sorteo","decodeResponse: " + decodeResponse);
        Bitmap bitmap = BitmapFactory.decodeByteArray(decodeResponse, 0, decodeResponse.length);
        try {
            byte[] Recycler_imageByte;
            //holder.Recycler_imageByte = imageBytes;
            Bitmap Recycler_theImage;


           // ByteArrayInputStream imageStream = new ByteArrayInputStream(imageByteArray);
            //holder.Recycler_theImage = BitmapFactory.decodeStream(imageStream);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.outHeight = 32; //32 pixles
            options.outWidth = 32; //32 pixles
            options.outMimeType = "image/jpeg";//image_icon_type; //this could be image/jpeg, image/png, etc

            Bitmap bitmap = BitmapFactory.decodeByteArray(imageByteArray, 0, imageByteArray.length, options);
            Glide.with(context).load(bitmap).into((ImageView) holder.imageView);
        }catch (Exception ex){ Log.d("sorte","EX: " + ex); } */
        //holder.imageView.setImageResource(items.get(position).getImage());
        holder.sid.setText(items.get(position).getId() + "");
        holder.nombre.setText(items.get(position).getNombre().toString());
        holder.precio.setText(items.get(position).getValorb().toString());
        holder.des.setText(items.get(position).getDescripcion());
        holder.fecha.setText(items.get(position).getFecha());
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
        Log.d("sorteo","Presionado: ");
        if(listener != null){
            listener.onClick(view);
        }
    }
}
