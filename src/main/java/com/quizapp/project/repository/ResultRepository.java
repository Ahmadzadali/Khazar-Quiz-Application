package com.quizapp.project.repository;

import com.quizapp.project.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepository  extends JpaRepository<Result,Long> {
    List<Result> findByUserId(Long userId);
    List<Result> findTop10ByOrderByScoreDesc();
}
