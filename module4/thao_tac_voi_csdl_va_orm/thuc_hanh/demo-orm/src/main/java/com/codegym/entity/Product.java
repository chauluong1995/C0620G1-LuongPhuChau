package com.codegym.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "product")
public class Product {
    @Id
    @Column(name = "product_id")
    private String id;
    @Column(name = "product_name")
    private String name;
    private String color;
    private String manufacturer;

    public Product() {
    }

    public Product(String id, String name, String color, String manufacturer) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.manufacturer = manufacturer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}