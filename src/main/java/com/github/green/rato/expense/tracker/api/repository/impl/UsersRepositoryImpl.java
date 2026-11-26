package com.github.green.rato.expense.tracker.api.repository.impl;

import com.github.green.rato.expense.tracker.api.model.UsersDTO;
import com.github.green.rato.expense.tracker.api.repository.UsersRepository;
import com.github.green.rato.expensetracker.jooq.tables.pojos.Users;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;


import java.util.Optional;

import static com.github.green.rato.expensetracker.jooq.tables.Users.USERS;

@Repository
public class UsersRepositoryImpl implements UsersRepository {

    private final DSLContext dsl;
    public UsersRepositoryImpl(DSLContext create) {
        this.dsl = create;
    }


    @Override
    public Users save(UsersDTO dto) {
        return dsl.insertInto(USERS)
                .set(USERS.USERNAME, dto.username())
                .set(USERS.PASSWORD_HASH, dto.passwordHash())
                .returning()
                .fetchSingleInto(Users.class);
    }

    @Override
    public Optional<Users> findByUsername(String username) {
        return dsl.selectFrom(USERS)
                .where(USERS.USERNAME.eq(username))
                .fetchOptionalInto(Users.class);
    }

    @Override
    public Optional<Users> login(String username, String password) {
        return dsl.selectFrom(USERS)
                .where(USERS.USERNAME.eq(username))
                .and(USERS.PASSWORD_HASH.eq(password))
                .fetchOptionalInto(Users.class);
    }
}
