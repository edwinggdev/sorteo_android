package com.example.loteria.Entidades;

public class Venta {
    int sorteo_id;
    String cedula_id;
    String numero1;
    String numero2;
    String numero3;
    String numero4;
    Double total;
    int boleto;
    String mensaje;
    String comprador;
    public Venta(int sorteo_id, String cedula, String numero1, String numero2, String numero3, String numero4, Double total) {
        this.sorteo_id = sorteo_id;
        this.cedula_id = cedula;
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.numero3 = numero3;
        this.numero4 = numero4;
        this.total = total;
    }

    public int getSorteo_id() {
        return sorteo_id;
    }

    public void setSorteo_id(int sorteo_id) {
        this.sorteo_id = sorteo_id;
    }

    public String getCedula() {
        return cedula_id;
    }

    public void setCedula(String cedula) {
        this.cedula_id = cedula;
    }

    public String getNumero1() {
        return numero1;
    }

    public void setNumero1(String numero1) {
        this.numero1 = numero1;
    }

    public String getNumero2() {
        return numero2;
    }

    public void setNumero2(String numero2) {
        this.numero2 = numero2;
    }

    public String getNumero3() {
        return numero3;
    }

    public void setNumero3(String numero3) {
        this.numero3 = numero3;
    }

    public String getNumero4() {
        return numero4;
    }

    public void setNumero4(String numero4) {
        this.numero4 = numero4;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public int getBoleto() {
        return boleto;
    }

    public void setBoleto(int boleto) {
        this.boleto = boleto;
    }

    public String getMensaje() { return mensaje; }

    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public String getComprador() { return comprador; }

    public void setComprador(String comprador) { comprador = comprador; }
}
