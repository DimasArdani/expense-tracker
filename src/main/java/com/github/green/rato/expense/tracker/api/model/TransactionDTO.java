package com.github.green.rato.expense.tracker.api.model;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Builder
public record TransactionDTO(
        UUID id,
        String category,
        UUID tagId,
        String description,
        BigDecimal amount,
        OffsetDateTime createdDate,
        OffsetDateTime updatedDate,
        String status
) { }
