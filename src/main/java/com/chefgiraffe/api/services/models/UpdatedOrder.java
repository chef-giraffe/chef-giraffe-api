package com.chefgiraffe.api.services.models;

import java.util.UUID;

public class UpdatedOrder extends Order {

    private OrderStatus newStatus;

    public UpdatedOrder(UUID orderId, UUID tableId, OrderStatus newStatus) {
        super(orderId, tableId);
        this.newStatus = newStatus;
    }

    public OrderStatus getNewStatus() {
        return newStatus;
    }
}
