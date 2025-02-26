package com.example.TiaAPI.api.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.TiaAPI.api.dto.VentaRequest;
import com.example.TiaAPI.api.model.Local;
import com.example.TiaAPI.api.model.Producto;
import com.example.TiaAPI.api.model.Venta;
import com.example.TiaAPI.api.repo.LocalRepo;
import com.example.TiaAPI.api.repo.ProductoRepo;
import com.example.TiaAPI.api.repo.VentaRepo;


@RestController
public class VentaController {

    @Autowired
    private VentaRepo ventaRepo;

    @Autowired
    private LocalRepo localRepo;

    @Autowired
    private ProductoRepo productoRepo;

    @GetMapping("/ventas")
    public ResponseEntity<List<Venta>> getVentas() {
        List<Venta> ventas = ventaRepo.findAll();

        if (ventas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(ventas);
    }

    @GetMapping("/ventas/{id}")
    public ResponseEntity<Venta> getVenta(int id) {
        Venta venta = ventaRepo.findById(id).orElse(null);

        if (venta == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(venta);
    }

    @GetMapping("/ventas/local")
    public ResponseEntity<List<Venta>> getVentasByLocal(@RequestParam int idLocal) {
        List<Venta> ventas = ventaRepo.findByLocal_idLocal(idLocal);

        if (ventas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(ventas);
    }

    @PostMapping("/ventas")
    public ResponseEntity<?> saveVenta(@RequestParam VentaRequest request) {
        if (request.getCantidad() <= 0) {
            String mensaje = "La cantidad vendida debe ser mayor a 0";
            return ResponseEntity.badRequest().body(mensaje);
        }

        Optional<Local> local = localRepo.findById(request.getLocalId());
        Optional<Producto> producto = productoRepo.findById(request.getProductoId());

        if (!local.isPresent()) {
            String mensaje = "El local con id: " + request.getLocalId() + " no existe";
            return ResponseEntity.badRequest().body(mensaje);
        }

        if (!producto.isPresent()) {
            String mensaje = "El producto con id: " + request.getProductoId() + " no existe";
            return ResponseEntity.badRequest().body(mensaje);
        }

        Venta venta = new Venta();
        venta.setLocal(local.get());
        venta.setProducto(producto.get());
        venta.setCantidad(request.getCantidad());
        venta.setFechaVenta(LocalDateTime.now());

        Venta ventaGuardada = ventaRepo.save(venta);
        return ResponseEntity.ok(ventaGuardada);

    }

    


    
}
