package fi.metropolia.danielju.webstore.controller;

import fi.metropolia.danielju.webstore.dto.CustomerWithAddressDTO;
import fi.metropolia.danielju.webstore.entity.Customer;
import fi.metropolia.danielju.webstore.repositories.CustomerRepository;
import fi.metropolia.danielju.webstore.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerRepository repository;
    private final CustomerService customerService;

    public CustomerController(CustomerRepository repository, CustomerService customerService) {
        this.repository = repository;
        this.customerService = customerService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer updatedCustomer) {
        Customer customer = customerService.updateCustomer(id, updatedCustomer);
        return ResponseEntity.ok(customer);
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomerWithAddress(@RequestBody CustomerWithAddressDTO dto) {
        Customer created = customerService.createCustomerWithAddress(dto);
        return ResponseEntity.ok(created);
    }
}
