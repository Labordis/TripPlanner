package com.tietoevery.test.TripPlanner.service.equipment;

import com.tietoevery.test.TripPlanner.constants.EquipmentType;
import com.tietoevery.test.TripPlanner.domain.TripConditions;

public interface BaseEquipment {

    boolean supports(TripConditions conditions);

    EquipmentType execute();
}
