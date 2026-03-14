package fi.metropolia.danielju.webstore.controller;

import fi.metropolia.danielju.webstore.entity.Customer;
import fi.metropolia.danielju.webstore.entity.Supplier;
import fi.metropolia.danielju.webstore.repositories.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//DELETE CUSTOMER

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerRepository repository;


    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/")
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) {
        return repository.findById(id)
                .map(customer -> ResponseEntity.ok(customer))
                .orElse(ResponseEntity.notFound().build());
    }
}
