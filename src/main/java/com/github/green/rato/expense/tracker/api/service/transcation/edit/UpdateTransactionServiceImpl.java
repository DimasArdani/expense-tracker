package com.github.green.rato.expense.tracker.api.service.transcation.edit;

import com.github.green.rato.expense.tracker.api.model.TransactionDTO;
import com.github.green.rato.expense.tracker.api.repository.TransactionRepository;
import com.github.green.rato.expense.tracker.api.service.transcation.create.CreateTransactionInput;
import com.github.green.rato.expensetracker.jooq.tables.pojos.Transactions;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UpdateTransactionServiceImpl implements UpdateTransactionService {
    private final TransactionRepository transactionRepository;

    @Override
    public UpdateTransactionOutput serve(String id, UpdateTransactionInput input) {
        Transactions transaction = transactionRepository.getById(UUID.fromString(id))
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        TransactionDTO updatedData = buildData(transaction, input);
        Transactions data = transactionRepository.edit(transaction.id(), updatedData);
        return buildResponse(data);
    }

    @Override
    public UpdateTransactionOutput delete(String id) {
        UpdateTransactionInput input = deleteRequest(id);
        return serve(id, input);
    }

    private UpdateTransactionInput deleteRequest(String id) {
        Transactions transaction = transactionRepository.getById(UUID.fromString(id))
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        return UpdateTransactionInput.builder()
                .category(transaction.category())
                .tagId(transaction.tagId())
                .description(transaction.description())
                .amount(transaction.amount())
                .status(transaction.status())
                .build();
    }

    private UpdateTransactionOutput buildResponse(Transactions updatedData) {
        return UpdateTransactionOutput.builder()
                .id(updatedData.id())
                .updatedAt(updatedData.updatedDate())
                .build();
    }

    private TransactionDTO buildData(Transactions transaction, UpdateTransactionInput input) {
        return TransactionDTO.builder()
                .id(transaction.id())
                .category(input.category())
                .tagId(input.tagId())
                .description(input.description())
                .amount(input.amount())
                .status(input.status())
                .createdDate(transaction.createdDate())
                .updatedDate(OffsetDateTime.now())
                .build();
    }

}
