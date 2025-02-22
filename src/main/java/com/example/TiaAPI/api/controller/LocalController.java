package com.example.TiaAPI.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.TiaAPI.api.model.Local;
import com.example.TiaAPI.api.repo.LocalRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Local> getLocales() {
        return localRepo.findAll();
    }

    @GetMapping("/local/{id}")
    public Local getLocal(@PathVariable int id) {
        return localRepo.findById(id).get();
    }

    @PostMapping("/local")
    public Local saveLocal(@RequestBody Local local) {
        return localRepo.save(local);
    }

    @PutMapping("/local/{id}")
    public Local updateLocal(@PathVariable int id, @RequestBody Local local) {
        Local localToUpdate = localRepo.findById(id).get();
        localToUpdate.setCodigoLocal(local.getCodigoLocal());
        localToUpdate.setDireccion(local.getDireccion());
        return localRepo.save(localToUpdate);
    }

    @DeleteMapping("/local/{id}")
    public String deleteLocal(@PathVariable int id) {
        localRepo.deleteById(id);
        return "Local eliminado con id: " + id;
    }
    
}
