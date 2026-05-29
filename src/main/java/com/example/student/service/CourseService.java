package com.example.student.service;

import com.example.student.dto.CourseDTO;
import com.example.student.entity.Course;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourses();

    Course getCourseById(Long id);

    Course createCourse(CourseDTO dto);

    Course updateCourse(Long id, CourseDTO dto);

    String deleteCourse(Long id);
}