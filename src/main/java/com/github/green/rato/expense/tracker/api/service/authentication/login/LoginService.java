package com.github.green.rato.expense.tracker.api.service.authentication.login;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface LoginService {
    LoginServiceOutput serve(LoginServiceInput input, HttpServletRequest request, HttpServletResponse response);
}
