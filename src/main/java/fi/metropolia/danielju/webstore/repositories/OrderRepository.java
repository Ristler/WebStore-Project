package fi.metropolia.danielju.webstore.repositories;

import fi.metropolia.danielju.webstore.entity.Order;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Order o WHERE o.status = 'CANCELLED'")
    int deleteCancelledOrders();
}
