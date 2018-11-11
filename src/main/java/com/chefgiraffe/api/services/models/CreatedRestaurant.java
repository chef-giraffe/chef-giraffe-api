package com.chefgiraffe.api.services.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class CreatedRestaurant extends Restaurant{

    private LocalDateTime createdTime;

    public CreatedRestaurant(UUID id, String name, LocalDateTime createdTime) {
        super(id, name);
        this.createdTime = createdTime;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    @Override
    public String toString() {
        return "CreatedRestaurant{" +
                "createdTime=" + createdTime +
                "} " + super.toString();
    }
}
