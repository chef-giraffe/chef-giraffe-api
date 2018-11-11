package com.chefgiraffe.api.services.models;

public class RestaurantCreate {

    private String name;

    public RestaurantCreate(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "RestaurantCreate{" +
                "name='" + name + '\'' +
                '}';
    }
}
