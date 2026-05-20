package com.quizapp.project.services.interfaces;

import com.quizapp.project.model.Result;

import java.util.List;

public interface ResultService {
    Result save(Result result);
    List<Result>getUserResults(Long userId);
    List<Result> getAll();

    List<Result> getLeaderboard();

    void delete(Long id);
}
