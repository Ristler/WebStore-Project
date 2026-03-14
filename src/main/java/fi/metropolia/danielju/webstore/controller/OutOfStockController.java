package fi.metropolia.danielju.webstore.controller;

import fi.metropolia.danielju.webstore.service.OutOfStockService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OutOfStockController {

    private final OutOfStockService service;

    public OutOfStockController(OutOfStockService service) {
        this.service = service;
    }

    @DeleteMapping("/outofstock/cleanup")
    public String cleanupOutOfStock() {
        service.removeAvailableProducts();
        return "OutOfStock table cleaned! Products with stock are removed.";
    }
}