package com.chefgiraffe.api.repositories.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_table_id")
    private List<RestaurantOrder> restaurantOrders;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_table_id")
    private List<RestaurantTableRequest> restaurantTableRequests;

    protected RestaurantTable() {
    }

    public RestaurantTable(UUID restaurantId,
                           String friendlyName,
                           Integer availableSeats) {
        this.restaurantId = restaurantId;
        this.friendlyName = friendlyName;
        this.availableSeats = availableSeats;
        this.restaurantOrders = new ArrayList<>();
        this.restaurantTableRequests = new ArrayList<>();
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

    public List<RestaurantOrder> getRestaurantOrders() {
        return restaurantOrders;
    }

    public List<RestaurantTableRequest> getRestaurantTableRequests() {
        return restaurantTableRequests;
    }

    public boolean addRequest(RestaurantTableRequest restaurantTableRequest) {
        return this.restaurantTableRequests.add(restaurantTableRequest);
    }

    @Override
    public String toString() {
        return "RestaurantTable{" +
                "id=" + id +
                ", restaurantId=" + restaurantId +
                ", friendlyName='" + friendlyName + '\'' +
                ", availableSeats=" + availableSeats +
                ", restaurantOrders=" + restaurantOrders +
                ", restaurantTableRequests=" + restaurantTableRequests +
                '}';
    }
}
