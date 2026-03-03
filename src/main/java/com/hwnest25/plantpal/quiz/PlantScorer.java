package com.hwnest25.plantpal.quiz;

import com.hwnest25.plantpal.model.PlantCareLevel;
import com.hwnest25.plantpal.model.PlantEnvironment;
import com.hwnest25.plantpal.model.PlantGrowthSpeed;
import com.hwnest25.plantpal.model.Plant;   
import static com.hwnest25.plantpal.quiz.ScoreRules.*;

public class PlantScorer {
    private PlantScorer() {}

    public static int score(Plant plant, QuizAnswers answers) {
        int score = 0;

        score += scorePlantEnvironment(plant.getPlantEnvironment(), answers.getPlantEnvironmentPreference());
        score += scorePlantCareLevel(plant.getPlantCareLevel(), answers.getPlantCareLevelPreference());
        score += scorePlantGrowthSpeed(plant.getPlantGrowthSpeed(), answers.getPlantGrowthSpeedPreference());
        score += scoreBooleanPreference(plant.isPetSafe(), answers.getPetSafePreference());
        score += scoreBooleanPreference(plant.isEdible(), answers.getEdiblePreference());

        return score;
    }

    static int scorePlantEnvironment(PlantEnvironment plantEnv, PlantEnvironment userEnv) {
        if (plantEnv == userEnv) { return EXACT_MATCH; }
        
        // BOTH is compatible with either INDOOR or OUTDOOR (and vice versa)
        else if (plantEnv == PlantEnvironment.BOTH &&
            (userEnv == PlantEnvironment.INDOOR || userEnv == PlantEnvironment.OUTDOOR)) {
            return COMPATIBLE_MATCH;
        }
        else if (userEnv == PlantEnvironment.BOTH &&
            (plantEnv == PlantEnvironment.INDOOR || plantEnv == PlantEnvironment.OUTDOOR)) {
            return ScoreRules.COMPATIBLE_MATCH;
        }
        else { return NO_MATCH; }
    }

    /**
     * CareLevel is treated as "maximum difficulty the user can handle":
     * EASY   -> only EASY
     * MEDIUM -> EASY or MEDIUM
     * HARD   -> EASY, MEDIUM, or HARD
     */
    static int scorePlantCareLevel(PlantCareLevel plantCare, PlantCareLevel userCare) {
        if (plantCare == userCare) return EXACT_MATCH;

        if (userCare == PlantCareLevel.MEDIUM && plantCare == PlantCareLevel.EASY) {
            return COMPATIBLE_MATCH;
        }

        if (userCare == PlantCareLevel.HARD &&
            (plantCare == PlantCareLevel.EASY || plantCare == PlantCareLevel.MEDIUM)) {
            return COMPATIBLE_MATCH;
        }

        return NO_MATCH;
    }

    /**
     * Scoring context - GrowthSpeed is treated as "maximum speed the user can tolerate":
     * SLOW means only SLOW
     * MEDIUM is open to SLOW or MEDIUM
     * FAST means only FAST 
     */
    static int scorePlantGrowthSpeed(PlantGrowthSpeed plantGrowth, PlantGrowthSpeed userGrowth) {
        if (plantGrowth == userGrowth) return EXACT_MATCH;

        if (userGrowth == PlantGrowthSpeed.MEDIUM && plantGrowth == PlantGrowthSpeed.SLOW) {
            return COMPATIBLE_MATCH;
        }

        return NO_MATCH;
    }

    static int scoreBooleanPreference(boolean plantValue, Preference pref) {
        if (pref == Preference.DOES_NOT_MATTER) return 0;

        boolean userWantsTrue = (pref == Preference.YES);
        return (plantValue == userWantsTrue) ? BOOLEAN_MATCH : NO_MATCH;
    }


}
