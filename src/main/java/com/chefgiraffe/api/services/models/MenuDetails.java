package com.chefgiraffe.api.services.models;

import java.util.List;
import java.util.UUID;

public class MenuDetails extends Menu {

    private List<ItemDetails> itemDetails;

    public MenuDetails(UUID id, UUID restaurantId, String name, List<ItemDetails> itemDetails) {
        super(id, restaurantId, name);
        this.itemDetails = itemDetails;
    }

    public List<ItemDetails> getItemDetails() {
        return itemDetails;
    }

    @Override
    public String toString() {
        return "MenuDetails{" +
                "itemDetails=" + itemDetails +
                "} " + super.toString();
    }
}
