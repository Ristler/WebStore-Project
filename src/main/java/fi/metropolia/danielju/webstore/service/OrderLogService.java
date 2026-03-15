package fi.metropolia.danielju.webstore.service;

import fi.metropolia.danielju.webstore.entity.OrderLog;
import fi.metropolia.danielju.webstore.repositories.OrderLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderLogService {

    private final OrderLogRepository orderLogRepository;

    public OrderLogService(OrderLogRepository orderLogRepository) {
        this.orderLogRepository = orderLogRepository;
    }

    public List<OrderLog> getAllLogs() {
        return orderLogRepository.findAll();
    }

    public Optional<OrderLog> getLogById(Integer id) {
        return orderLogRepository.findById(id);
    }

    public List<OrderLog> getLogsByOrderId(Integer orderId) {
        return orderLogRepository.findByOrderId(orderId);
    }

    public List<OrderLog> getLogsByCustomerId(Integer customerId) {
        return orderLogRepository.findByCustomerId(customerId);
    }
}

