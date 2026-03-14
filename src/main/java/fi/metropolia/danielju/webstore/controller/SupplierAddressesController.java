package fi.metropolia.danielju.webstore.controller;

import fi.metropolia.danielju.webstore.entity.Supplier;
import fi.metropolia.danielju.webstore.entity.SupplierAddresses;
import fi.metropolia.danielju.webstore.repositories.SupplierAddressesRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/supplieraddresses")
public class SupplierAddressesController {
    private final SupplierAddressesRepository repository;

    public SupplierAddressesController(SupplierAddressesRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/")
    public List<SupplierAddresses> getAllSuppliersAddresses() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierAddresses> getSupplierAddressById(@PathVariable Integer id) {
        return repository.findById(id)
                .map(supplierAddress -> ResponseEntity.ok(supplierAddress))
                .orElse(ResponseEntity.notFound().build());
    }
}

