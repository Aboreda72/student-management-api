package com.example.student.service;

import com.example.student.dto.StudentDTO;
import com.example.student.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student createStudent(StudentDTO dto);

    Student updateStudent(Long id, StudentDTO dto);

    String deleteStudent(Long id);
}