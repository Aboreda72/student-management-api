package com.example.student.exception;

import com.example.student.shared.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>>
    handleValidationErrors(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error ->
                        errors.put(
                                error.getField(),
                                error.getDefaultMessage()
                        )
                );

        return new ResponseEntity<>(
                errors,
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorResponse>
    handleStudentNotFound(StudentNotFoundException ex) {

        ErrorResponse error = new ErrorResponse(
                false,
                ex.getMessage(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(
                error,
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorResponse>
    handleDepartmentNotFound(DepartmentNotFoundException ex) {

        ErrorResponse error = new ErrorResponse(
                false,
                ex.getMessage(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(
                error,
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<ErrorResponse>
    handleCourseNotFound(CourseNotFoundException ex) {

        ErrorResponse error = new ErrorResponse(
                false,
                ex.getMessage(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(
                error,
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ErrorResponse>
    handleAccountNotFound(AccountNotFoundException ex) {

        ErrorResponse error = new ErrorResponse(
                false,
                ex.getMessage(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(
                error,
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse>
    handleGeneralException(Exception ex) {

        ErrorResponse error = new ErrorResponse(
                false,
                ex.getMessage(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(
                error,
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}