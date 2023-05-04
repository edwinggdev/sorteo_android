package com.example.loteria.Entidades;

public class Usuario {
    Long id;
    String cedula;
    String nombres;
    String telefono;

    public Usuario(String cedula, String nombres, String telefono) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.telefono = telefono;
    }

    public Usuario(Long id, String cedula, String nombres, String telefono) {
        this.id = id;
        this.cedula = cedula;
        this.nombres = nombres;
        this.telefono = telefono;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
