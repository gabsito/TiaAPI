package com.example.TiaAPI.api.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TiaAPI.api.model.Venta;

public interface VentaRepo extends JpaRepository <Venta, Integer> {

    List<Venta> findByLocal_idLocal(int idLocal);

}
