package com.chefgiraffe.api.repositories.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table
public class RestaurantRequest {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "restaurant_table_id")
    private UUID restaurantTableId;
    private String description;

    public RestaurantRequest(UUID restaurantTableId, String description) {
        this.restaurantTableId = restaurantTableId;
        this.description = description;
    }

    public UUID getRestaurantTableId() {
        return restaurantTableId;
    }
}
