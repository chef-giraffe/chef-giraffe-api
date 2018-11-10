package com.chefgiraffe.api.services.models;

import java.util.UUID;

public class Order {

    private UUID orderId;
    private UUID tableId;

    Order(UUID orderId, UUID tableId) {
        this.orderId = orderId;
        this.tableId = tableId;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public UUID getTableId() {
        return tableId;
    }
}
