package fi.metropolia.danielju.webstore.entity;

import fi.metropolia.danielju.webstore.entity.base.ContactInfo;
import jakarta.persistence.*;

@Entity
public class Customer extends ContactInfo {

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;


    public Customer() {}

    public Customer(String first_name, String last_name, String phone, String email) {
        super(phone, email); // set phone and email in base class
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    // toString() method
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + getId() +
                ", phone='" + getPhone() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }
}
