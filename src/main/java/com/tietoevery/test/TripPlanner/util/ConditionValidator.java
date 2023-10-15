package com.tietoevery.test.TripPlanner.util;

import com.tietoevery.test.TripPlanner.constants.Distance;
import com.tietoevery.test.TripPlanner.constants.Season;
import com.tietoevery.test.TripPlanner.domain.TripConditions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.BiPredicate;

import static com.tietoevery.test.TripPlanner.util.CommonUtils.getSeasonByDate;
import static com.tietoevery.test.TripPlanner.util.CommonUtils.putValueIfFalse;

@Slf4j
@Component
public class ConditionValidator {

    public static Boolean validate(TripConditions conditions, Enum... params){
        Map<Class, Boolean> state = new HashMap<>();
        Arrays.stream(params).forEach(param -> {
            if(param instanceof Distance){
                putValueIfFalse(state, Distance.class, distance.test(conditions.getDistance(), (Distance)param));
            }
            if(param instanceof Season){
                putValueIfFalse(state, Season.class, season.test(conditions.getTripDate(), (Season)param));
            }
        });
        return state.values().stream().allMatch(Boolean::booleanValue);
    }

    public static BiPredicate<Long, Distance> distance = (distance, limit) -> distance != null && distance >= limit.length;

    public static BiPredicate<Date, Season> season = (date, season) -> date != null && getSeasonByDate(date) == season;

}
