package com.quizapp.project.services.implementations;

import com.quizapp.project.model.Result;
import com.quizapp.project.repository.ResultRepository;
import com.quizapp.project.services.interfaces.ResultService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {
    private final ResultRepository repo;

    public ResultServiceImpl(ResultRepository repo) {
        this.repo = repo;
    }

    @Override
    public Result save(Result result) {
        return repo.save(result);
    }

    @Override
    public List<Result> getUserResults(Long userId) {
        return repo.findByUserId(userId);
    }

    @Override
    public List<Result> getAll() {
        return repo.findAll();
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Result> getLeaderboard() {
        return repo.findTop10ByOrderByScoreDesc();
    }
}
