package com.chefgiraffe.api.services.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class CreatedRequest extends Request {

    private LocalDateTime createdTime;

    public CreatedRequest(UUID id, UUID restaurantTableId, String description, LocalDateTime createdTime) {
        super(id, restaurantTableId, description);
        this.createdTime = createdTime;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    @Override
    public String toString() {
        return "CreatedRequest{" +
                "createdTime=" + createdTime +
                "} " + super.toString();
    }
}
