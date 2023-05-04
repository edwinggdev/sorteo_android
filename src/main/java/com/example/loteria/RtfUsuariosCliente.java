package com.example.loteria;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RtfUsuariosCliente {
        private static com.example.loteria.RtfUsuariosCliente instance = null;
        private ItfCompradoresApi myApi;

        private RtfUsuariosCliente(){
            /*Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();*/
            Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:9011/") //http://ginga.com.co/api/
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            myApi = retrofit.create(ItfCompradoresApi.class);
        }

        public static synchronized com.example.loteria.RtfUsuariosCliente getInstance(){
            if(instance == null){
                instance = new com.example.loteria.RtfUsuariosCliente();
            }
            return instance;
        }

        public ItfCompradoresApi getMyApi(){
            return myApi;
        }
    }
