package com.github.green.rato.expense.tracker.api.service.users.create;

import lombok.Builder;

import java.time.OffsetDateTime;
import java.util.UUID;

@Builder
public record CreateUsersOutput(
        UUID id,
        OffsetDateTime createdAt
) {
}
