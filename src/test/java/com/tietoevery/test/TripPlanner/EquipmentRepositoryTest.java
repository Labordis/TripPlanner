package com.tietoevery.test.TripPlanner;

import com.tietoevery.test.TripPlanner.repository.EquipmentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static com.tietoevery.test.TripPlanner.constants.EquipmentType.TOOL;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

@DataJpaTest
public class EquipmentRepositoryTest {

    @Autowired
    EquipmentRepository equipmentRepository;

    @Test
    public void whenSearchTools_thenReturnTwoItemsTest() {
        String type = TOOL.name();
        List<String> found = equipmentRepository.findAllByType(type);

        assertThat(found, hasSize(2));
    }
}
