package com.chefgiraffe.api.services.models;

import java.util.UUID;

public class ItemLookup {

    private UUID itemId;

    public ItemLookup(UUID itemId) {
        this.itemId = itemId;
    }

    public UUID getItemId() {
        return itemId;
    }

    @Override
    public String toString() {
        return "ItemLookup{" +
                "itemId=" + itemId +
                '}';
    }
}
