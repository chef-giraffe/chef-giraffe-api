package com.chefgiraffe.api.services.models;

import java.util.UUID;

public class RequestDetails extends Request {

    public RequestDetails(UUID id, UUID restaurantTableId, String description) {
        super(id, restaurantTableId, description);
    }

    @Override
    public String toString() {
        return "RequestDetails{} " + super.toString();
    }
}
