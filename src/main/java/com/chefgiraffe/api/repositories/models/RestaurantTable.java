package com.chefgiraffe.api.repositories.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@javax.persistence.Table
public class RestaurantTable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private String friendlyName;
    private Integer availableSeats;

    protected RestaurantTable() {
    }

    public RestaurantTable(String friendlyName, Integer availableSeats) {
        this.friendlyName = friendlyName;
        this.availableSeats = availableSeats;
    }

    public UUID getId() {
        return id;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    @Override
    public String toString() {
        return "RestaurantTable{" +
                "id=" + id +
                ", friendlyName='" + friendlyName + '\'' +
                ", availableSeats=" + availableSeats +
                '}';
    }
}
