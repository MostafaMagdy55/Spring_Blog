package com.spring.blog.handelExceptions;

import com.spring.blog.exception.PostNotFoundException;
import com.spring.blog.exception.SpringBlogException;
import com.spring.blog.exception.UserNameCantBeNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class exceptionHandel {


    @ExceptionHandler
    public ResponseEntity<exceptionResponse> handleException(UserNameCantBeNull exc) {

        exceptionResponse error = new exceptionResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler
    public ResponseEntity<exceptionResponse> handleException(PostNotFoundException exc) {

        exceptionResponse error = new exceptionResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<exceptionResponse> handleException(SpringBlogException exc) {

        exceptionResponse error = new exceptionResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler
    public ResponseEntity<exceptionResponse> handleException(Exception exc) {

        exceptionResponse error = new exceptionResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }



}
