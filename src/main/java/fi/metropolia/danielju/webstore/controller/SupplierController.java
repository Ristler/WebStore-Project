package fi.metropolia.danielju.webstore.controller;


import fi.metropolia.danielju.webstore.entity.Product;
import fi.metropolia.danielju.webstore.entity.Supplier;
import fi.metropolia.danielju.webstore.repositories.SupplierRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    private final SupplierRepository repository;

    public SupplierController(SupplierRepository repository) {
        this.repository = repository;

    }



@GetMapping("/")
public List<Supplier> getAllSuppliers() {
    return repository.findAll();
}

@GetMapping("/{id}")
public ResponseEntity<Supplier> getSupplierById(@PathVariable Integer id) {
    return repository.findById(id)
            .map(product -> ResponseEntity.ok(product))
            .orElse(ResponseEntity.notFound().build());
}
}
