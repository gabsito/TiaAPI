package com.example.TiaAPI.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class VentaProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_venta_producto")
    private int idVentaProducto;
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;
    @Column(name = "cantidad")
    private int cantidad;

    public VentaProducto(int idVentaProducto, Producto producto, int cantidad) {
        this.idVentaProducto = idVentaProducto;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public VentaProducto() {
    }

    public int getIdVentaProducto() {
        return idVentaProducto;
    }

    public void setIdVentaProducto(int idVentaProducto) {
        this.idVentaProducto = idVentaProducto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
