package com.example.TiaAPI.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.TiaAPI.api.model.Local;
import com.example.TiaAPI.service.LocalService;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class LocalController {

    private LocalService localService;

    public LocalController(LocalService localService){
        this.localService = localService;
    }

    @GetMapping("/local")
    public Local getLocal(@RequestParam Integer id){
        Optional<Local> local = localService.getLocal(id);
        if(local.isPresent()) {
            return (Local) local.get();
        }
        return null;
    }
}
