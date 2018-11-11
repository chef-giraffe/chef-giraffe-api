package com.chefgiraffe.api.services.models;

import java.util.List;
import java.util.UUID;

public class TableOrderDetails extends Table {

    private List<OrderDetails> orderDetails;

    public TableOrderDetails(UUID id, UUID restaurantId, List<OrderDetails> orderDetails) {
        super(id, restaurantId);
        this.orderDetails = orderDetails;
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    @Override
    public String toString() {
        return "TableOrderDetails{" +
                "orderDetails=" + orderDetails +
                "} " + super.toString();
    }
}
