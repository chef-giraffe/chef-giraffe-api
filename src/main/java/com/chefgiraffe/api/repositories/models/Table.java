package com.chefgiraffe.api.repositories.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@javax.persistence.Table
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String friendlyName;
    private Integer availableSeats;

    protected Table() {
    }

    public Table(String friendlyName, Integer availableSeats) {
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
        return "Table{" +
                "id=" + id +
                ", friendlyName='" + friendlyName + '\'' +
                ", availableSeats=" + availableSeats +
                '}';
    }
}
