package com.example.student.service;

import com.example.student.dto.EnrollmentDTO;
import com.example.student.entity.Enrollment;

import java.util.List;

public interface EnrollmentService {

    List<Enrollment> getAll();

    Enrollment enroll(EnrollmentDTO dto);

    String delete(Long id);
}