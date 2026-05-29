package com.example.student.controller;

import com.example.student.dto.CourseDTO;
import com.example.student.entity.Course;
import com.example.student.service.CourseService;
import com.example.student.shared.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ApiResponse<List<Course>> getAll() {
        return new ApiResponse<>(true, "Courses fetched", courseService.getAllCourses());
    }

    @GetMapping("/{id}")
    public ApiResponse<Course> getById(@PathVariable Long id) {
        return new ApiResponse<>(true, "Course fetched", courseService.getCourseById(id));
    }

    @PostMapping
    public ApiResponse<Course> create(@Valid @RequestBody CourseDTO dto) {
        return new ApiResponse<>(true, "Created", courseService.createCourse(dto));
    }

    @PutMapping("/{id}")
    public ApiResponse<Course> update(@PathVariable Long id,
                                      @Valid @RequestBody CourseDTO dto) {
        return new ApiResponse<>(true, "Updated", courseService.updateCourse(id, dto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(@PathVariable Long id) {
        return new ApiResponse<>(true, courseService.deleteCourse(id), null);
    }
}