package com.tietoevery.test.TripPlanner.controller;

import com.tietoevery.test.TripPlanner.domain.Backpack;
import com.tietoevery.test.TripPlanner.domain.TripConditions;
import com.tietoevery.test.TripPlanner.service.CollectorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Backpack organizer", description = "This tool suggests items that are required for hiking based on trip conditions")
@RequestMapping("/api")
public class TripController {

    final
    CollectorService collectorService;

    public TripController(CollectorService collectorService) {
        this.collectorService = collectorService;
    }

    @PostMapping("/pack")
    @Operation(summary = "Pack items to backpack",
            description = "Based on trip conditions, it returns recommended items.")
    public Backpack pack(@RequestBody TripConditions conditions) {
        List<String> list = collectorService.collectEquipmentByConditions(conditions);
        return new Backpack(list);
    }

}
