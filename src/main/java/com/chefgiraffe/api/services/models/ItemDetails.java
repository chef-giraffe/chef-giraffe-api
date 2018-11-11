package com.chefgiraffe.api.services.models;

import java.math.BigDecimal;
import java.util.UUID;

public class ItemDetails extends Item {

    private String name;
    private String description;
    private BigDecimal price;
    private String imageUri;

    public ItemDetails(UUID itemId,
                       UUID restaurantMenuId,
                       String name,
                       String description,
                       BigDecimal price,
                       String imageUri) {
        super(itemId, restaurantMenuId);
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUri = imageUri;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getImageUri() {
        return imageUri;
    }

    @Override
    public String toString() {
        return "ItemDetails{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", imageUri='" + imageUri + '\'' +
                "} " + super.toString();
    }
}
