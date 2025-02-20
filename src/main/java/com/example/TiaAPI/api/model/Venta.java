package com.example.TiaAPI.api.model;

public class Venta {

    private int idVenta;
    private int idVentaProducto;
    private int idLocal;
    private double total;
    
    public Venta(int idVenta, int idVentaProducto, int idLocal, double total) {
        this.idVenta = idVenta;
        this.idVentaProducto = idVentaProducto;
        this.idLocal = idLocal;
        this.total = total;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdVentaProducto() {
        return idVentaProducto;
    }

    public void setIdVentaProducto(int idVentaProducto) {
        this.idVentaProducto = idVentaProducto;
    }

    public int getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    
}
