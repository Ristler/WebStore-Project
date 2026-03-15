package fi.metropolia.danielju.webstore.controller;

import fi.metropolia.danielju.webstore.entity.Supplier;
import fi.metropolia.danielju.webstore.entity.SupplierAddresses;
import fi.metropolia.danielju.webstore.repositories.SupplierAddressesRepository;
import fi.metropolia.danielju.webstore.service.SupplierAddressesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/supplieraddresses")
public class SupplierAddressesController {
    private final SupplierAddressesRepository repository;
    private final SupplierAddressesService addressesService;

    public SupplierAddressesController(SupplierAddressesRepository repository, SupplierAddressesService addressesService) {
        this.repository = repository;
        this.addressesService = addressesService;
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

    @PostMapping
    public ResponseEntity<SupplierAddresses> createAddress(@RequestParam int supplierId, @RequestBody SupplierAddresses address) {
        SupplierAddresses created = addressesService.createAddress(supplierId, address);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/by-supplier/{supplierId}")
    public ResponseEntity<SupplierAddresses> getAddressBySupplierId(@PathVariable int supplierId) {
        Optional<SupplierAddresses> address = addressesService.getAddressBySupplierId(supplierId);
        return address.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/by-supplier/{supplierId}")
    public ResponseEntity<SupplierAddresses> updateAddressBySupplierId(@PathVariable int supplierId, @RequestBody SupplierAddresses address) {
        SupplierAddresses updated = addressesService.updateAddressBySupplierId(supplierId, address);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/by-supplier/{supplierId}")
    public ResponseEntity<Void> deleteAddressBySupplierId(@PathVariable int supplierId) {
        addressesService.deleteAddressBySupplierId(supplierId);
        return ResponseEntity.noContent().build();
    }
}
