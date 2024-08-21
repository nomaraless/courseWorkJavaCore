package com.example.nomaralessnomad.controllers;

import com.example.nomaralessnomad.repositorys.QuestionRepository;
import com.example.nomaralessnomad.services.JavaQuestionServiceImpl;
import com.example.nomaralessnomad.services.Question;
import com.example.nomaralessnomad.interfaces.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/demo")
public class JavaQuestionController {
    private final QuestionRepository repository;

    private final QuestionService service;
    private JavaQuestionController(@Qualifier("javaQuestionServiceImpl") QuestionService service, QuestionRepository repository) {
        this.service = service;
        this.repository = repository;
    }


    @GetMapping(path = "/add")
    public Question add(@RequestParam(value = "question") String questionText,
                        @RequestParam(value = "answer") String answer) {
        return service.add(questionText, answer);
    }

    @GetMapping(path = "/remove")
    public Question remove(@RequestParam(value = "question") String questionText,
                           @RequestParam(value = "answer") String answer) {
        Question question = new Question(questionText, answer);
        return service.remove(question);
    }


    @GetMapping(path = "/all")
    public Collection<Question> all() {
        return service.getAll();
    }
}
