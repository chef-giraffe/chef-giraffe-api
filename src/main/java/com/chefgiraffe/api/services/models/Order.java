package com.chefgiraffe.api.services.models;

import java.util.UUID;

public class Order {

    private UUID id;
    private UUID tableId;

    Order(UUID id, UUID tableId) {
        this.id = id;
        this.tableId = tableId;
    }

    public UUID getId() {
        return id;
    }

    public UUID getTableId() {
        return tableId;
    }
}
