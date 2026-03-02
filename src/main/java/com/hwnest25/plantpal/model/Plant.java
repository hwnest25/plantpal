package com.hwnest25.plantpal.model;

public class Plant {
    private String plantName;
    private String scientificName;
    private String plantDescription;
    private boolean edible;
    private String imageUrl;
    private String funFact;
    private Environment environment;
    private CareLevel careLevel;
    private GrowthSpeed growthSpeed;
    private boolean petSafe;
    
    
    public Plant() {}

        public String getPlantName() { return plantName; }
        public void setPlantName(String plantName) { this.plantName = plantName; }
        
        public String getScientificName() { return scientificName;}
        public void setScientificName(String scientificName) { this.scientificName = scientificName; }
        
        public String getPlantDescription() { return plantDescription; }
        public void setPlantDescription(String plantDescription) { this.plantDescription = plantDescription; }
        
        public boolean isEdible() { return edible; }
        public void setEdible(boolean edible) { this.edible = edible; }
       
        public String getImageUrl() { return imageUrl; }
        public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

        public String getFunFact() { return funFact; }
        public void setFunFact(String funFact) { this.funFact = funFact; }
        
        public Environment getEnvironment() { return environment; }
        public void setEnvironment(Environment environment) { this.environment = environment; }
        
        public CareLevel getCareLevel() { return careLevel; }
        public void setCareLevel(CareLevel careLevel) { this.careLevel = careLevel; }
        
        public GrowthSpeed getGrowthSpeed() { return growthSpeed; }
        public void setGrowthSpeed(GrowthSpeed growthSpeed) { this.growthSpeed = growthSpeed; }
        
        public boolean isPetSafe() { return petSafe; }
        public void setPetSafe(boolean petSafe) { this.petSafe = petSafe; }
    
    }
