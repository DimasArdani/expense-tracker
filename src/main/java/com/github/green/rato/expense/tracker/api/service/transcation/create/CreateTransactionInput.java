package com.github.green.rato.expense.tracker.api.service.transcation.create;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
public record CreateTransactionInput(
    BigDecimal amount,
    String category,
    String description,
    UUID tagId
) {
}
