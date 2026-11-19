package com.github.green.rato.expense.tracker.api.repository;

import com.github.green.rato.expense.tracker.api.model.TransactionDTO;
import com.github.green.rato.expensetracker.jooq.tables.pojos.Transactions;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TransactionRepository {
    Transactions save(TransactionDTO transactions);
    List<Transactions> findAll();
    Transactions edit(UUID id, TransactionDTO transactions);
    Transactions delete(UUID id);
    Transactions hardDelete(UUID id);
    Optional<Transactions> getById(UUID id);
}
