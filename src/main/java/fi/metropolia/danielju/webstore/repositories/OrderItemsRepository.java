package fi.metropolia.danielju.webstore.repositories;
import fi.metropolia.danielju.webstore.entity.OrderItemId;
import fi.metropolia.danielju.webstore.entity.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import jakarta.transaction.Transactional;

public interface OrderItemsRepository extends JpaRepository<OrderItems, OrderItemId> {

    @Modifying
    @Transactional
    @Query("DELETE FROM OrderItems oi WHERE oi.order.id IN (SELECT o.id FROM Order o WHERE o.status = 'CANCELLED')")
    int deleteOrderItemsForCancelledOrders();
}