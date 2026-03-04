package com.hwnest25.plantpal.quiz;

public enum Preference {
    YES, NO, DOES_NOT_MATTER;

     @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
