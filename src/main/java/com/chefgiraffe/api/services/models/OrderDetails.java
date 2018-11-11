package com.chefgiraffe.api.services.models;

import java.util.List;
import java.util.UUID;

public class OrderDetails extends Order {

    private List<ItemDetails> itemDetails;

    public OrderDetails(UUID orderId, UUID tableId, List<ItemDetails> itemDetails) {
        super(orderId, tableId);
        this.itemDetails = itemDetails;
    }

    public List<ItemDetails> getItemDetails() {
        return itemDetails;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "itemDetails=" + itemDetails +
                "} " + super.toString();
    }
}
