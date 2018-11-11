package com.chefgiraffe.api.services.models;

import java.util.UUID;

public class CreatedTable extends Table {

    public CreatedTable(UUID tableId, UUID restaurantId) {
        super(tableId, restaurantId);
    }
}
