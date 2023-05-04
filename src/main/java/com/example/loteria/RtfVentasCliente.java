package com.example.loteria;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RtfVentasCliente {
        private static com.example.loteria.RtfVentasCliente instance = null;
        private ItfVentasApi myApi;

        private RtfVentasCliente(){
            /*Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();*/
            Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:9011/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            myApi = retrofit.create(ItfVentasApi.class);
        }

        public static synchronized com.example.loteria.RtfVentasCliente getInstance(){
            if(instance == null){
                instance = new com.example.loteria.RtfVentasCliente();
            }
            return instance;
        }

        public ItfVentasApi getMyApi(){
            return myApi;
        }
    }
