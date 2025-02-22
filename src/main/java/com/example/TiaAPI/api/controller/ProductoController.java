package com.example.TiaAPI.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.TiaAPI.api.model.Producto;
import com.example.TiaAPI.api.repo.ProductoRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ProductoController {

    @Autowired
    private ProductoRepo productoRepo;

    @GetMapping("/productos")
    public List<Producto> getProductos() {
        return productoRepo.findAll();
    }

    @GetMapping("/producto/{id}")
    public Producto getProducto(@PathVariable int id) {
        return productoRepo.findById(id).get();
    }

    @PostMapping("/producto")
    public Producto saveProducto(@RequestBody Producto producto) {
        return productoRepo.save(producto);
    }

    @PutMapping("/producto/{id}")
    public Producto updateProducto(@PathVariable int id, @RequestBody Producto producto) {
        Producto productoToUpdate = productoRepo.findById(id).get();
        productoToUpdate.setCodigoProducto(producto.getCodigoProducto());
        productoToUpdate.setPrecio(producto.getPrecio());
        productoToUpdate.setDescripcion(producto.getDescripcion());
        return productoRepo.save(productoToUpdate);
    }
    

}
