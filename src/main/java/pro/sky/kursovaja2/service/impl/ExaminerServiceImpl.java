package pro.sky.kursovaja2.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.kursovaja2.Question;
import pro.sky.kursovaja2.exception.LimitQuestionExeption;
import pro.sky.kursovaja2.service.api.ExaminerService;
import pro.sky.kursovaja2.service.api.QuestionService;

import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Set<Question> getQuestions(int amount) {
        Set<Question> questions = new HashSet<>();
        if (questionService.getAll().size() < amount){
            throw new LimitQuestionExeption("Превышен лимит вопросов, задайте меньшее количество вопросов");
        }
        while (questions.size() != amount) {
            questions.add(questionService.getRandomQuestion());
        }
        return questions;
    }
}
