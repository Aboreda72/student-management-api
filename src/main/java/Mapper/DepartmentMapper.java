package com.example.student.mapper;

import com.example.student.dto.DepartmentDTO;
import com.example.student.entity.Department;

public class DepartmentMapper {

    public static Department toEntity(DepartmentDTO dto) {

        Department department = new Department();

        department.setDepartmentName(dto.getDepartmentName());
        department.setLocation(dto.getLocation());

        return department;
    }
}