package com.tietoevery.test.TripPlanner.domain;

import lombok.Data;

import java.util.Date;

@Data
public class TripConditions {
    Long distance;
    Date tripDate;

    public TripConditions(Long distance) {
        this.distance = distance;
    }

    public TripConditions(Long distance, Date tripDate) {
        this.distance = distance;
        this.tripDate = tripDate;
    }
}
