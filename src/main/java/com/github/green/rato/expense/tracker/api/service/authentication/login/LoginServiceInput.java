package com.github.green.rato.expense.tracker.api.service.authentication.login;


import jakarta.validation.constraints.NotBlank;

public record LoginServiceInput(
        @NotBlank(message = "Username cannot be empty")
        String username,
        @NotBlank(message = "Password cannot be empty")
        String password
) {
}
