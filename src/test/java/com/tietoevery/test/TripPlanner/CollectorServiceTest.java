package com.tietoevery.test.TripPlanner;

import com.tietoevery.test.TripPlanner.domain.TripConditions;
import com.tietoevery.test.TripPlanner.service.CollectorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;

@SpringBootTest
public class CollectorServiceTest {

    @Autowired
    CollectorService collectorService;


    @Test
    public void whenSmallestDistance_thenPickJustDrink() {
        TripConditions conditions = new TripConditions(3L);
        List<String> found = collectorService.collectEquipmentByConditions(conditions);

        assertThat(found, hasItems("Juice"));
    }
}
