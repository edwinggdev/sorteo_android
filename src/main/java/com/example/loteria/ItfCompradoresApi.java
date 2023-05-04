package com.example.loteria;

import com.example.loteria.Entidades.Imagen;
import com.example.loteria.Entidades.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ItfCompradoresApi {
    @GET("usuario/") //posts.php
    public Call<List<Imagen>> getUsuarios();

    @GET("usuario/cedula")
    Call<Usuario> getUsuario(
            @Query("cedula") String cedula
    );

    @POST("usuario/")
    Call<Void> agregarUsuario(
            @Body Usuario usuario
    );

  }

