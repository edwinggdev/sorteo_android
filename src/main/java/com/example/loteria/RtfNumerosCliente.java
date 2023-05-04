package com.example.loteria;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RtfNumerosCliente {
        private static com.example.loteria.RtfNumerosCliente instance = null;
        private ItfNumerosApi myApi;

        private RtfNumerosCliente(){
            /*Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();*/
            Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:9011/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            myApi = retrofit.create(ItfNumerosApi.class);
        }

        public static synchronized com.example.loteria.RtfNumerosCliente getInstance(){
            if(instance == null){
                instance = new com.example.loteria.RtfNumerosCliente();
            }
            return instance;
        }

        public ItfNumerosApi getMyApi(){
            return myApi;
        }
    }
