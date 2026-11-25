package com.github.green.rato.expense.tracker.api.service.transcation.edit;

import lombok.Builder;

import java.time.OffsetDateTime;
import java.util.UUID;

@Builder
public record UpdateTransactionOutput(
        UUID id,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt
) {
}
