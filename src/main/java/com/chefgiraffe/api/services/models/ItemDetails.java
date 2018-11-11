package com.chefgiraffe.api.services.models;

import java.math.BigDecimal;
import java.util.UUID;

public class ItemDetails extends Item {

    private String itemName;
    private String itemDescription;
    private BigDecimal itemPrice;
    private String itemImageUri;

    public ItemDetails(UUID itemId,
                       UUID restaurantMenuId,
                       String itemName,
                       String itemDescription,
                       BigDecimal itemPrice,
                       String itemImageUri) {
        super(itemId, restaurantMenuId);
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
        this.itemImageUri = itemImageUri;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public String getItemImageUri() {
        return itemImageUri;
    }

    @Override
    public String toString() {
        return "ItemDetails{" +
                "itemName='" + itemName + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", itemPrice=" + itemPrice +
                ", itemImageUri='" + itemImageUri + '\'' +
                "} " + super.toString();
    }
}
