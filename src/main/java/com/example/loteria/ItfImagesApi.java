package com.example.loteria;

import retrofit2.Call;

import com.example.loteria.Entidades.Imagen;
import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface ItfImagesApi {

    @GET("sorteo/imagenes/") //posts.php
    public Call<List<Imagen>> getImages(
            @Query("id") String idSorteo
    );


}
