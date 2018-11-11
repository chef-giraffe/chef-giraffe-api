package com.chefgiraffe.api.repositories.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table
public class Restaurant {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_id")
    private List<RestaurantMenu> menus;

    private Timestamp createdTime;

    protected Restaurant() {
    }

    public Restaurant(String name, Timestamp createdTime) {
        this.name = name;
        this.createdTime = createdTime;
        this.menus = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<RestaurantMenu> getMenus() {
        return menus;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", menus=" + menus +
                ", createdTime=" + createdTime +
                '}';
    }
}
