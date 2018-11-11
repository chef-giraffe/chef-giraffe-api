package com.chefgiraffe.api.services.models;

import java.util.List;
import java.util.UUID;

public class TableOrderDetails extends TableInfo {

    private List<OrderDetails> orderDetails;

    public TableOrderDetails(UUID id,
                             UUID restaurantId,
                             String friendlyName,
                             Integer availableSeats,
                             List<OrderDetails> orderDetails) {
        super(id, restaurantId, friendlyName, availableSeats);
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
