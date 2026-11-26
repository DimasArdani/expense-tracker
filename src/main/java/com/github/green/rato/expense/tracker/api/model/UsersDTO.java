package com.github.green.rato.expense.tracker.api.model;

import lombok.Builder;

import java.time.OffsetDateTime;
import java.util.UUID;

@Builder
public record UsersDTO (
        UUID id,
        String username,
        String passwordHash,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt
){
}
