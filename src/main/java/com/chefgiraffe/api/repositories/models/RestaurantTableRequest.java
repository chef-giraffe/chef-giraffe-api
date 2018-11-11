package com.chefgiraffe.api.repositories.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table
public class RestaurantTableRequest {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "restaurant_table_id")
    private UUID restaurantTableId;

    private String description;
    private Timestamp createdTime;

    public RestaurantTableRequest(UUID restaurantTableId, String description) {
        this.restaurantTableId = restaurantTableId;
        this.description = description;
        this.createdTime = Timestamp.valueOf(LocalDateTime.now());
    }

    public UUID getId() {
        return id;
    }

    public UUID getRestaurantTableId() {
        return restaurantTableId;
    }

    public String getDescription() {
        return description;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    @Override
    public String toString() {
        return "RestaurantTableRequest{" +
                "id=" + id +
                ", restaurantTableId=" + restaurantTableId +
                ", description='" + description + '\'' +
                ", createdTime=" + createdTime +
                '}';
    }
}
