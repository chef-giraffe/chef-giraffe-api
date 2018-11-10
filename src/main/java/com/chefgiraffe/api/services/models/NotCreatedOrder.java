package com.chefgiraffe.api.services.models;

import java.util.UUID;

public class NotCreatedOrder extends CreatedOrder {
    public NotCreatedOrder(UUID orderId, UUID tableId, Integer itemsCount) {
        super(orderId, tableId, itemsCount);
    }
}
