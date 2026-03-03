package com.hwnest25.plantpal.quiz;

public final class ScoreRules {
    private ScoreRules() {}

    // Scoring rules for quiz matching. Using constants for maintainability and clarity.
    // Constants will only be referenced therefore so no instances will be created. 

    public static final int EXACT_MATCH = 3;
    public static final int COMPATIBLE_MATCH = 2;
    public static final int BOOLEAN_MATCH = 3;
    public static final int NO_MATCH = 0;
}
