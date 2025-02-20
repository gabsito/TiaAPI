package com.example.TiaAPI.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.TiaAPI.api.model.Local;

@Service
public class LocalService {

    private List<Local> locales;

    public LocalService() {
        locales = new ArrayList<>();

        Local local = new Local("codigo", "doreccion");

        locales.add(local);
    }

    public Optional<Local> getLocal(Integer id) {
        Optional<Local> optional = Optional.empty();
        for (Local local: locales) {
            if (id == local.getIdLocal()) {
                optional = Optional.of(local);
                return optional;
            }
        }
        return optional;
    }

}
