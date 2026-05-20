package com.quizapp.project.services.interfaces;

import com.quizapp.project.model.Question;

import java.util.List;

public interface QuestionService {
    Question add(Question question);
    Question update(Long id,Question question);
    void delete(Long id);
    List<Question> getAll();
    List<Question> getByQuiz(Long quizId);
}
