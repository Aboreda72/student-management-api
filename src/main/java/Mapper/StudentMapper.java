package com.example.student.mapper;

import com.example.student.dto.StudentDTO;
import com.example.student.entity.Student;

public class StudentMapper {

    public static Student toEntity(StudentDTO dto) {

        Student student = new Student();

        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setAge(dto.getAge());

        return student;
    }
}