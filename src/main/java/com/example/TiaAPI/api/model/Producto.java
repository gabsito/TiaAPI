package com.example.TiaAPI.api.model;

public class Producto {

    private int idProducto;
    private String codigoProducto;
    private String descripcion;
    private double precio;
    
    public Producto(int idProducto, String codigoProducto, String descripcion, double precio) {
        this.idProducto = idProducto;
        this.codigoProducto = codigoProducto;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    
}
