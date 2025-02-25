package com.example.TiaAPI.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.TiaAPI.api.model.Venta;
import com.example.TiaAPI.api.repo.VentaRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class VentaController {

    @Autowired
    private VentaRepo ventaRepo;

    @GetMapping("/ventas")
    public ResponseEntity<List<Venta>> getVentas() {
        List<Venta> ventas = ventaRepo.findAll();

        if (ventas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(ventas);
    }

    @GetMapping("/venta/{id}")
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

    


    
}
