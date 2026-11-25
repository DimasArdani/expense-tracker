package com.github.green.rato.expense.tracker.api.service.transcation.edit;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
public record UpdateTransactionInput(
        BigDecimal amount,
        String category,
        String description,
        String status,
        UUID tagId
) {
}
