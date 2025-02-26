package com.example.TiaAPI.api.dto;

public class VentaRequest {

    private int localId;
    private int productoId;
    private int cantidad;

    public int getLocalId() {
        return localId;
    }
    public void setLocalId(int localId) {
        this.localId = localId;
    }
    public int getProductoId() {
        return productoId;
    }
    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


}
