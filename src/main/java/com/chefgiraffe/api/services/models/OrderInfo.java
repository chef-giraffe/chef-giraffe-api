package com.chefgiraffe.api.services.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class OrderInfo extends Order {

    private String orderStatus;
    private LocalDateTime createdTime;

    public OrderInfo(UUID orderId, UUID tableId, String orderStatus, LocalDateTime createdTime) {
        super(orderId, tableId);
        this.orderStatus = orderStatus;
        this.createdTime = createdTime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "orderStatus='" + orderStatus + '\'' +
                ", createdTime=" + createdTime +
                "} " + super.toString();
    }
}
