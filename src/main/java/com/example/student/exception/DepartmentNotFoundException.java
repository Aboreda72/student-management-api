package com.example.student.exception;

public class DepartmentNotFoundException
        extends RuntimeException {

    public DepartmentNotFoundException(String message) {
        super(message);
    }
}