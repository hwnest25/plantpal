package com.hwnest25.plantpal.model;

public class Plant {
    private String plantName;
    private String plantScientificName;
    private String plantDescription;
    private boolean edible;
    private String plantImageUrl;
    private String plantFunFact;
    private PlantEnvironment plantEnvironment;
    private PlantCareLevel plantCareLevel;
    private PlantGrowthSpeed plantGrowthSpeed;
    private boolean petSafe;
    
    
    public Plant() { /* 
        // Default constructor for JSON deserialization
    */}

    

        public String getPlantName() { return plantName; }
        public void setPlantName(String plantName) { this.plantName = plantName; }
        
        public String getPlantScientificName() { return plantScientificName;}
        public void setPlantScientificName(String plantScientificName) { this.plantScientificName = plantScientificName; }
        
        public String getPlantDescription() { return plantDescription; }
        public void setPlantDescription(String plantDescription) { this.plantDescription = plantDescription; }
        
        public boolean isEdible() { return edible; }
        public void setEdible(boolean edible) { this.edible = edible; }
       
        public String getPlantImageUrl() { return plantImageUrl; }
        public void setPlantImageUrl(String plantImageUrl) { this.plantImageUrl = plantImageUrl; }

        public String getPlantFunFact() { return plantFunFact; }
        public void setPlantFunFact(String plantFunFact) { this.plantFunFact = plantFunFact; }
        
        public PlantEnvironment getPlantEnvironment() { return plantEnvironment; }
        public void setPlantEnvironment(PlantEnvironment plantEnvironment) { this.plantEnvironment = plantEnvironment; }
        
        public PlantCareLevel getPlantCareLevel() { return plantCareLevel; }
        public void setPlantCareLevel(PlantCareLevel plantCareLevel) { this.plantCareLevel = plantCareLevel; }
        
        public PlantGrowthSpeed getPlantGrowthSpeed() { return plantGrowthSpeed; }
        public void setPlantGrowthSpeed(PlantGrowthSpeed plantGrowthSpeed) { this.plantGrowthSpeed = plantGrowthSpeed; }
        
        public boolean isPetSafe() { return petSafe; }
        public void setPetSafe(boolean petSafe) { this.petSafe = petSafe; }
    
    }
