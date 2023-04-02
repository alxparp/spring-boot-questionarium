package com.questionarium.api;

import com.questionarium.model.Question;
import com.questionarium.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/question")
@RestController
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public void saveQuestion(@RequestBody Question question) {
        questionService.save(question);
    }

    @GetMapping
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping(path = "{id}")
    public Question getQuestionById(@PathVariable("id") int id) {
        return questionService.getQuestionById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteQuestionById(@PathVariable("id") Integer id) {
        questionService.deleteQuestionById(id);
    }

    @PutMapping(path = "{id}")
    public void updateQuestion(@PathVariable("id") Integer id, @RequestBody Question question) {
        questionService.updateQuestion(id, question);
    }

    @GetMapping(path = "topic/{topic}")
    public Question getRndQuestionByTopic(@PathVariable("topic") String topic) {
        return questionService.getRndQuestionByTopic(topic)
                .orElse(null);
    }

}
