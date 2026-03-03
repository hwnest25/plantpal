package com.hwnest25.plantpal.quiz;
// import java.util.List;

public class PlantResultDto {
    
    private String plantName;
    private String scientificName;
    private String plantDescription;
    private String imageUrl;

    private String funFact;
    private String environment;
    private String careLevel;
    private String growthSpeed;
    private boolean petSafe;
    private boolean edible;

    // private List<String> matchingCriteria;

    public PlantResultDto() {}

    public String getPlantName() { return plantName; }
    public void setPlantName(String plantName) { this.plantName = plantName; }

    public String getPlantScientificName() { return scientificName;}
    public void setScientificName(String scientificName) { this.scientificName = scientificName; }

    public String getPlantDescription() { return plantDescription; }
    public void setPlantDescription(String plantDescription) { this.plantDescription = plantDescription; }

    public boolean isPlantEdible() { return edible; }
    public void setEdible(boolean edible) { this.edible = edible; }

    public String getPlantImageUrl() { return imageUrl; }
    public void setPlantImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public String getPlantFunFact() { return funFact; }
    public void setPlantFunFact(String funFact) { this.funFact = funFact; }

    public String getPlantEnvironment() { return environment; }
    public void setPlantEnvironment(String environment) { this.environment = environment; }

    public String getPlantCareLevel() { return careLevel; }
    public void setPlantCareLevel(String careLevel) { this.careLevel = careLevel; }

    public String getPlantGrowthSpeed() { return growthSpeed; }
    public void setPlantGrowthSpeed(String growthSpeed) { this.growthSpeed = growthSpeed; }

    public boolean isPetSafe() { return petSafe; }
    public void setPetSafe(boolean petSafe) { this.petSafe = petSafe; }
}
