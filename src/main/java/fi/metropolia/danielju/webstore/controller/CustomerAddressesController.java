package fi.metropolia.danielju.webstore.controller;

import fi.metropolia.danielju.webstore.entity.CustomerAddresses;
import fi.metropolia.danielju.webstore.service.CustomerAddressesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customeraddresses")
public class CustomerAddressesController {
    private final CustomerAddressesService addressesService;

    public CustomerAddressesController(CustomerAddressesService addressesService) {
        this.addressesService = addressesService;
    }

    @PostMapping
    public ResponseEntity<CustomerAddresses> createAddress(@RequestParam int customerId, @RequestBody CustomerAddresses address) {
        CustomerAddresses created = addressesService.createAddress(customerId, address);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerAddresses> updateAddress(@PathVariable int id, @RequestBody CustomerAddresses address) {
        CustomerAddresses updated = addressesService.updateAddress(id, address);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable int id) {
        addressesService.deleteAddress(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerAddresses> getAddress(@PathVariable int id) {
        Optional<CustomerAddresses> address = addressesService.getAddress(id);
        return address.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/by-customer/{customerId}")
    public ResponseEntity<CustomerAddresses> getAddressByCustomerId(@PathVariable int customerId) {
        Optional<CustomerAddresses> address = addressesService.getAddressByCustomerId(customerId);
        return address.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/by-customer/{customerId}")
    public ResponseEntity<CustomerAddresses> updateAddressByCustomerId(@PathVariable int customerId, @RequestBody CustomerAddresses address) {
        CustomerAddresses updated = addressesService.updateAddressByCustomerId(customerId, address);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/by-customer/{customerId}")
    public ResponseEntity<Void> deleteAddressByCustomerId(@PathVariable int customerId) {
        addressesService.deleteAddressByCustomerId(customerId);
        return ResponseEntity.noContent().build();
    }
}
