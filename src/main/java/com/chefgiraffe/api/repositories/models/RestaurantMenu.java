package com.chefgiraffe.api.repositories.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table
public class RestaurantMenu {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private UUID restaurantId;
    private String name;

    public RestaurantMenu() {
    }

    public RestaurantMenu(UUID restaurantId, String name) {
        this.restaurantId = restaurantId;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public UUID getRestaurantId() {
        return restaurantId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "RestaurantMenu{" +
                "id=" + id +
                ", restaurantId=" + restaurantId +
                ", name='" + name + '\'' +
                '}';
    }
}