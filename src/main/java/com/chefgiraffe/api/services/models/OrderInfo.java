package com.chefgiraffe.api.services.models;

import java.util.UUID;

public class OrderInfo extends Order {

    private String orderStatus;

    public OrderInfo(UUID orderId, UUID tableId, String orderStatus) {
        super(orderId, tableId);
        this.orderStatus = orderStatus;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "orderStatus='" + orderStatus + '\'' +
                "} " + super.toString();
    }
}
