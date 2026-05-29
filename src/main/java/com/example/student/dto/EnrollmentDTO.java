package com.example.student.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EnrollmentDTO {

    @NotNull
    private Long studentId;

    @NotNull
    private Long courseId;

    private LocalDate enrollmentDate;

    private String grade;
}