package com.example.loteria;

import com.example.loteria.Entidades.Numero;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ItfNumerosApi {

        @GET("numero/id") //posts.php
        public Call<List<Numero>> getNumeros(
                @Query("id") String idSorteo
        );


    }
