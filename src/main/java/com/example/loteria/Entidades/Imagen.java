package com.example.loteria.Entidades;

public class Imagen {
   // int id;
    String url;
    String texto;

    public Imagen(int id, String url, String texto) {
        //this.id = id;
        this.url = url;
        this.texto = texto;
    }

   /* public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }*/

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
