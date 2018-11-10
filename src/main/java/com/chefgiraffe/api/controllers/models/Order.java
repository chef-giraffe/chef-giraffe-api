package com.chefgiraffe.api.controllers.models;

import java.util.List;
import java.util.UUID;

public class Order {
    private UUID tableId;
    private List<UUID> orderItems;
}
