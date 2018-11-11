package com.chefgiraffe.api.services.models;

import java.util.UUID;

public class OrderLookup {

    private UUID orderId;

    public OrderLookup(UUID orderId) {
        this.orderId = orderId;
    }

    public UUID getOrderId() {
        return orderId;
    }

    @Override
    public String toString() {
        return "OrderLookup{" +
                "orderId=" + orderId +
                '}';
    }
}
