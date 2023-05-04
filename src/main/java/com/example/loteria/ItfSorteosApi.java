package com.example.loteria;

import com.example.loteria.Entidades.Sorteo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ItfSorteosApi {
        //@GET("sorteos/") //posts.php
        @GET("sorteo/")
        public Call<List<Sorteo>> getSorteos();

    }
