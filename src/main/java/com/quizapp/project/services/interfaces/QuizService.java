package com.quizapp.project.services.interfaces;

import com.quizapp.project.model.Question;
import com.quizapp.project.model.Quiz;

import java.util.List;

public interface QuizService {
    List<Question> startQuiz(String category);
    Quiz create(Quiz quiz);
    List<Quiz> getAll();
    void delete(Long id);
}
