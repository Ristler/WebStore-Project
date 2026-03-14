package fi.metropolia.danielju.webstore.entity.base;

import jakarta.persistence.*;

@Entity
@Table(name = "contact_info")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class ContactInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    public ContactInfo() {}

    public ContactInfo(String phone, String email) {
        this.phone = phone;
        this.email = email;
    }

    // Getters & setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "ContactInfo{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}