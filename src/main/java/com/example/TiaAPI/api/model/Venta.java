package com.example.TiaAPI.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_venta")
    private int idVenta;
    @ManyToOne
    @JoinColumn(name = "id_venta_producto")
    private VentaProducto ventaProducto;
    @ManyToOne
    @JoinColumn(name = "id_local")
    private Local local;
    @Column(name = "total")
    private double total;
    
    public Venta() {
    }

    public Venta(int idVenta, Local local, VentaProducto ventaProducto, double total) {
        this.idVenta = idVenta;
        this.local = local;
        this.ventaProducto = ventaProducto;
        this.total = total;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public VentaProducto getVentaProducto() {
        return ventaProducto;
    }

    public void setVentaProducto(VentaProducto ventaProducto) {
        this.ventaProducto = ventaProducto;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    
}
