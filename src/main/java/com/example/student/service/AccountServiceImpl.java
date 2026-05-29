package com.example.student.service.impl;

import com.example.student.dto.AccountDTO;
import com.example.student.entity.Account;
import com.example.student.entity.Student;
import com.example.student.exception.AccountNotFoundException;
import com.example.student.exception.StudentNotFoundException;
import com.example.student.repository.AccountRepository;
import com.example.student.repository.StudentRepository;
import com.example.student.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final StudentRepository studentRepository;

    public AccountServiceImpl(AccountRepository accountRepository,
                              StudentRepository studentRepository) {
        this.accountRepository = accountRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account getById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() ->
                        new AccountNotFoundException("Account not found"));
    }

    @Override
    public Account create(AccountDTO dto) {

        Student student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found"));

        Account account = new Account();
        account.setAccountStatus(dto.getAccountStatus());
        account.setBalance(dto.getBalance());
        account.setStudent(student);

        return accountRepository.save(account);
    }

    @Override
    public Account update(Long id, AccountDTO dto) {

        Account account = accountRepository.findById(id)
                .orElseThrow(() ->
                        new AccountNotFoundException("Account not found"));

        account.setAccountStatus(dto.getAccountStatus());
        account.setBalance(dto.getBalance());

        return accountRepository.save(account);
    }

    @Override
    public String delete(Long id) {

        if (!accountRepository.existsById(id)) {
            throw new AccountNotFoundException("Account not found");
        }

        accountRepository.deleteById(id);
        return "Account deleted";
    }
}