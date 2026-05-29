package com.example.student.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "departments")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;

    private String departmentName;

    private String location;

    @JsonIgnore
    @OneToMany(mappedBy = "department")
    private List<Student> students;

    @JsonIgnore
    @OneToMany(mappedBy = "department")
    private List<Course> courses;
}