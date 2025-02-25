package com.example.TiaAPI.api.dto;

public class StockRequest {

    private int productoId;
    private int localId;
    private int cantidad;

    
    public int getProductoId() {
        return productoId;
    }
    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }
    public int getLocalId() {
        return localId;
    }
    public void setLocalId(int localId) {
        this.localId = localId;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    @Override
    public String toString() {
        return "StockRequest [productoId=" + productoId + ", localId=" + localId + ", cantidad=" + cantidad + "]";
    }

    

}
