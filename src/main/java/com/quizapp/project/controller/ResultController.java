package com.quizapp.project.controller;

import com.quizapp.project.model.Result;
import com.quizapp.project.services.interfaces.ResultService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/result")
public class ResultController {
    private final ResultService service;

    public ResultController(ResultService service) {
        this.service = service;
    }

    @PostMapping
    public Result save(@RequestBody Result result ){
        return service.save(result);
    }
    @GetMapping
    public List<Result> getAll(){
        return service.getAll();
    }
    @GetMapping("/user/{userId}")
    public List<Result> getByUser(@PathVariable Long userId) {
        return service.getUserResults(userId);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }

    @GetMapping("/leaderboard")
    public List<Result> getLeaderboard() {
        return service.getLeaderboard();
    }
}
