package com.hwnest25.plantpal.quiz;

import com.hwnest25.plantpal.model.PlantEnvironment;
import com.hwnest25.plantpal.model.PlantCareLevel;
import com.hwnest25.plantpal.model.PlantGrowthSpeed;

public class QuizAnswers {
    private PlantEnvironment plantEnvironmentPreference;
    private PlantCareLevel plantCareLevelPreference;
    private PlantGrowthSpeed plantGrowthSpeedPreference;
    private Preference petSafePreference;
    private Preference ediblePreference;
    
    /**
     * Default no-argument constructor.
     * This is intentionally empty to allow bean-style instantiation.
     */
    public QuizAnswers() {
                // No initialization needed; setters will be used to populate fields
    }

    public PlantEnvironment getPlantEnvironmentPreference() { return plantEnvironmentPreference; }
    public void setPlantEnvironmentPreference(PlantEnvironment plantEnvironmentPreference) { this.plantEnvironmentPreference = plantEnvironmentPreference; } 

    public PlantCareLevel getPlantCareLevelPreference() { return plantCareLevelPreference; }
    public void setPlantCareLevelPreference(PlantCareLevel plantCareLevelPreference) { this.plantCareLevelPreference = plantCareLevelPreference; }   

    public PlantGrowthSpeed getPlantGrowthSpeedPreference() { return plantGrowthSpeedPreference; }
    public void setPlantGrowthSpeedPreference(PlantGrowthSpeed plantGrowthSpeedPreference) { this.plantGrowthSpeedPreference = plantGrowthSpeedPreference; }

    public Preference getPetSafePreference() { return petSafePreference; }
    public void setPetSafePreference(Preference petSafePreference) { this.petSafePreference = petSafePreference; }

    public Preference getEdiblePreference() { return ediblePreference; }
    public void setEdiblePreference(Preference ediblePreference) { this.ediblePreference = ediblePreference; }
}
