package com.example.TiaAPI.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.TiaAPI.api.model.Producto;
import com.example.TiaAPI.api.repo.ProductoRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Producto>> getProductos() {
        List<Producto> productos = productoRepo.findAll();

        if (productos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(productos);
    }

    @GetMapping("/producto/{id}")
    public ResponseEntity<Producto> getProducto(@PathVariable int id) {
        Producto producto = productoRepo.findById(id).orElse(null);

        if (producto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(producto);
    }

    @GetMapping("/producto/codigo/{codigo}")
    public ResponseEntity<Producto> getProductoByCodigo(@PathVariable String codigo) {
        Producto producto = productoRepo.findByCodigoProducto(codigo);

        if (producto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(producto);
    }

    @PostMapping("/producto")
    public ResponseEntity<?> saveProducto(@RequestBody Producto producto) {
        // verificar si los datos ingresados no son null o vacios
        if (producto.getCodigoProducto() == null || producto.getCodigoProducto().isEmpty()) {
            String mensaje = "El codigo del producto es requerido";
            return ResponseEntity.badRequest().body(mensaje);
        }

        if (producto.getDescripcion() == null || producto.getDescripcion().isEmpty()) {
            String mensaje = "La descripcion del producto es requerida";
            return ResponseEntity.badRequest().body(mensaje);
        }

        if (producto.getPrecio() <= 0) {
            String mensaje = "El precio del producto es requerido";
            return ResponseEntity.badRequest().body(mensaje);
        }
        // verificar si el producto ya existe por codigo
        Producto productoExistente = productoRepo.findByCodigoProducto(producto.getCodigoProducto());
        if (productoExistente != null) {
            String mensaje = "Ya existe un producto con codigo " + producto.getCodigoProducto();
            return ResponseEntity.badRequest().body(mensaje);
        }

        return ResponseEntity.ok(productoRepo.save(producto));
    }

    @PutMapping("/producto/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable int id, @RequestBody Producto producto) {
        Producto productoToUpdate = productoRepo.findById(id).get();

        if (productoToUpdate == null) {
            return ResponseEntity.notFound().build();
        }

        productoToUpdate.setCodigoProducto(producto.getCodigoProducto());
        productoToUpdate.setPrecio(producto.getPrecio());
        productoToUpdate.setDescripcion(producto.getDescripcion());
        
        return ResponseEntity.ok(productoRepo.save(productoToUpdate));
    }
    

}
