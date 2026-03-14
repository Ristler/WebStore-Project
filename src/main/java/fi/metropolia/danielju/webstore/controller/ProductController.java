package fi.metropolia.danielju.webstore.controller;

import fi.metropolia.danielju.webstore.entity.Product;
import fi.metropolia.danielju.webstore.repositories.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



//ADD PRODUCT
//DELETE PRODUCT

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public List<Product> getAllOrders() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        return repository.findById(id)
                .map(product -> ResponseEntity.ok(product))
                .orElse(ResponseEntity.notFound().build());
    }
}
