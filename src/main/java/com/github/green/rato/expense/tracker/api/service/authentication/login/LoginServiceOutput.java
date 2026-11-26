package com.github.green.rato.expense.tracker.api.service.authentication.login;

import lombok.Builder;

import java.time.OffsetDateTime;
import java.util.UUID;

@Builder
public record LoginServiceOutput (
        UUID id,
        String username,
        OffsetDateTime createdAt
){
}
