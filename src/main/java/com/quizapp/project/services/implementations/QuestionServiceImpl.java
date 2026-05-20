package com.quizapp.project.services.implementations;

import com.quizapp.project.model.Question;
import com.quizapp.project.repository.QuestionRepository;
import com.quizapp.project.services.interfaces.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository repo;

    public QuestionServiceImpl(QuestionRepository repo) {
        this.repo = repo;
    }

    @Override
    public Question add(Question question) {
        return repo.save(question);
    }

    @Override
    public Question update(Long id, Question question) {
        Question exist = repo.findById(id).orElseThrow(()->new RuntimeException("Question not found"));
        exist.setQuestionText(question.getQuestionText());
        exist.setOptionA(question.getOptionA());
        exist.setOptionB(question.getOptionB());
        exist.setOptionC(question.getOptionC());
        exist.setOptionD(question.getOptionD());
        exist.setCorrectAnswer(question.getCorrectAnswer());
        exist.setQuiz(question.getQuiz());
        return repo.save(exist);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Question> getAll() {
        return repo.findAll();
    }

    @Override
    public List<Question> getByQuiz(Long quizId) {
        return repo.findByQuizId(quizId);
    }
}
