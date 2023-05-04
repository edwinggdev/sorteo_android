package com.example.loteria;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.example.loteria.Entidades.Sorteo;
import com.example.loteria.ItfImagesApi;

public class RtfSorteCliente {
    private static RtfSorteCliente instance = null;
    private ItfSorteosApi myApi;

    private RtfSorteCliente(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:9011/")//"http://ginga.com.co/api/"
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = retrofit.create(ItfSorteosApi.class);
    }

    public static synchronized RtfSorteCliente getInstance(){
        if(instance == null){
            instance = new RtfSorteCliente();
        }
        return instance;
    }

    public ItfSorteosApi getMyApi(){
        return myApi;
    }
}
