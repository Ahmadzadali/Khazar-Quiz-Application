package com.quizapp.project.controller;

import com.quizapp.project.model.Question;
import com.quizapp.project.services.interfaces.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/question")
public class QuestionController {
    private final QuestionService service;

    public QuestionController(QuestionService service) {
        this.service = service;
    }
    @PostMapping
    public Question add(@RequestBody Question question){
        return  service.add(question);
    }
    @PutMapping("/{id}")
    public Question update(@PathVariable Long id,@RequestBody Question question){
        return  service.update(id,question);
    };
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }

    @GetMapping
    public List<Question> getAll() { return service.getAll(); }

    @GetMapping("/quiz/{quizId}")
    public List<Question> getByQuiz(@PathVariable Long quizId) {
        return service.getByQuiz(quizId);
    }

}
