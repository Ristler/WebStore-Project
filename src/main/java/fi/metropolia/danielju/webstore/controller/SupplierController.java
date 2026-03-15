package fi.metropolia.danielju.webstore.controller;


import fi.metropolia.danielju.webstore.dto.SupplierWithAddressDTO;
import fi.metropolia.danielju.webstore.entity.Supplier;
import fi.metropolia.danielju.webstore.repositories.SupplierAddressesRepository;
import fi.metropolia.danielju.webstore.repositories.SupplierRepository;
import fi.metropolia.danielju.webstore.service.SupplierService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    private final SupplierRepository repository;
    private final SupplierAddressesRepository supplierAddressesRepository;
    private final SupplierService supplierService;

    public SupplierController(SupplierRepository repository,
                              SupplierAddressesRepository supplierAddressesRepository,
                              SupplierService supplierService) {
        this.repository = repository;
        this.supplierAddressesRepository = supplierAddressesRepository;
        this.supplierService = supplierService;
    }



    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> deleteSupplier(@PathVariable Integer id) {
        return repository.findById(id)
                .map(supplier -> {
                    // delete supplier address first to avoid FK constraint from supplieraddresses -> contact_info
                    supplierAddressesRepository.findBySupplier(supplier).ifPresent(addr -> {
                        supplierAddressesRepository.deleteById(addr.getId());
                        // ensure the delete is flushed to DB before deleting the supplier
                        supplierAddressesRepository.flush();
                    });

                    repository.deleteById(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Supplier> createSupplierWithAddress(@RequestBody SupplierWithAddressDTO dto) {
        Supplier created = supplierService.createSupplierWithAddress(dto);
        return ResponseEntity.ok(created);
    }
}
