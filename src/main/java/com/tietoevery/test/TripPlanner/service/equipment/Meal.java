package com.tietoevery.test.TripPlanner.service.equipment;

import com.tietoevery.test.TripPlanner.constants.Distance;
import com.tietoevery.test.TripPlanner.constants.EquipmentType;
import com.tietoevery.test.TripPlanner.domain.TripConditions;
import org.springframework.stereotype.Component;

import static com.tietoevery.test.TripPlanner.util.ConditionValidator.validate;

@Component
public class Meal implements BaseEquipment {

    @Override
    public boolean supports(TripConditions conditions) {
        return validate(conditions, Distance.MEDIUM);
    }

    @Override
    public EquipmentType execute() {
        String type = this.getClass().getSimpleName().toUpperCase();
        return EquipmentType.valueOf(type);
    }
}
