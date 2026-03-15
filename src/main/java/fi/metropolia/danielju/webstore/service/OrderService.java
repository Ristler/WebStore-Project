package fi.metropolia.danielju.webstore.service;

import fi.metropolia.danielju.webstore.entity.Order;
import fi.metropolia.danielju.webstore.repositories.OrderItemsRepository;
import fi.metropolia.danielju.webstore.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemsRepository orderItemRepository;

    public OrderService(OrderRepository orderRepository, OrderItemsRepository orderItemsRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemsRepository;
    }

    @Transactional
    public String deleteCancelledOrdersAndItems() {
        int deletedItems = orderItemRepository.deleteOrderItemsForCancelledOrders();
        int deletedOrders = orderRepository.deleteCancelledOrders();

        return deletedOrders + " cancelled orders deleted, " + deletedItems + " order items deleted";
    }

    @Transactional
    public Optional<Order> updateOrderStatus(int orderId, String status) {
        Optional<Order> orderOpt = orderRepository.findById(orderId);
        if (orderOpt.isPresent()) {
            Order order = orderOpt.get();
            order.setStatus(status);
            orderRepository.save(order);
            return Optional.of(order);
        }
        return Optional.empty();
    }

    @Transactional
    public Optional<Order> updateOrder(Integer id, Order updatedOrder) {
        return orderRepository.findById(id).map(order -> {
            order.setCustomerId(updatedOrder.getCustomerId());
            order.setOrderDate(updatedOrder.getOrderDate());
            order.setDeliveryDate(updatedOrder.getDeliveryDate());
            order.setShippingAddressId(updatedOrder.getShippingAddressId());
            order.setStatus(updatedOrder.getStatus());
            return orderRepository.save(order);
        });
    }

    @Transactional
    public boolean deleteOrder(Integer id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Order> getOrdersByCustomerId(Integer customerId) {
        return orderRepository.findByCustomerId(customerId);
    }
}