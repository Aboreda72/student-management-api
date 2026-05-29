package com.example.student.controller;

import com.example.student.dto.StudentDTO;
import com.example.student.entity.Student;
import com.example.student.service.StudentService;
import com.example.student.shared.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ApiResponse<List<Student>> getAllStudents() {

        return new ApiResponse<>(
                true,
                "Students fetched successfully",
                studentService.getAllStudents()
        );
    }

    @GetMapping("/{id}")
    public ApiResponse<Student> getStudentById(@PathVariable Long id) {

        return new ApiResponse<>(
                true,
                "Student fetched successfully",
                studentService.getStudentById(id)
        );
    }

    @PostMapping
    public ApiResponse<Student> createStudent(
            @Valid @RequestBody StudentDTO dto) {

        return new ApiResponse<>(
                true,
                "Student created successfully",
                studentService.createStudent(dto)
        );
    }

    @PutMapping("/{id}")
    public ApiResponse<Student> updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody StudentDTO dto) {

        return new ApiResponse<>(
                true,
                "Student updated successfully",
                studentService.updateStudent(id, dto)
        );
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteStudent(
            @PathVariable Long id) {

        return new ApiResponse<>(
                true,
                studentService.deleteStudent(id),
                null
        );
    }
}