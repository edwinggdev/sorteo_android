package com.example.loteria;

import com.example.loteria.Entidades.Imagen;
import com.example.loteria.Entidades.Usuario;
import com.example.loteria.Entidades.Venta;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ItfVentasApi {


        @POST("venta/")
        Call<Venta> agregarVenta(
                @Body Venta venta
        );


    }
