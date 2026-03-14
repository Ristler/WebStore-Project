package fi.metropolia.danielju.webstore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "outofstock")
public class OutOfStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;  // Primary key

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;  // Reference to the Product entity

    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "supplier_id")
    private int supplierId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "price_each")
    private float priceEach;

    public OutOfStock() {
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    public int getCategoryId() { return categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }

    public int getSupplierId() { return supplierId; }
    public void setSupplierId(int supplierId) { this.supplierId = supplierId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public float getPriceEach() { return priceEach; }
    public void setPriceEach(float priceEach) { this.priceEach = priceEach; }


    @Override
    public String toString() {
        return "OutOfStock{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", supplierId=" + supplierId +
                ", productName='" + productName + '\'' +
                ", priceEach=" + priceEach +
                '}';
    }
}