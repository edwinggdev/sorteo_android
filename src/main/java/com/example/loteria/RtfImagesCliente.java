package com.example.loteria;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RtfImagesCliente {
        private static com.example.loteria.RtfImagesCliente instance = null;
        private ItfImagesApi myApi;

        private RtfImagesCliente(){
            /*Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();*/
            Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.197.1:9011/")//"http://10.0.2.2:9011/"
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            myApi = retrofit.create(ItfImagesApi.class);
        }

        public static synchronized com.example.loteria.RtfImagesCliente getInstance(){
            if(instance == null){
                instance = new com.example.loteria.RtfImagesCliente();
            }
            return instance;
        }

        public ItfImagesApi getMyApi(){
            return myApi;
        }
    }
