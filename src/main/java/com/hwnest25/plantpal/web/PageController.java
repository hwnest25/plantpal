package com.hwnest25.plantpal.web;

import com.hwnest25.plantpal.quiz.PlantResultDto;
import com.hwnest25.plantpal.quiz.QuizAnswers;
import com.hwnest25.plantpal.service.QuizService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {

    private final QuizService quizService;

    public PageController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
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
 