package fi.metropolia.danielju.webstore.entity;

import fi.metropolia.danielju.webstore.entity.base.ContactInfo;
import jakarta.persistence.*;

@Entity
public class Supplier extends ContactInfo {


    @Column(name = "name")
    private String name;

    @Column(name = "contact_name")
    private String contact_name;



    public Supplier() {}


    public Supplier(String name, String contact_name, String phone, String email) {
        super(phone, email);
        this.name = name;
        this.contact_name = contact_name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    // toString() method
    @Override
    public String toString() {
        return "Supplier{" +
                ", name='" + name + '\'' +
                ", contact_name='" + contact_name + '\'' +
                '}';
    }
}