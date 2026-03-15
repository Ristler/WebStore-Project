package fi.metropolia.danielju.webstore.repositories;

import fi.metropolia.danielju.webstore.entity.Order;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Order o WHERE o.status = 'CANCELLED'")
    int deleteCancelledOrders();

    // Delete orders whose shipping_address_id refers to CustomerAddresses entries
    // that either have no Customer reference (ca.customer IS NULL) or reference a
    // Customer id that does not exist in the Customer table.
    @Modifying
    @Transactional
    @Query("DELETE FROM Order o WHERE o.shippingAddressId IN ("
            + "SELECT ca.id FROM CustomerAddresses ca WHERE ca.customer IS NULL"
            + " OR ca.customer.id NOT IN (SELECT c.id FROM Customer c))")
    int deleteOrdersWithOrphanedCustomerAddresses();

    // Delete orders that reference a specific shipping address id
    @Modifying
    @Transactional
    @Query("DELETE FROM Order o WHERE o.shippingAddressId = ?1")
    int deleteByShippingAddressId(int shippingAddressId);

    // Find orders by shipping address id
    List<Order> findByShippingAddressId(int shippingAddressId);
}
