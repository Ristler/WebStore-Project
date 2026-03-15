package fi.metropolia.danielju.webstore.controller;

import fi.metropolia.danielju.webstore.entity.OutOfStock;
import fi.metropolia.danielju.webstore.service.OutOfStockService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OutOfStockController {

    private final OutOfStockService service;

    public OutOfStockController(OutOfStockService service) {
        this.service = service;
    }

    @GetMapping("/outofstock")
    public List<OutOfStock> getAllOutOfStock() {
        return service.getAllOutOfStock();
    }

    @DeleteMapping("/outofstock/cleanup")
    public String cleanupOutOfStock() {
        service.removeAvailableProducts();
        return "OutOfStock table cleaned! Products with stock are removed.";
    }
}