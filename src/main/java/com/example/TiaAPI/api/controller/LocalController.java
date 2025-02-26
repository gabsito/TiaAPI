package com.example.TiaAPI.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.TiaAPI.api.model.Local;
import com.example.TiaAPI.api.repo.LocalRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class LocalController {

    @Autowired
    private LocalRepo localRepo;

    @GetMapping("/locales")
    public ResponseEntity<List<Local>> getLocales() {
        List<Local> locales = localRepo.findAll();

        if (locales.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(locales);
    }

    @GetMapping("/locales/{id}")
    public ResponseEntity<Local> getLocal(@PathVariable int id) {
        Local local = localRepo.findById(id).orElse(null);

        if (local == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(local);
    }

    @PostMapping("/locales")
    public ResponseEntity<?> saveLocal(@RequestBody Local local) {
        // verificar si los datos ingresados no son null o vacios
        if (local.getCodigoLocal() == null || local.getCodigoLocal().isEmpty()) {
            String mensaje = "El codigo del local es requerido";
            return ResponseEntity.badRequest().body(mensaje);
        }

        if (local.getDireccion() == null || local.getDireccion().isEmpty()) {
            String mensaje = "La direccion del local es requerida";
            return ResponseEntity.badRequest().body(mensaje);
        }
        
        // verificar si el local ya existe por codigo
        Local localExistente = localRepo.findByCodigoLocal(local.getCodigoLocal());

        if (localExistente != null) {
            String mensaje = "El local con codigo " + local.getCodigoLocal() + " ya existe";
            return ResponseEntity.badRequest().body(mensaje);
        }

        Local localGuardado = localRepo.save(local);
        return ResponseEntity.ok(localGuardado);

    }

    @PutMapping("/locales/{id}")
    public Local updateLocal(@PathVariable int id, @RequestBody Local local) {
        Local localToUpdate = localRepo.findById(id).get();
        localToUpdate.setCodigoLocal(local.getCodigoLocal());
        localToUpdate.setDireccion(local.getDireccion());
        return localRepo.save(localToUpdate);
    }

    @DeleteMapping("/locales/{id}")
    public String deleteLocal(@PathVariable int id) {
        localRepo.deleteById(id);
        return "Local eliminado con id: " + id;
    }
    
}
