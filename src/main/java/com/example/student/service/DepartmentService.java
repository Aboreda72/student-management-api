package com.example.student.service;

import com.example.student.dto.DepartmentDTO;
import com.example.student.entity.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> getAllDepartments();

    Department getDepartmentById(Long id);

    Department createDepartment(DepartmentDTO dto);

    Department updateDepartment(Long id,
                                DepartmentDTO dto);

    String deleteDepartment(Long id);
}