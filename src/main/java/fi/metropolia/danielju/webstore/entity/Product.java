package fi.metropolia.danielju.webstore.entity;
import jakarta.persistence.*;


@Entity
@Table(name = "products")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "stock_quantity")
    private int stock_quantity;

    @Column(name = "category_id")
    private int category_id;

    @Column(name = "supplier_id")
    private int supplier_id;


    public Product() {

    }

    public Product(int id, String name, String description, double price, int stock_quantity, int category_id, int supplier_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock_quantity = stock_quantity;
        this.category_id = category_id;
        this.supplier_id = supplier_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock_quantity(int stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public void setCategory_id(int setCategory_id) {
        this.category_id = setCategory_id;
    }

    public void setSupplier_id(int setSupplier_id) {
        this.supplier_id = setSupplier_id;
    }


    public int getid() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getStock_quantity() {
        return stock_quantity;
    }

    public int getCategory_id() {
        return category_id;
    }

    public int getSupplier_id() {
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
