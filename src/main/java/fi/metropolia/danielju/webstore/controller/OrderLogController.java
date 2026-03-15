package fi.metropolia.danielju.webstore.controller;

import fi.metropolia.danielju.webstore.entity.OrderLog;
import fi.metropolia.danielju.webstore.service.OrderLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderlogs")
public class OrderLogController {

    private final OrderLogService orderLogService;

    public OrderLogController(OrderLogService orderLogService) {
        this.orderLogService = orderLogService;
    }

    @GetMapping
    public List<OrderLog> getAllLogs() {
        return orderLogService.getAllLogs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderLog> getLogById(@PathVariable Integer id) {
        return orderLogService.getLogById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/by-order/{orderId}")
    public List<OrderLog> getLogsByOrderId(@PathVariable Integer orderId) {
        return orderLogService.getLogsByOrderId(orderId);
    }

    @GetMapping("/by-customer/{customerId}")
    public List<OrderLog> getLogsByCustomerId(@PathVariable Integer customerId) {
        return orderLogService.getLogsByCustomerId(customerId);
    }
}

