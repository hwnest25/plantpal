package com.hwnest25.plantpal.model;

public class Plant {
    private String plantName;
    private String scientificName;
    private String plantDescription;
    private boolean edible;
    private String imageUrl;
    private String funFact;
    private PlantEnvironment environment;
    private PlantCareLevel careLevel;
    private PlantGrowthSpeed growthSpeed;
    private boolean petSafe;
    
    
    public Plant() {}

        public String getPlantName() { return plantName; }
        public void setPlantName(String plantName) { this.plantName = plantName; }
        
        public String getPlantScientificName() { return scientificName;}
        public void setPlantScientificName(String scientificName) { this.scientificName = scientificName; }
        
        public String getPlantDescription() { return plantDescription; }
        public void setPlantDescription(String plantDescription) { this.plantDescription = plantDescription; }
        
        public boolean isEdible() { return edible; }
        public void setEdible(boolean edible) { this.edible = edible; }
       
        public String getPlantImageUrl() { return imageUrl; }
        public void setPlantImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

        public String getFunFact() { return funFact; }
        public void setFunFact(String funFact) { this.funFact = funFact; }
        
        public PlantEnvironment getPlantEnvironment() { return environment; }
        public void setPlantEnvironment(PlantEnvironment environment) { this.environment = environment; }
        
        public PlantCareLevel getPlantCareLevel() { return careLevel; }
        public void setPlantCareLevel(PlantCareLevel careLevel) { this.careLevel = careLevel; }
        
        public PlantGrowthSpeed getPlantGrowthSpeed() { return growthSpeed; }
        public void setPlantGrowthSpeed(PlantGrowthSpeed growthSpeed) { this.growthSpeed = growthSpeed; }
        
        public boolean isPetSafe() { return petSafe; }
        public void setPetSafe(boolean petSafe) { this.petSafe = petSafe; }
    
    }
