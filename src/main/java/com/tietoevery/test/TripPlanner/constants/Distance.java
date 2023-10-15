package com.tietoevery.test.TripPlanner.constants;

public enum Distance {

    MICRO(3L),
    MINI(5L),
    SHORT(30L),
    MEDIUM(40L),
    LONG(50L),
    EXTRA_LONG(70L),
    SUPER_LONG(90L);

    public final Long length;

    Distance(Long length) {
        this.length = length;
    }

}
