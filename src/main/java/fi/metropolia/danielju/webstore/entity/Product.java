package fi.metropolia.danielju.webstore.entity;
import jakarta.persistence.*;


@Entity
@Table(name = "products")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "stock_quantity")
    private Integer stock_quantity;

    @Column(name = "category_id")
    private Integer category_id;

    @Column(name = "supplier_id")
    private Integer supplier_id;


    public Product() {

    }

    public Product(Integer id, String name, String description, Double price, Integer stock_quantity, Integer category_id, Integer supplier_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock_quantity = stock_quantity;
        this.category_id = category_id;
        this.supplier_id = supplier_id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setStock_quantity(Integer stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public void setCategory_id(Integer setCategory_id) {
        this.category_id = setCategory_id;
    }

    public void setSupplier_id(Integer setSupplier_id) {
        this.supplier_id = setSupplier_id;
    }


    public Integer getid() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getStock_quantity() {
        return stock_quantity;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public Integer getSupplier_id() {
        return supplier_id;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", name='" + name + ' ' +
                ", description='" + description + ' ' +
                ", price=" + price +
                ", stockquantity=" + stock_quantity +
                ", categoryid=" + category_id +
                ", suppilierid=" + supplier_id +
                '}';
    }
}
