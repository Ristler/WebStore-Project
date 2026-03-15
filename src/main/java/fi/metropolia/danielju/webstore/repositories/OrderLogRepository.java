package fi.metropolia.danielju.webstore.repositories;

import fi.metropolia.danielju.webstore.entity.OrderLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderLogRepository extends JpaRepository<OrderLog, Integer> {
    List<OrderLog> findByOrderId(Integer orderId);
    List<OrderLog> findByCustomerId(Integer customerId);
}

