package com.chefgiraffe.api.services.models;

import java.util.List;
import java.util.UUID;

public class RestaurantMenuDetails extends Restaurant {

    private List<MenuDetails> menuDetails;

    public RestaurantMenuDetails(UUID id, String name, List<MenuDetails> menuDetails) {
        super(id, name);
        this.menuDetails = menuDetails;
    }

    public List<MenuDetails> getMenuDetails() {
        return menuDetails;
    }

    @Override
    public String toString() {
        return "RestaurantMenuDetails{" +
                "menuDetails=" + menuDetails +
                "} " + super.toString();
    }
}
