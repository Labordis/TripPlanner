package com.tietoevery.test.TripPlanner.service.equipment;

import com.tietoevery.test.TripPlanner.constants.Distance;
import com.tietoevery.test.TripPlanner.constants.EquipmentType;
import com.tietoevery.test.TripPlanner.constants.Season;
import com.tietoevery.test.TripPlanner.domain.TripConditions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.tietoevery.test.TripPlanner.util.ConditionValidator.*;

@Slf4j
@Component
public class Camping implements BaseEquipment {

    @Override
    public boolean supports(TripConditions conditions) {
        return validate(conditions, Distance.SUPER_LONG, Season.SUMMER, Season.FALL);
    }

    @Override
    public EquipmentType execute() {
        String type = this.getClass().getSimpleName().toUpperCase();
        return EquipmentType.valueOf(type);
    }
}