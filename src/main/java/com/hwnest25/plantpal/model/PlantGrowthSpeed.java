package com.hwnest25.plantpal.model;

public enum PlantGrowthSpeed {
    FAST, MEDIUM, SLOW;

     @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
