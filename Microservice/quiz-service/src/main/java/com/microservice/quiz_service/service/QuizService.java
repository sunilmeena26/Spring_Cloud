package com.microservice.quiz_service.service;


import com.microservice.quiz_service.dao.QuizDao;
import com.microservice.quiz_service.feign.QuizInterface;
import com.microservice.quiz_service.model.QuestionWrapper;
import com.microservice.quiz_service.model.Quiz;
import com.microservice.quiz_service.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        //call the generate url - RestTemplate  http://localhost:8080/question/generate to connect the one service to another service we need two thing 1. Feign Client  2. Service Discovery(Eureka Server)
        List<Integer> questions=quizInterface.getQuestionForQuiz(category,numQ).getBody();
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        quizDao.save(quiz);
       return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }


    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {
         Quiz quiz=quizDao.findById(id).get();
        List<Integer> questionsIds=quiz.getQuestionIds();
        ResponseEntity<List<QuestionWrapper>> questions=quizInterface.getQuestionsFormId(questionsIds);
        return questions;
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
         ResponseEntity<Integer> score=quizInterface.getScore(responses);
        return score;
    }
}
