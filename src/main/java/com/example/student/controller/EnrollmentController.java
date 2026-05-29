package com.example.student.controller;

import com.example.student.dto.EnrollmentDTO;
import com.example.student.entity.Enrollment;
import com.example.student.service.EnrollmentService;
import com.example.student.shared.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @GetMapping
    public ApiResponse<List<Enrollment>> getAll() {
        return new ApiResponse<>(true, "All enrollments", enrollmentService.getAll());
    }

    @PostMapping
    public ApiResponse<Enrollment> enroll(@Valid @RequestBody EnrollmentDTO dto) {
        return new ApiResponse<>(true, "Student enrolled", enrollmentService.enroll(dto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(@PathVariable Long id) {
        return new ApiResponse<>(true, enrollmentService.delete(id), null);
    }
}