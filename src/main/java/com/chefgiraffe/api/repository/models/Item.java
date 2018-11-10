package com.chefgiraffe.api.repository.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Item {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    private String imageUri;

    public Item() {
    }

    public Item(String name, String description, BigDecimal price, String imageUri) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUri = imageUri;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }


    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", imageUri='" + imageUri + '\'' +
                '}';
    }
}
