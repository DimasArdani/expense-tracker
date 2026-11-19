package com.github.green.rato.expense.tracker.api.service.transcation.create;

import lombok.Builder;

import java.time.OffsetDateTime;
import java.util.UUID;

@Builder
public record CreateTransactionOutput(
    UUID id,
    OffsetDateTime createdAt
) {
}
