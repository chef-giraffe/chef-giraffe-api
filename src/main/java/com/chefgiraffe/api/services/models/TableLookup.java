package com.chefgiraffe.api.services.models;

import java.util.UUID;

public class TableLookup {

    private UUID restaurantTableId;
    private OrderStatus orderStatus;

    public TableLookup(UUID restaurantTableId) {
        this.restaurantTableId = restaurantTableId;
    }

    public TableLookup(UUID restaurantTableId, OrderStatus orderStatus) {
        this.restaurantTableId = restaurantTableId;
        this.orderStatus = orderStatus;
    }

    public UUID getRestaurantTableId() {
        return restaurantTableId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    @Override
    public String toString() {
        return "TableLookup{" +
                "restaurantTableId=" + restaurantTableId +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
