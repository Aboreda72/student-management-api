package com.example.student.service.impl;

import com.example.student.dto.DepartmentDTO;
import com.example.student.entity.Department;
import com.example.student.exception.DepartmentNotFoundException;
import com.example.student.mapper.DepartmentMapper;
import com.example.student.repository.DepartmentRepository;
import com.example.student.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl
        implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(
            DepartmentRepository departmentRepository) {

        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> getAllDepartments() {

        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) {

        return departmentRepository.findById(id)
                .orElseThrow(() ->
                        new DepartmentNotFoundException(
                                "Department not found with id: "
                                        + id
                        ));
    }

    @Override
    public Department createDepartment(
            DepartmentDTO dto) {

        Department department =
                DepartmentMapper.toEntity(dto);

        return departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(
            Long id,
            DepartmentDTO dto) {

        Department department =
                departmentRepository.findById(id)
                        .orElseThrow(() ->
                                new DepartmentNotFoundException(
                                        "Department not found with id: "
                                                + id
                                ));

        department.setDepartmentName(
                dto.getDepartmentName()
        );

        department.setLocation(
                dto.getLocation()
        );

        return departmentRepository.save(department);
    }

    @Override
    public String deleteDepartment(Long id) {

        if (!departmentRepository.existsById(id)) {

            throw new DepartmentNotFoundException(
                    "Department not found with id: "
                            + id
            );
        }

        departmentRepository.deleteById(id);

        return "Department deleted successfully";
    }
}