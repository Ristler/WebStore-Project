package fi.metropolia.danielju.webstore.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Column(name = "delivery_date")
    private LocalDateTime deliveryDate;

    @Column(name = "shipping_address_id")
    private int shippingAddressId;

    @Column(name = "status")
    private String status;

    // No-args constructor
    public Order() {}

    // All-args constructor (except id, since it's generated)
    public Order(int customerId, LocalDateTime orderDate, LocalDateTime deliveryDate, int shippingAddressId, String status) {
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.shippingAddressId = shippingAddressId;
        this.status = status;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public int getShippingAddressId() {
        return shippingAddressId;
    }

    public void setShippingAddressId(int shippingAddressId) {
        this.shippingAddressId = shippingAddressId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // toString() for debugging
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", shippingAddressId=" + shippingAddressId +
                ", status='" + status + '\'' +
                '}';
    }
}