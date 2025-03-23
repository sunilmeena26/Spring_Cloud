package com.microservice.quiz_service.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class QuizDto {

    String category;
    Integer numQ;
    String title;
}
