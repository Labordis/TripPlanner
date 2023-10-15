package com.tietoevery.test.TripPlanner.repository;

import com.tietoevery.test.TripPlanner.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

    @Query("SELECT e.name FROM Equipment e WHERE e.type = :type")
    List<String> findAllByType(String type);
}
