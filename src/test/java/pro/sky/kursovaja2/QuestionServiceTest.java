package pro.sky.kursovaja2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.kursovaja2.service.api.QuestionService;
import pro.sky.kursovaja2.service.impl.QuestionServiceImpl;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionServiceTest {
    private QuestionService questionService;

    @BeforeEach
    public void setUp() {
        questionService = new QuestionServiceImpl();
    }

    @Test
    public void add() {
        Question question1 = new Question("WhatsApp?", "Ok");
        Set<Question> expected = new HashSet<>();
        expected.add(question1);
        questionService.add("WhatsApp?", "Ok");
        Set<Question> actual = questionService.getAll();
        assertEquals(expected, actual);
    }

    @Test
    public void remove() {
        Question question1 = new Question("WhatsApp?", "Ok");
        Set<Question> expected = new HashSet<>();
        expected.add(question1);
        questionService.add("WhatsApp?", "Ok");
        questionService.add("WhatsApp?", "Not bad");
        questionService.remove("WhatsApp?", "Not bad");
        Set<Question> actual = questionService.getAll();

        assertEquals(expected, actual);
    }


    @Test
    public void getAll() {
        Set<Question> expected = new HashSet<>();
        Set<Question> actual = questionService.getAll();
        assertEquals(expected, actual);
    }
}

