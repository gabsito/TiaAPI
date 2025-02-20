package com.example.TiaAPI.api.model;

public class VentaProducto {

    private int idVentaProducto;
    private int idProducto;
    private int cantidad;

    public VentaProducto(int idVentaProducto, int idProducto, int cantidad) {
        this.idVentaProducto = idVentaProducto;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }

    public int getIdVentaProducto() {
        return idVentaProducto;
    }

    public void setIdVentaProducto(int idVentaProducto) {
        this.idVentaProducto = idVentaProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
