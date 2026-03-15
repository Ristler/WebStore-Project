package fi.metropolia.danielju.webstore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "customeraddresses")
public class CustomerAddresses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(optional = true)
    @JoinColumn(name = "customer_id", unique = true)
    private Customer customer;

    @Column(name = "street_address")
    private String streetAddress;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    // No-argument constructor
    public CustomerAddresses() {
    }

    // All-arguments constructor (including id)
    public CustomerAddresses(int id, Customer customer, String streetAddress, String postalCode, String city, String country) {
        this.id = id;
        this.customer = customer;
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    // Constructor without id (for creating new instances before persistence)
    public CustomerAddresses(Customer customer, String streetAddress, String postalCode, String city, String country) {
        this.customer = customer;
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "CustomerAddresses{" +
                "id=" + id +
                ", customerId=" + (customer != null ? customer.getId() : null) +
                ", streetAddress='" + streetAddress + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

}
