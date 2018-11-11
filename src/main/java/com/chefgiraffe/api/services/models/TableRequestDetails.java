package com.chefgiraffe.api.services.models;

import java.util.List;
import java.util.UUID;

public class TableRequestDetails extends Table {

    private List<RequestDetails> requestDetails;

    public TableRequestDetails(UUID id, UUID restaurantId, List<RequestDetails> requestDetails) {
        super(id, restaurantId);
        this.requestDetails = requestDetails;
    }

    public List<RequestDetails> getRequestDetails() {
        return requestDetails;
    }

    @Override
    public String toString() {
        return "TableRequestDetails{" +
                "requestDetails=" + requestDetails +
                "} " + super.toString();
    }
}
