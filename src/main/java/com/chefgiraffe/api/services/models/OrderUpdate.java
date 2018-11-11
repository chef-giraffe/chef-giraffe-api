package com.chefgiraffe.api.services.models;

import java.util.UUID;

public class OrderUpdate {

    private UUID orderId;
    private OrderStatus updateStatus;

    public OrderUpdate(UUID orderId, OrderStatus updateStatus) {
        this.orderId = orderId;
        this.updateStatus = updateStatus;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public OrderStatus getUpdateStatus() {
        return updateStatus;
    }
}
