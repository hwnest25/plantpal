package com.hwnest25.plantpal.service;

import com.hwnest25.plantpal.model.Plant;
import com.hwnest25.plantpal.repository.PlantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class PlantSearchService {

    private final PlantRepository plantRepository;

    public PlantSearchService(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    public List<Plant> search(PlantSearchCriteria c) {
        return plantRepository.findAll().stream()
            .filter(p -> c.getPlantName() == null || c.getPlantName().isBlank()
                || p.getPlantName().toLowerCase(Locale.ROOT).contains(c.getPlantName().toLowerCase(Locale.ROOT)))
            .filter(p -> c.getPlantEnvironment() == null || p.getPlantEnvironment() == c.getPlantEnvironment())
            .filter(p -> c.getPlantCareLevel() == null || p.getPlantCareLevel() == c.getPlantCareLevel())
            .filter(p -> c.getPlantGrowthSpeed() == null || p.getPlantGrowthSpeed() == c.getPlantGrowthSpeed())
            .filter(p -> c.getPetSafe() == null || p.isPetSafe() == c.getPetSafe())
            .filter(p -> c.getEdible() == null || p.isEdible() == c.getEdible())
            .collect(Collectors.toList());
    }
}