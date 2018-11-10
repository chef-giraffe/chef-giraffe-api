package com.chefgiraffe.api.repository.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Order {

    @Id
    @GeneratedValue
    private UUID id;
    private UUID tableId;
    private UUID itemId;

    @OneToOne
    private OrderStatus orderStatus;

    public Order() {
    }

    public Order(UUID tableId, UUID itemId, OrderStatus orderStatus) {
        this.tableId = tableId;
        this.itemId = itemId;
        this.orderStatus = orderStatus;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getTableId() {
        return tableId;
    }

    public void setTableId(UUID tableId) {
        this.tableId = tableId;
    }

    public UUID getItemId() {
        return itemId;
    }

    public void setItemId(UUID itemId) {
        this.itemId = itemId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", tableId=" + tableId +
                ", itemId=" + itemId +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
