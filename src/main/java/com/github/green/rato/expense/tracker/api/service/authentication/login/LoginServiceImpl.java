package com.github.green.rato.expense.tracker.api.service.authentication.login;

import com.github.green.rato.expense.tracker.api.repository.UsersRepository;
import com.github.green.rato.expensetracker.jooq.tables.pojos.Users;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginServiceImpl implements LoginService{

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public LoginServiceOutput serve(LoginServiceInput input, HttpServletRequest request, HttpServletResponse response) {
        Users users = usersRepository.findByUsername(input.username())
                .orElseThrow(() -> new BadCredentialsException("Invalid username or password"));
        if (!passwordEncoder.matches(input.password(), users.passwordHash())) {throw new BadCredentialsException("Invalid username or password");}
        CreateSession(users, request, response);
        return buildOutput(users);
    }

    private void CreateSession(Users users, HttpServletRequest request, HttpServletResponse response) {
        HttpSession previousSessions =  request.getSession(false);
        if (previousSessions != null) {previousSessions.invalidate();}
        UsernamePasswordAuthenticationToken authentication = UsernamePasswordAuthenticationToken.authenticated(
                users.id().toString(),
                null,
                List.of(new SimpleGrantedAuthority("ROLE_USER"))
        );
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authentication);
        SecurityContextHolder.setContext(context);
        new HttpSessionSecurityContextRepository().saveContext(context, request, response);
    }

    private LoginServiceOutput buildOutput(Users users) {
        return LoginServiceOutput.builder()
                .id(users.id())
                .username(users.username())
                .createdAt(users.createdDate())
                .build();
    }
}
