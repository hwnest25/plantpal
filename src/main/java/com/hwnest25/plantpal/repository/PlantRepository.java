package com.hwnest25.plantpal.repository;

import org.springframework.stereotype.Repository;
import com.hwnest25.plantpal.model.Plant;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

@Repository
public class PlantRepository {

    private final List<Plant> plants;

    public PlantRepository(ObjectMapper objectMapper) {
        this.plants = loadPlants(objectMapper);
    }

    private List<Plant> loadPlants(ObjectMapper objectMapper) {
        try (InputStream is = new ClassPathResource("plants.json").getInputStream()) {
            return objectMapper.readValue(is, new TypeReference<List<Plant>>() {});
        } catch (IOException e) {
            throw new IllegalStateException(
                "Failed to load plants data from JSON file. Double-check JSON syntax and enum values", e
            );
        }
    }

    public List<Plant> findAll() {
        return Collections.unmodifiableList(plants);
    }
}
