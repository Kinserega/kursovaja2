package pro.sky.kursovaja2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.kursovaja2.service.api.ExaminerService;
import pro.sky.kursovaja2.service.api.QuestionService;
import pro.sky.kursovaja2.service.impl.ExaminerServiceImpl;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.HashSet;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {
    private ExaminerService examinerService;
    @Mock
    private QuestionService questionService;
    @BeforeEach
    public void SetUp(){
        examinerService = new ExaminerServiceImpl(questionService);
    }
    @Test
    public void getQuestionsTest(){
        Set<Question> questions= new HashSet<>();
        questions.add(new Question("WhatsApp?", "Ok"));
        questions.add(new Question("WhatsApp?", "Not bad"));

        Mockito.when(questionService.getAll()).thenReturn(questions);

        Question randomQuestion = new Question("WhatsApp?", "Ok");

        Mockito.when(questionService.getRandomQuestion()).thenReturn(randomQuestion);

        Set<Question> expected = new HashSet<>();
        expected.add(new Question("WhatsApp?", "Ok"));

        Set<Question> actual = examinerService.getQuestions(1);

        assertEquals(expected, actual);
    }

}
