package com.microservice.quiz_service.controller;


import com.microservice.quiz_service.model.QuestionWrapper;
import com.microservice.quiz_service.model.QuizDto;
import com.microservice.quiz_service.model.Response;
import com.microservice.quiz_service.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    //http://localhost:8080/quiz/create?category=Java&numQ=5&title=JQuiz
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto){
return quizService.createQuiz(quizDto.getCategory(),quizDto.getNumQ(),quizDto.getTitle());
    }

    //http://localhost:8080/quiz/get/2
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable Integer id){
return quizService.getQuizQuestion(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> response){
     return quizService.calculateResult(id,response);
    }
}
