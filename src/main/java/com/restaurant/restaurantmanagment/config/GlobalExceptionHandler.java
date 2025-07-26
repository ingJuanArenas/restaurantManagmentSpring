package com.restaurant.restaurantmanagment.config;



import java.nio.file.AccessDeniedException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.restaurant.restaurantmanagment.exceptions.AlreadyExistException;
import com.restaurant.restaurantmanagment.exceptions.NotFoundException;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiErrorMessage> handleNotFound(NotFoundException ex, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                 .body( new ApiErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage(), request.getRequestURI().toString()));
    }

    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<ApiErrorMessage> handleAlreadyExists(AlreadyExistException ex, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
             .body(new ApiErrorMessage(HttpStatus.CONFLICT,ex.getMessage(),request.getRequestURI().toString()));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiErrorMessage> handleRunTimeException(RuntimeException ex, HttpServletRequest request) {
         log.info(ex.getClass().getName());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), request.getRequestURI().toString()));
    }


     @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorMessage> handleException(Exception ex, HttpServletRequest request) {
         log.info(ex.getClass().getName());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), request.getRequestURI().toString()));
    }

         @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiErrorMessage> handleAccessDeniedException(AccessDeniedException ex, HttpServletRequest request) {
         log.info(ex.getClass().getName());
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(new ApiErrorMessage(HttpStatus.FORBIDDEN, ex.getMessage(), request.getRequestURI().toString()));
    }
    
    

    

}
