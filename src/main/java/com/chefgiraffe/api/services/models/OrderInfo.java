package com.chefgiraffe.api.services.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class OrderInfo extends Order {

    private LocalDateTime createdTime;

    public OrderInfo(UUID orderId, UUID tableId, OrderStatus orderStatus, LocalDateTime createdTime) {
        super(orderId, tableId, orderStatus);
        this.createdTime = createdTime;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "createdTime=" + createdTime +
                "} " + super.toString();
    }
}
