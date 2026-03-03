package com.hwnest25.plantpal.service;

import com.hwnest25.plantpal.model.Plant;
import com.hwnest25.plantpal.model.PlantEnvironment;
import com.hwnest25.plantpal.quiz.PlantScorer;
import com.hwnest25.plantpal.quiz.Preference;
import com.hwnest25.plantpal.quiz.QuizAnswers;
import com.hwnest25.plantpal.repository.PlantRepository;
import org.springframework.stereotype.Service;
import com.hwnest25.plantpal.quiz.PlantResultDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class QuizService {

    private final PlantRepository plantRepository;
   
    private final Random random = new Random();


    public QuizService(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }



    public PlantResultDto recommend(QuizAnswers answers) {
        List<Plant> plants = plantRepository.findAll();
        if (plants.isEmpty()) {
            throw new IllegalStateException("No plants loaded. Check plants.json.");
        }

        int bestScore = Integer.MIN_VALUE;
        List<Plant> bestPlants = new ArrayList<>();

        for (Plant plant : plants) {
            int score = PlantScorer.score(plant, answers);

            if (score > bestScore) {
                bestScore = score;
                bestPlants.clear();
                bestPlants.add(plant);
            } else if (score == bestScore) {
                bestPlants.add(plant);
            }
        }

        Plant chosen = bestPlants.get(random.nextInt(bestPlants.size()));
        List<String> reasons = buildMatchReasons(chosen, answers);

        return toDto(chosen, reasons);
    }

    private PlantResultDto toDto(Plant plant, List<String> reasons) {
        PlantResultDto dto = new PlantResultDto();
        dto.setPlantName(plant.getPlantName());
        dto.setPlantScientificName(plant.getPlantScientificName());
        dto.setPlantDescription(plant.getPlantDescription());
        dto.setPlantImageUrl(plant.getPlantImageUrl());

        

        dto.setPlantFunFact(plant.getPlantFunFact());
        dto.setPlantEnvironment(plant.getPlantEnvironment().name());
        dto.setPlantCareLevel(plant.getPlantCareLevel().name());
        dto.setPlantGrowthSpeed(plant.getPlantGrowthSpeed().name());
        dto.setPetSafe(plant.isPetSafe());
        dto.setEdible(plant.isEdible());

        dto.setPlantMatchReasons(reasons);
        return dto;
    }

    private List<String> buildMatchReasons(Plant plant, QuizAnswers a) {
        List<String> reasons = new ArrayList<>();

        // Environment reason (match or compatible via BOTH)
        PlantEnvironment plantEnv = plant.getPlantEnvironment();
        PlantEnvironment userEnv = a.getPlantEnvironmentPreference();

        boolean envExact = (plantEnv == userEnv);
        boolean envCompatible =
                (plantEnv == PlantEnvironment.BOTH && (userEnv == PlantEnvironment.INDOOR || userEnv == PlantEnvironment.OUTDOOR))
             || (userEnv == PlantEnvironment.BOTH && (plantEnv == PlantEnvironment.INDOOR || plantEnv == PlantEnvironment.OUTDOOR));

        if (envExact) {
            reasons.add("Environment match: " + userEnv);
        } else if (envCompatible) {
            reasons.add("Environment compatible: " + userEnv);
        }

        // Care level reason (exact only, keep it simple and honest)
        if (plant.getPlantCareLevel() == a.getPlantCareLevelPreference()) {
            reasons.add("Care level match: " + a.getPlantCareLevelPreference());
        }

        // Growth speed reason (exact only)
        if (plant.getPlantGrowthSpeed() == a.getPlantGrowthSpeedPreference()) {
            reasons.add("Growth speed match: " + a.getPlantGrowthSpeedPreference());
        }

        // Pet safety reason (only if user cares)
        if (a.getPetSafePreference() != Preference.DOES_NOT_MATTER) {
            boolean wantsPetSafe = (a.getPetSafePreference() == Preference.YES);
            if (plant.isPetSafe() == wantsPetSafe) {
                reasons.add("Matches your pet-safety preference");
            }
        }

        // Edibility reason (only if user cares)
        if (a.getEdiblePreference() != Preference.DOES_NOT_MATTER) {
            boolean wantsEdible = (a.getEdiblePreference() == Preference.YES);
            if (plant.isEdible() == wantsEdible) {
                reasons.add("Matches your edibility preference");
            }
        }

        // Limit to 3 reasons for UI clarity
        return (reasons.size() > 3) ? reasons.subList(0, 3) : reasons;
    }
}