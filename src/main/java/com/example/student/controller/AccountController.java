package com.example.student.controller;

import com.example.student.dto.AccountDTO;
import com.example.student.entity.Account;
import com.example.student.service.AccountService;
import com.example.student.shared.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ApiResponse<List<Account>> getAll() {
        return new ApiResponse<>(true, "OK", accountService.getAll());
    }

    @PostMapping
    public ApiResponse<Account> create(@Valid @RequestBody AccountDTO dto) {
        return new ApiResponse<>(true, "Created", accountService.create(dto));
    }
}