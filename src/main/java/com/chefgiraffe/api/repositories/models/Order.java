package com.chefgiraffe.api.repositories.models;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private UUID tableId;

    @ManyToOne
    @JoinColumn(name = "orderstatusid")
    private OrderStatus orderStatus;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "orderitem",
                joinColumns = @JoinColumn(name = "orderid", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "itemid", referencedColumnName = "id"))
    private List<Item> items;

    protected Order() {
    }

    public Order(UUID tableId, OrderStatus orderStatus) {
        this.tableId = tableId;
        this.items = new ArrayList<>();
        this.orderStatus = orderStatus;
    }

    public Order(UUID tableId, OrderStatus orderStatus, List<Item> items) {
        this.tableId = tableId;
        this.orderStatus = orderStatus;
        this.items = items;
    }

    public UUID getId() {
        return id;
    }

    public UUID getTableId() {
        return tableId;
    }

    public List<Item> getItems() {
        return items;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public boolean addItem(Item item) {
        return this.items.add(item);
    }

    @Override
    public String toString() {
        return "CreatedOrder{" +
                "id=" + id +
                ", items=" + items +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
