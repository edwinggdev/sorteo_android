package com.example.loteria.Entidades;

public class Sorteo {
    int id;
    String nombre;
    Double valorb;
    String des;
    String fecha;
    String url;
    String imgp2;

    public Sorteo(Double precio, String descripcion, String url) {
        this.valorb = precio;
        this.des = descripcion;
        this.url = url;
    }

    public Sorteo(int id, Double precio, String nombre,String descripcion, String url) {
        this.nombre = nombre;
        this.id = id;
        this.valorb = precio;
        this.des = descripcion;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getValorb() {
        return valorb;
    }

    public void setValorb(Double precio) {
        this.valorb = precio;
    }

    public String getDescripcion() {
        return des;
    }

    public void setDescripcion(String descripcion) {
        this.des = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImagen() {
        return imgp2;
    }

    public void setImagen(String imagen) {
        this.imgp2 = imagen;
    }
}
