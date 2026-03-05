package com.hwnest25.plantpal.quiz;

import java.util.List;

public class PlantResultDto {

    private String plantName;
    private String plantScientificName;
    private String plantDescription;
    private String plantImageUrl;

    private String plantFunFact;
    private String plantEnvironment;
    private String plantCareLevel;
    private String plantGrowthSpeed;

    private boolean petSafe;
    private boolean edible;

    private List<String> plantMatchReasons;


    public PlantResultDto() {
     // ... 

    }

    public String getPlantName() { return plantName; }
    public void setPlantName(String plantName) { this.plantName = plantName; }

    public String getPlantScientificName() { return plantScientificName; }
    public void setPlantScientificName(String plantScientificName) { this.plantScientificName = plantScientificName; }

    public String getPlantDescription() { return plantDescription; }
    public void setPlantDescription(String plantDescription) { this.plantDescription = plantDescription; }

    public String getPlantImageUrl() { return plantImageUrl; }
    public void setPlantImageUrl(String plantImageUrl) { this.plantImageUrl = plantImageUrl; }

    public String getPlantFunFact() { return plantFunFact; }
    public void setPlantFunFact(String plantFunFact) { this.plantFunFact = plantFunFact; }

    public String getPlantEnvironment() { return plantEnvironment; }
    public void setPlantEnvironment(String plantEnvironment) { this.plantEnvironment = plantEnvironment; }

    public String getPlantCareLevel() { return plantCareLevel; }
    public void setPlantCareLevel(String plantCareLevel) { this.plantCareLevel = plantCareLevel; }

    public String getPlantGrowthSpeed() { return plantGrowthSpeed; }
    public void setPlantGrowthSpeed(String plantGrowthSpeed) { this.plantGrowthSpeed = plantGrowthSpeed; }

    public boolean isPetSafe() { return petSafe; }
    public void setPetSafe(boolean petSafe) { this.petSafe = petSafe; }

    public boolean isEdible() { return edible; }
    public void setEdible(boolean edible) { this.edible = edible; }

    public List<String> getPlantMatchReasons() { return plantMatchReasons; }
    public void setPlantMatchReasons(List<String> plantMatchReasons) {
        this.plantMatchReasons = plantMatchReasons;
    }
}