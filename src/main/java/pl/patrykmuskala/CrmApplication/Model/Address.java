package pl.patrykmuskala.CrmApplication.Model;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String postal_code;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private int street_number;

    @Column(nullable = true)
    private int house_number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postalCode) {
        this.postal_code = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getStreet_number() {
        return street_number;
    }

    public void setStreet_number(int streetNumber) {
        this.street_number = streetNumber;
    }

    public int getHouse_number() {
        return house_number;
    }

    public void setHouse_number(int houseNumber) {
        this.house_number = houseNumber;
    }

    public Address() {
    }

    public Address(String city, String postal_code, String street, int street_number, int house_number) {
        this.city = city;
        this.postal_code = postal_code;
        this.street = street;
        this.street_number = street_number;
        this.house_number = house_number;
    }
    public Address(String city, String postal_code, String street, int street_number) {
        this.city = city;
        this.postal_code = postal_code;
        this.street = street;
        this.street_number = street_number;
    }
}
