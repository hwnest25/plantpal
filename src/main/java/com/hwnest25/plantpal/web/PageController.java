package com.hwnest25.plantpal.web;

import com.hwnest25.plantpal.quiz.PlantResultDto;
import com.hwnest25.plantpal.quiz.QuizAnswers;
import com.hwnest25.plantpal.service.QuizService;
import com.hwnest25.plantpal.repository.PlantRepository;
import com.hwnest25.plantpal.model.PlantCareLevel;
import com.hwnest25.plantpal.model.PlantEnvironment;
import com.hwnest25.plantpal.model.PlantGrowthSpeed;    
import com.hwnest25.plantpal.service.PlantSearchCriteria;
import com.hwnest25.plantpal.service.PlantSearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

    private final QuizService quizService;
    private final PlantRepository plantRepository;
    private final PlantSearchService plantSearchService;

    public PageController(QuizService quizService,
                          PlantRepository plantRepository,
                          PlantSearchService plantSearchService
                        ) {
        this.quizService = quizService;
        this.plantRepository = plantRepository;
        this.plantSearchService = plantSearchService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    // This is the plants gallery page. It shows all plants in the repository.
    @GetMapping("/plants")
    public String showPlants(Model model) {
        model.addAttribute("plants", plantRepository.findAll());
        return "plants";
    }
    @GetMapping("/search")
    public String search(
        @RequestParam(required = false) String plantName,
        @RequestParam(required = false) PlantEnvironment plantEnvironment,
        @RequestParam(required = false) PlantCareLevel plantCareLevel,
        @RequestParam(required = false) PlantGrowthSpeed plantGrowthSpeed,
        @RequestParam(required = false) Boolean petSafe,
        @RequestParam(required = false) Boolean edible,
        Model model)
        {
        PlantSearchCriteria criteria = new PlantSearchCriteria();
        criteria.setPlantName(plantName);
        criteria.setPlantEnvironment(plantEnvironment);
        criteria.setPlantCareLevel(plantCareLevel);
        criteria.setPlantGrowthSpeed(plantGrowthSpeed);
        criteria.setPetSafe(petSafe);
        criteria.setEdible(edible);

        model.addAttribute("criteria", criteria);
        model.addAttribute("plants", plantSearchService.search(criteria));

        model.addAttribute("plantEnvironmentOptions", PlantEnvironment.values());
        model.addAttribute("plantCareLevelOptions", PlantCareLevel.values());
        model.addAttribute("plantGrowthSpeedOptions", PlantGrowthSpeed.values());

        return "search";
            
    }

    @GetMapping("/quiz")
    public String quiz(Model model) {
        model.addAttribute("answers", new QuizAnswers());
        return "quiz";
    }

    @PostMapping("/result")
    public String result(@ModelAttribute("answers") QuizAnswers answers, Model model) {
        PlantResultDto plant = quizService.recommend(answers);
        model.addAttribute("plant", plant);
        return "result";
    }


}