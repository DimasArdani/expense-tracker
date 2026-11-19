package com.github.green.rato.expense.tracker.api.service.transcation.list;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Builder
public record ListTransactionOutput(
        UUID id,
        String description,
        BigDecimal amount,
        String category,
        UUID tagId,
        OffsetDateTime createdAt
) {
}
