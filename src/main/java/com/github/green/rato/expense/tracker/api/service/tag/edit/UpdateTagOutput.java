package com.github.green.rato.expense.tracker.api.service.tag.edit;

import lombok.Builder;

import java.time.OffsetDateTime;
import java.util.UUID;

@Builder
public record UpdateTagOutput(
        UUID id,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt
) {
}
