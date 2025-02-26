package com.example.TiaAPI.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.TiaAPI.api.dto.StockRequest;
import com.example.TiaAPI.api.model.Local;
import com.example.TiaAPI.api.model.Producto;
import com.example.TiaAPI.api.model.Stock;
import com.example.TiaAPI.api.repo.LocalRepo;
import com.example.TiaAPI.api.repo.ProductoRepo;
import com.example.TiaAPI.api.repo.StockRepo;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class StockController {

    @Autowired
    private StockRepo stockRepo;

    @Autowired
    private LocalRepo localRepo;

    @Autowired
    private ProductoRepo productoRepo;

    @GetMapping("/stocks")
    public ResponseEntity<List<Stock>> getStocks() {
        List<Stock> stocks = stockRepo.findAll();

        if (stocks.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(stocks);
    }

    @GetMapping("/stock/{id}")
    public ResponseEntity<?> getStock(@PathVariable Integer id) {
        Stock stock = stockRepo.findById(id).orElse(null);

        if (stock == null) {
            String message = "Stock con id: " + id + " no encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }

        return ResponseEntity.ok(stock);
    }

    @GetMapping("/stocks/local")
    public ResponseEntity<List<Stock>> getStockByStore(@RequestParam int idLocal) { 
        List<Stock> stock = stockRepo.findByLocal_idLocal(idLocal);

        if (stock.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(stock);
    }
    

    @PostMapping("/stock")
    public ResponseEntity<?> createStock(@RequestBody StockRequest stockRequest) {
        Optional<Local> local = localRepo.findById(stockRequest.getLocalId());
        Optional<Producto> producto = productoRepo.findById(stockRequest.getProductoId());
        
        if (!local.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Local con id: " + stockRequest.getLocalId() + " no encontrado");
        }

        if (!producto.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Producto con id: " + stockRequest.getProductoId() + " no encontrado");
        }

        Stock stock = new Stock(producto.get(), local.get(), stockRequest.getCantidad());
        stockRepo.save(stock);

        return ResponseEntity.ok(stock);
    }

    @PostMapping("/stock/update")
    public ResponseEntity<?> updateStock(@RequestBody StockRequest stockRequest) {
        Optional<Local> local = localRepo.findById(stockRequest.getLocalId());
        Optional<Producto> producto = productoRepo.findById(stockRequest.getProductoId());
        
        if (!local.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Local con id: " + stockRequest.getLocalId() + " no encontrado");
        }

        if (!producto.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Producto con id: " + stockRequest.getProductoId() + " no encontrado");
        }

        Stock stock = stockRepo.findByLocal_idLocalAndProducto_idProducto(stockRequest.getLocalId(), stockRequest.getProductoId()).orElse(null);
        stock.setCantidad(stock.getCantidad() + stockRequest.getCantidad());
        stockRepo.save(stock);

        return ResponseEntity.ok(stock);
    }


}
