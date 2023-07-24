package pro.sky.kursovaja2.service.api;

import pro.sky.kursovaja2.Question;

import java.util.Set;

public interface QuestionService {
    Question add(String question, String answer);
    Question remove(String question, String answer);

    Set<Question> getAll();

    Question getRandomQuestion();
}
