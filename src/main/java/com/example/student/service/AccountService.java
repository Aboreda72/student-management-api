package com.example.student.service;

import com.example.student.dto.AccountDTO;
import com.example.student.entity.Account;

import java.util.List;

public interface AccountService {

    List<Account> getAll();

    Account getById(Long id);

    Account create(AccountDTO dto);

    Account update(Long id, AccountDTO dto);

    String delete(Long id);
}