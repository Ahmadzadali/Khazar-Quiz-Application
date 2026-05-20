package com.quizapp.project.repository;

import com.quizapp.project.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Long> {
    List<Question> findByQuizId(Long quizId);
    List<Question> findTop5ByQuizId(Long quizId);
}
