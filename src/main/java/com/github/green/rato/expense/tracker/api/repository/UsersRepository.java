package com.github.green.rato.expense.tracker.api.repository;

import com.github.green.rato.expense.tracker.api.model.UsersDTO;
import com.github.green.rato.expensetracker.jooq.tables.pojos.Users;

import java.util.Optional;

public interface UsersRepository {

    Users save(UsersDTO users);
    Optional<Users> findByUsername(String username);
    Optional<Users> login(String username, String password);
}
