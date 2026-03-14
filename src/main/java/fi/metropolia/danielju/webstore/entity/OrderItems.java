package fi.metropolia.danielju.webstore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orderitems")
public class OrderItems {

    @EmbeddedId
    private OrderItemId id;  // composite primary key

    @ManyToOne
    @MapsId("orderId") // maps orderId from the embedded key
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "unit_price", nullable = false)
    private float unitPrice;

    public OrderItems() {}

    // Convenience constructor
    public OrderItems(Order order, int productId, int quantity, float unitPrice) {
        this.id = new OrderItemId(order.getId(), productId);
        this.order = order;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    // Getters and setters
    public OrderItemId getId() { return id; }
    public void setId(OrderItemId id) { this.id = id; }

    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public float getUnitPrice() { return unitPrice; }
    public void setUnitPrice(float unitPrice) { this.unitPrice = unitPrice; }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderId=" + id.getOrderId() +
                ", productId=" + id.getProductId() +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                '}';
    }
}