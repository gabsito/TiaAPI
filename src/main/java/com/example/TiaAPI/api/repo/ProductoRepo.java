package com.example.TiaAPI.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.TiaAPI.api.model.Producto;

public interface ProductoRepo extends JpaRepository<Producto, Integer> {

}
