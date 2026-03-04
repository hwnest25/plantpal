package com.hwnest25.plantpal.web;

import com.hwnest25.plantpal.quiz.PlantResultDto;
import com.hwnest25.plantpal.quiz.QuizAnswers;
import com.hwnest25.plantpal.service.QuizService;
import com.hwnest25.plantpal.repository.PlantRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {

    private final QuizService quizService;
    private final PlantRepository plantRepository;

    public PageController(QuizService quizService,
                          PlantRepository plantRepository) {
        this.quizService = quizService;
        this.plantRepository = plantRepository;
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
 