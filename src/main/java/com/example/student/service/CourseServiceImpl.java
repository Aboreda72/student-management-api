package com.example.student.service.impl;

import com.example.student.dto.CourseDTO;
import com.example.student.entity.Course;
import com.example.student.entity.Department;
import com.example.student.exception.CourseNotFoundException;
import com.example.student.exception.DepartmentNotFoundException;
import com.example.student.mapper.CourseMapper;
import com.example.student.repository.CourseRepository;
import com.example.student.repository.DepartmentRepository;
import com.example.student.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final DepartmentRepository departmentRepository;

    public CourseServiceImpl(CourseRepository courseRepository,
                             DepartmentRepository departmentRepository) {
        this.courseRepository = courseRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() ->
                        new CourseNotFoundException("Course not found with id: " + id));
    }

    @Override
    public Course createCourse(CourseDTO dto) {

        Department department = departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() ->
                        new DepartmentNotFoundException("Department not found"));

        Course course = CourseMapper.toEntity(dto);
        course.setDepartment(department);

        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Long id, CourseDTO dto) {

        Course course = courseRepository.findById(id)
                .orElseThrow(() ->
                        new CourseNotFoundException("Course not found"));

        Department department = departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() ->
                        new DepartmentNotFoundException("Department not found"));

        course.setCourseName(dto.getCourseName());
        course.setCredits(dto.getCredits());
        course.setDepartment(department);

        return courseRepository.save(course);
    }

    @Override
    public String deleteCourse(Long id) {

        if (!courseRepository.existsById(id)) {
            throw new CourseNotFoundException("Course not found");
        }

        courseRepository.deleteById(id);
        return "Course deleted successfully";
    }
}