package com.chefgiraffe.api.repositories.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table
public class RestaurantMenuItem {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "restaurant_menu_id")
    private UUID restaurantMenuId;
    private String name;
    private String description;
    private BigDecimal price;
    private String imageUri;

    protected RestaurantMenuItem() {
    }

    public RestaurantMenuItem(UUID restaurantMenuId, String name, String description, BigDecimal price, String imageUri) {
        this.restaurantMenuId = restaurantMenuId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUri = imageUri;
    }

    public UUID getId() {
        return id;
    }

    public UUID getRestaurantMenuId() {
        return restaurantMenuId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getImageUri() {
        return imageUri;
    }

    @Override
    public String toString() {
        return "RestaurantMenuItem{" +
                "id=" + id +
                ", restaurantMenuId='" + restaurantMenuId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", imageUri='" + imageUri + '\'' +
                '}';
    }
}
