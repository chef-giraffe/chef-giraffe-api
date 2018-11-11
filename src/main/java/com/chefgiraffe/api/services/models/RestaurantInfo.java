package com.chefgiraffe.api.services.models;

import java.util.UUID;

public class RestaurantInfo extends Restaurant {

    private Integer menuCount;

    public RestaurantInfo(UUID id, String name, Integer menuCount) {
        super(id, name);
        this.menuCount = menuCount;
    }

    public Integer getMenuCount() {
        return menuCount;
    }

    @Override
    public String toString() {
        return "RestaurantInfo{" +
                "menuCount=" + menuCount +
                "} " + super.toString();
    }
}
