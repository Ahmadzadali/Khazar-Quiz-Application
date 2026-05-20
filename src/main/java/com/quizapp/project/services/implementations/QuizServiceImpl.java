package com.quizapp.project.services.implementations;

import com.quizapp.project.model.Question;
import com.quizapp.project.model.Quiz;
import com.quizapp.project.repository.QuestionRepository;
import com.quizapp.project.repository.QuizRepository;
import com.quizapp.project.services.interfaces.QuizService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuizServiceImpl implements QuizService {
    private final QuizRepository repo;

    public QuizServiceImpl(QuizRepository repo) {
        this.repo = repo;
    }

    @Override
    @org.springframework.transaction.annotation.Transactional
    public List<Question> startQuiz(String category) {
        Quiz quiz  = repo.findByCategory(category).orElseThrow(()->new RuntimeException("Quiz not found"));
        return quiz.getQuestions();
    }

    @Override
    public Quiz create(Quiz quiz) {
        return repo.save(quiz);
    }

    @Override
    public List<Quiz> getAll() {
        return repo.findAll();
    }

    @Override
    public void delete(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Quiz not found with id " + id);
        }
    }
}
