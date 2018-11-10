package com.chefgiraffe.api.repositories.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table
public class RestaurantTable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private UUID restaurantId;
    private String friendlyName;
    private Integer availableSeats;

    protected RestaurantTable() {
    }

    public RestaurantTable(UUID restaurantId, String friendlyName, Integer availableSeats) {
        this.restaurantId = restaurantId;
        this.friendlyName = friendlyName;
        this.availableSeats = availableSeats;
    }

    public UUID getId() {
        return id;
    }

    public UUID getRestaurantId() {
        return restaurantId;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    @Override
    public String toString() {
        return "RestaurantTable{" +
                "id=" + id +
                ", restaurantId=" + restaurantId +
                ", friendlyName='" + friendlyName + '\'' +
                ", availableSeats=" + availableSeats +
                '}';
    }
}
