package com.telusko.quizapp.service;

import com.telusko.quizapp.dao.QuestionDao;
import com.telusko.quizapp.dao.QuizDao;
import com.telusko.quizapp.model.Question;
import com.telusko.quizapp.model.QuestionWrapper;
import com.telusko.quizapp.model.Quiz;
import com.telusko.quizapp.model.Response;
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
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> question=questionDao.findRandomQuestionsByCategory(category,numQ);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestion(question);
        quizDao.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }


    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {
        Optional<Quiz> quiz=quizDao.findById(id);
        List<Question> questionsFromDb=quiz.get().getQuestion();
        List<QuestionWrapper> questionForUser=new ArrayList<>();
        for(Question Qw:questionsFromDb){
            QuestionWrapper qw=new QuestionWrapper(Qw.getId(),Qw.getQuestion_title(),Qw.getOption1(),Qw.getOption2(),Qw.getOption3(),Qw.getOption4());
            questionForUser.add(qw);
        }

        return new ResponseEntity<>(questionForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz=quizDao.findById(id).get();
        List<Question> questions=quiz.getQuestion();
        int right=0;
        int i=0;
        for(Response response:responses){
          if(response.getResponse().equals(questions.get(i).getRight_answer()))
              right++;
              i++;
        }
        return new ResponseEntity<>(right,HttpStatus.OK);
    }
}
