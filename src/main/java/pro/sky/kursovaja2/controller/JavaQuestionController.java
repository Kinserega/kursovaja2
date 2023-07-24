package pro.sky.kursovaja2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.kursovaja2.Question;
import pro.sky.kursovaja2.service.api.QuestionService;

import java.util.Set;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }
    @GetMapping(path = "/add")
    public Question addQuestion(@RequestParam("q") String question,
                                @RequestParam("a") String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping(path = "/remove")
    public Question removeQuestion(@RequestParam("q") String question,
                                   @RequestParam("a") String answer) {
        return questionService.remove(question, answer);
    }

    @GetMapping
    public Set<Question> getQuestions(){
        return questionService.getAll();
    }
}
