package com.chefgiraffe.api.controllers.models;

import java.util.List;
import java.util.UUID;

public class Order {

    private UUID tableId;
    private List<UUID> orderItems;

    public Order() {
    }

    public Order(UUID tableId, List<UUID> orderItems) {
        this.tableId = tableId;
        this.orderItems = orderItems;
    }

    public UUID getTableId() {
        return tableId;
    }

    public List<UUID> getOrderItems() {
        return orderItems;
    }

    @Override
    public String toString() {
        return "Order{" +
                "tableId=" + tableId +
                ", orderItems=" + orderItems +
                '}';
    }
}
