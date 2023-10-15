package com.tietoevery.test.TripPlanner.util;

import com.tietoevery.test.TripPlanner.constants.Season;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class CommonUtils {

    public static Season getSeasonByDate(Date date){
        int month = getMonthByDate(date);
        return switch (month) {
            case 3, 4, 5 -> Season.SPRING;
            case 6, 7, 8 -> Season.SUMMER;
            case 9, 10, 11 -> Season.FALL;
            case 12, 1, 2 -> Season.WINTER;
            default -> throw new IllegalStateException("Unexpected value: " + month);
        };
    }

    private static int getMonthByDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH);
    }

    public static Map<Class, Boolean> putValueIfFalse(Map<Class, Boolean> map, Class className, Boolean value){
        if(map.get(className) == null || !map.get(className)){
            map.put(className, value);
        }
        return map;
    }
}
