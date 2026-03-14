package fi.metropolia.danielju.webstore.controller;

import fi.metropolia.danielju.webstore.entity.Order;
import fi.metropolia.danielju.webstore.repositories.OrderRepository;
import fi.metropolia.danielju.webstore.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderRepository repository;
    private final OrderService orderService;

    public OrderController(OrderRepository repository, OrderService orderService) {
        this.repository = repository;
        this.orderService = orderService;
    }

    @GetMapping("/")
    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Integer id) {
        return repository.findById(id)
                .map(order -> ResponseEntity.ok(order))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/post")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order savedOrder = repository.save(order);
        return ResponseEntity.ok(savedOrder);
    }

    @DeleteMapping("/clearcancelled")
    public String deleteCancelledOrders() {
        return orderService.deleteCancelledOrdersAndItems();
    }
}