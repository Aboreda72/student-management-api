package com.example.student.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDTO {

    @NotNull
    private String accountStatus;

    @NotNull
    private Double balance;

    @NotNull
    private Long studentId;
}