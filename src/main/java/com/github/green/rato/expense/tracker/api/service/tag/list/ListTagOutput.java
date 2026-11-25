package com.github.green.rato.expense.tracker.api.service.tag.list;

import lombok.Builder;

import java.time.OffsetDateTime;
import java.util.UUID;

@Builder
public record ListTagOutput(
    UUID id,
    String name,
    String status,
    OffsetDateTime createdAt,
    OffsetDateTime updatedAt
) {
}
