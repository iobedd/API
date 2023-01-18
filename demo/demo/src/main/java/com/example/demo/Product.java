package com.example.demo;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "intruments")
class Product {
    private @Id @GeneratedValue Long id;
    private String name;
    private String details;

    private int price;

    public int getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(int licencePlate) {
        this.licencePlate = licencePlate;
    }

    private int licencePlate;


    Product() {}

    Product(String name, String details, int price, int licencePlate) {

        this.name = name;
        this.details = details;
        this.price = price;
        this.licencePlate= licencePlate;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDetails() {
        return this.details;
    }

    public int getPrice() {
        return this.price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setLicense(int licencePlate) {
        this.licencePlate = licencePlate;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Product))
            return false;
        Product product = (Product) o;
        return Objects.equals(this.id, product.id) && Objects.equals(this.name, product.name)
                && Objects.equals(this.details, product.details) && Objects.equals(this.price, product.price) && Objects.equals(this.licencePlate, product.licencePlate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.details, this.price, this.licencePlate);
    }


}
