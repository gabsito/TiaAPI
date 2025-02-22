package com.example.TiaAPI.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_stock")
    private int idStock;
    @OneToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;
    @OneToOne
    @JoinColumn(name = "id_local")
    private Local local;
    @Column(name = "cantidad")
    private int cantidad;
    
    public Stock(Producto producto, Local local, int cantidad) {
        this.producto = producto;
        this.local = local;
        this.cantidad = cantidad;
    }

    public Stock() {
    }

    public int getIdStock() {
        return idStock;
    }

    public void setIdStock(int idStock) {
        this.idStock = idStock;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
}
