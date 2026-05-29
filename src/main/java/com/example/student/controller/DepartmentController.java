package com.example.student.controller;

import com.example.student.dto.DepartmentDTO;
import com.example.student.entity.Department;
import com.example.student.service.DepartmentService;
import com.example.student.shared.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(
            DepartmentService departmentService) {

        this.departmentService = departmentService;
    }

    @GetMapping
    public ApiResponse<List<Department>>
    getAllDepartments() {

        return new ApiResponse<>(
                true,
                "Departments fetched successfully",
                departmentService.getAllDepartments()
        );
    }

    @GetMapping("/{id}")
    public ApiResponse<Department>
    getDepartmentById(@PathVariable Long id) {

        return new ApiResponse<>(
                true,
                "Department fetched successfully",
                departmentService.getDepartmentById(id)
        );
    }

    @PostMapping
    public ApiResponse<Department>
    createDepartment(
            @Valid @RequestBody DepartmentDTO dto) {

        return new ApiResponse<>(
                true,
                "Department created successfully",
                departmentService.createDepartment(dto)
        );
    }

    @PutMapping("/{id}")
    public ApiResponse<Department>
    updateDepartment(
            @PathVariable Long id,
            @Valid @RequestBody DepartmentDTO dto) {

        return new ApiResponse<>(
                true,
                "Department updated successfully",
                departmentService.updateDepartment(
                        id,
                        dto
                )
        );
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String>
    deleteDepartment(@PathVariable Long id) {

        return new ApiResponse<>(
                true,
                departmentService.deleteDepartment(id),
                null
        );
    }
}