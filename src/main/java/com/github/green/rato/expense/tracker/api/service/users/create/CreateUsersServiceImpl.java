package com.github.green.rato.expense.tracker.api.service.users.create;


import com.github.green.rato.expense.tracker.api.model.UsersDTO;
import com.github.green.rato.expense.tracker.api.repository.UsersRepository;
import com.github.green.rato.expensetracker.jooq.tables.pojos.Users;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CreateUsersServiceImpl implements CreateUsersService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public CreateUsersOutput serve(CreateUsersInput input) {
        UsersDTO dto = buildData(input);
        Users users = usersRepository.save(dto);
        return buildOutput(users);
    }

    private CreateUsersOutput buildOutput(Users users) {
        return CreateUsersOutput.builder()
                .id(users.id())
                .createdAt(users.createdDate())
                .build();
    }

    private UsersDTO buildData(CreateUsersInput input) {
        return UsersDTO.builder()
                .username(input.username())
                .passwordHash(passwordEncoder.encode(input.password()))
                .build();
    }
}
