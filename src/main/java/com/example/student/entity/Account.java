package com.example.student.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "accounts")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    private String accountStatus;

    private Double balance;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
