package com.hwnest25.plantpal.service;

import com.hwnest25.plantpal.model.PlantCareLevel;
import com.hwnest25.plantpal.model.PlantEnvironment;
import com.hwnest25.plantpal.model.PlantGrowthSpeed;

public class PlantSearchCriteria {

    private String plantName;
    private PlantEnvironment plantEnvironment;
    private PlantCareLevel plantCareLevel;
    private PlantGrowthSpeed plantGrowthSpeed;
    private Boolean petSafe; // Keep as wrapper Boolean to all for null (no preference) values in search results.
    private Boolean edible; // Keep as wrapper Boolean to all for null (no preference) values in search results.

    public String getPlantName() { return plantName; }
    public void setPlantName(String plantName) { this.plantName = plantName; }

    public PlantEnvironment getPlantEnvironment() { return plantEnvironment; }
    public void setPlantEnvironment(PlantEnvironment plantEnvironment) { this.plantEnvironment = plantEnvironment; }

    public PlantCareLevel getPlantCareLevel() { return plantCareLevel; }
    public void setPlantCareLevel(PlantCareLevel plantCareLevel) { this.plantCareLevel = plantCareLevel; }

    public PlantGrowthSpeed getPlantGrowthSpeed() { return plantGrowthSpeed; }
    public void setPlantGrowthSpeed(PlantGrowthSpeed plantGrowthSpeed) { this.plantGrowthSpeed = plantGrowthSpeed; }

    public Boolean getPetSafe() { return petSafe; }
    public void setPetSafe(Boolean petSafe) { this.petSafe = petSafe; }

    public Boolean getEdible() { return edible; }
    public void setEdible(Boolean edible) { this.edible = edible; }
}