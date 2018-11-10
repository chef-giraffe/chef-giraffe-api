package com.chefgiraffe.api.services.models;

import java.util.UUID;

public class CreatedOrder extends Order {

    private Integer itemsCount;

    public CreatedOrder(UUID orderId, UUID tableId, Integer itemsCount) {
        super(orderId, tableId);
        this.itemsCount = itemsCount;
    }

    public Integer getItemsCount() {
        return itemsCount;
    }
}
