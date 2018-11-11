package com.chefgiraffe.api.services.models;

import java.util.UUID;

public class MenuItem extends Menu {

    public MenuItem(UUID id, UUID restaurantId, String name) {
        super(id, restaurantId, name);
    }
}
