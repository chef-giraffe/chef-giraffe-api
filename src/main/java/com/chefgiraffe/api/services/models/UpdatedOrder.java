package com.chefgiraffe.api.services.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class UpdatedOrder extends Order {

    private LocalDateTime updatedTime;

    public UpdatedOrder(UUID orderId, UUID tableId, OrderStatus orderStatus, LocalDateTime updatedTime) {
        super(orderId, tableId, orderStatus);
        this.updatedTime = updatedTime;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    @Override
    public String toString() {
        return "UpdatedOrder{" +
                "updatedTime=" + updatedTime +
                "} " + super.toString();
    }
}
