package com.exercise.basic_CRUD_mongo.global.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.exercise.basic_CRUD_mongo.global.dto.MessageDto;

@RestControllerAdvice
public class GlobalExceptions {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<MessageDto> throwNotFoundException(ResourceNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(new MessageDto(HttpStatus.NOT_FOUND, e.getMessage())); 
    } 
}
