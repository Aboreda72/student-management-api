package com.example.student.service.impl;

import com.example.student.dto.EnrollmentDTO;
import com.example.student.entity.Course;
import com.example.student.entity.Enrollment;
import com.example.student.entity.Student;
import com.example.student.exception.CourseNotFoundException;
import com.example.student.exception.StudentNotFoundException;
import com.example.student.repository.CourseRepository;
import com.example.student.repository.EnrollmentRepository;
import com.example.student.repository.StudentRepository;
import com.example.student.service.EnrollmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository,
                                 StudentRepository studentRepository,
                                 CourseRepository courseRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Enrollment> getAll() {
        return enrollmentRepository.findAll();
    }

    @Override
    public Enrollment enroll(EnrollmentDTO dto) {

        Student student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new StudentNotFoundException("Student not found"));

        Course course = courseRepository.findById(dto.getCourseId())
                .orElseThrow(() -> new CourseNotFoundException("Course not found"));

        Enrollment enrollment = new Enrollment();

        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setEnrollmentDate(
                dto.getEnrollmentDate() != null
                        ? dto.getEnrollmentDate()
                        : java.time.LocalDate.now()
        );
        enrollment.setGrade(dto.getGrade());

        return enrollmentRepository.save(enrollment);
    }

    @Override
    public String delete(Long id) {

        enrollmentRepository.deleteById(id);
        return "Enrollment deleted";
    }
}