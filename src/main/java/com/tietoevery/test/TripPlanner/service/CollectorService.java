package com.tietoevery.test.TripPlanner.service;

import com.tietoevery.test.TripPlanner.domain.TripConditions;
import com.tietoevery.test.TripPlanner.repository.EquipmentRepository;
import com.tietoevery.test.TripPlanner.service.equipment.BaseEquipment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CollectorService {

    final
    List<BaseEquipment> equipments;
    final
    EquipmentRepository equipmentRepository;

    public CollectorService(List<BaseEquipment> equipments, EquipmentRepository equipmentRepository) {
        this.equipments = equipments;
        this.equipmentRepository = equipmentRepository;
    }

    public List<String> collectEquipmentByConditions(TripConditions conditions){

       return equipments.stream()
               .filter(s -> s.supports(conditions))
               .map(s -> s.execute().name())
               .peek(s -> log.info("Processing type {}", s))
               .flatMap(s -> getEquipmentNames(s).stream())
               .collect(Collectors.toList());
    }

    List<String> getEquipmentNames(String type){
        return equipmentRepository.findAllByType(type);
    }

}
