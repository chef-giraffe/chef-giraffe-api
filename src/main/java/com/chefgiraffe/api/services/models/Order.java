package com.chefgiraffe.api.services.models;

import java.util.UUID;

public class Order {

    private UUID id;
    private UUID tableId;
    private OrderStatus orderStatus;

    Order(UUID id, UUID tableId, OrderStatus orderStatus) {
        this.id = id;
        this.tableId = tableId;
        this.orderStatus = orderStatus;
    }

    public UUID getId() {
        return id;
    }

    public UUID getTableId() {
        return tableId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", tableId=" + tableId +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
