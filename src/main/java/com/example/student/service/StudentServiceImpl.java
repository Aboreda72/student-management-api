package com.example.student.service.impl;

import com.example.student.dto.StudentDTO;
import com.example.student.entity.Student;
import com.example.student.exception.StudentNotFoundException;
import com.example.student.mapper.StudentMapper;
import com.example.student.repository.StudentRepository;
import com.example.student.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {

        return studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException(
                                "Student not found with id: " + id
                        ));
    }

    @Override
    public Student createStudent(StudentDTO dto) {

        Student student = StudentMapper.toEntity(dto);

        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long id, StudentDTO dto) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException(
                                "Student not found with id: " + id
                        ));

        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setAge(dto.getAge());

        return studentRepository.save(student);
    }

    @Override
    public String deleteStudent(Long id) {

        if (!studentRepository.existsById(id)) {

            throw new StudentNotFoundException(
                    "Student not found with id: " + id
            );
        }

        studentRepository.deleteById(id);

        return "Student deleted successfully";
    }
}