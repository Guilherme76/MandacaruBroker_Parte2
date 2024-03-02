package com.mandacarubroker.controller;

import com.mandacarubroker.domain.stock.*;
import com.mandacarubroker.service.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/stocks")
public class StockController {

    private final StockService stockService;

    public StockController(final StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public List<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }

    @GetMapping("/{id}")
    public Stock getStockById(@PathVariable final String id) {
        return stockService.getStockById(id).orElse(null);
    }

    @PostMapping
    public ResponseEntity<Stock> createStock(@RequestBody final RequestStockDTO data) {
        final Stock createdStock = stockService.createStock(data);
        return ResponseEntity.ok(createdStock);
    }

    @PutMapping("/{id}")
    public Stock updateStock(@PathVariable final String id,
        @RequestBody final Stock updatedStock) {
        return stockService.updateStock(id, updatedStock).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteStock(@PathVariable final String id) {
        stockService.deleteStock(id);
    }

}

