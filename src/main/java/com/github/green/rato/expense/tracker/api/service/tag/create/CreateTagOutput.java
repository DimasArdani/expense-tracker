package com.github.green.rato.expense.tracker.api.service.tag.create;

import lombok.Builder;

import java.time.OffsetDateTime;
import java.util.UUID;

@Builder
public record CreateTagOutput(
    UUID id,
    OffsetDateTime createdAt
) {
}
