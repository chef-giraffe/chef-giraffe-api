package com.chefgiraffe.api.services.models;

import java.util.UUID;

public class CreatedOrder extends Order {

    private Integer itemsCount;

    public CreatedOrder(UUID orderId, UUID tableId, OrderStatus orderStatus, Integer itemsCount) {
        super(orderId, tableId, orderStatus);
        this.itemsCount = itemsCount;
    }

    public Integer getItemsCount() {
        return itemsCount;
    }

    @Override
    public String toString() {
        return "CreatedOrder{" +
                "itemsCount=" + itemsCount +
                "} " + super.toString();
    }
}
