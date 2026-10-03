package com.github.green.rato.expense.tracker.api.service.transcation.create;

public record CreateTransactionInput(
    String description,
    double amount,
    String category
) {
}
