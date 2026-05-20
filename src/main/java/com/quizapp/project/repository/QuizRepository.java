package com.quizapp.project.repository;

import com.quizapp.project.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuizRepository extends JpaRepository<Quiz,Long> {
    Optional<Quiz> findByCategory(String category);
}
