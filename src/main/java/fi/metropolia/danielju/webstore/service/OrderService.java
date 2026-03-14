package fi.metropolia.danielju.webstore.service;

import fi.metropolia.danielju.webstore.repositories.OrderItemsRepository;
import fi.metropolia.danielju.webstore.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

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
}