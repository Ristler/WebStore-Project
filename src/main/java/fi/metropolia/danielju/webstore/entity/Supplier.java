package fi.metropolia.danielju.webstore.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "contact_name")
    private String contact_name;

    // Bidirectional link to SupplierAddresses so cascade remove will delete address when supplier is deleted
    @JsonManagedReference
    @OneToOne(mappedBy = "supplier", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private SupplierAddresses address;

    public Supplier() {}

    public Supplier(String name, String contact_name, String phone, String email) {
        this.name = name;
        this.contact_name = contact_name;
        this.phone = phone;
        this.email = email;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getContact_name() { return contact_name; }
    public void setContact_name(String contact_name) { this.contact_name = contact_name; }

    public SupplierAddresses getAddress() { return address; }
    public void setAddress(SupplierAddresses address) { this.address = address; }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", contact_name='" + contact_name + '\'' +
                '}';
    }
}