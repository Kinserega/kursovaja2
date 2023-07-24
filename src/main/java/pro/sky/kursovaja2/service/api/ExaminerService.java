package pro.sky.kursovaja2.service.api;

import pro.sky.kursovaja2.Question;

import java.util.Set;

public interface ExaminerService {
    Set<Question> getQuestions(int amount);
}
