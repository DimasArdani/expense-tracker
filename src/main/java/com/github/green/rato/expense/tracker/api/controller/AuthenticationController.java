package com.github.green.rato.expense.tracker.api.controller;

import com.github.green.rato.expense.tracker.api.common.ResponseMessage;
import com.github.green.rato.expense.tracker.api.service.authentication.login.LoginService;
import com.github.green.rato.expense.tracker.api.service.authentication.login.LoginServiceInput;
import com.github.green.rato.expense.tracker.api.service.authentication.login.LoginServiceOutput;
import com.github.green.rato.expense.tracker.api.web.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final LoginService loginService;

    @PostMapping()
    public ResponseEntity<ApiResponse<LoginServiceOutput>> login(@RequestBody LoginServiceInput input, HttpServletRequest request, HttpServletResponse response) {
        return new ResponseEntity<>(ApiResponse.success(loginService.serve(input, request, response), ResponseMessage.LOGIN.getMessage()), HttpStatus.OK);
    }
}
