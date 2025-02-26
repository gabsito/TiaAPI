package com.example.TiaAPI.api.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TiaAPI.api.model.Stock;

public interface StockRepo extends JpaRepository<Stock, Integer> {

    List<Stock> findByLocal_idLocal(int idLocal);

    Optional<Stock> findByLocal_idLocalAndProducto_idProducto(int localId, int productoId);

}
