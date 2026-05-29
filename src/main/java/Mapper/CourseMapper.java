package com.example.student.mapper;

import com.example.student.dto.CourseDTO;
import com.example.student.entity.Course;

public class CourseMapper {

    public static Course toEntity(CourseDTO dto) {

        Course course = new Course();

        course.setCourseName(dto.getCourseName());
        course.setCredits(dto.getCredits());

        return course;
    }
}