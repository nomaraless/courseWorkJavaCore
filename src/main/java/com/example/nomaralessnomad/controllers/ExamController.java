package com.example.nomaralessnomad.controllers;

import com.example.nomaralessnomad.services.ExaminerServiceImpl;
import com.example.nomaralessnomad.services.MathQuestionService;
import com.example.nomaralessnomad.services.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
@RequestMapping("/exam")
public class ExamController {
    private ExaminerServiceImpl examinerService;
    private MathQuestionService mathQuestionService;

    @Autowired
    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping(path = "/getExam")
    public Collection<Question> get(@RequestParam(value = "a") Integer a) {
        return examinerService.getQuestions(a);
    }
}
