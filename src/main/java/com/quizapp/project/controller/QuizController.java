package com.quizapp.project.controller;

import com.quizapp.project.model.Question;
import com.quizapp.project.model.Quiz;
import com.quizapp.project.services.interfaces.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {
    private final QuizService service;

    public QuizController(QuizService service) {
        this.service = service;
    }
    @PostMapping
    public Quiz create(@RequestBody Quiz quiz){
        return service.create(quiz);
    }
    @GetMapping
    public List<Quiz> getAll(){
        return service.getAll();
    }
    @GetMapping("/start/{category}")
    public List<Question> startQuiz(@PathVariable String category){
        return service.startQuiz(category);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
