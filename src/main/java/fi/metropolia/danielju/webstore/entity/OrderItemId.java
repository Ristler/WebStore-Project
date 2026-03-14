package fi.metropolia.danielju.webstore.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderItemId implements Serializable {

    private int orderId;
    private int productId;

    public OrderItemId() {}

    public OrderItemId(int orderId, int productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    // Getters and setters
    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    // equals and hashCode are required for composite keys
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItemId)) return false;
        OrderItemId that = (OrderItemId) o;
        return orderId == that.orderId && productId == that.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, productId);
    }
}