package com.github.green.rato.expense.tracker.api.service.transcation.create;

import com.github.green.rato.expense.tracker.api.model.TransactionDTO;
import com.github.green.rato.expense.tracker.api.repository.TransactionRepository;
import com.github.green.rato.expensetracker.jooq.tables.pojos.Transactions;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateTransactionServiceImpl implements CreateTransactionService {
    private final TransactionRepository transactionRepository;

    @Override
    public CreateTransactionOutput serve(CreateTransactionInput input) {
        TransactionDTO transactions = buildData(input);
        Transactions data = transactionRepository.save(transactions);
        return buildResponse(data);
    }

    private CreateTransactionOutput buildResponse(Transactions data) {
        return CreateTransactionOutput.builder()
                .id(data.id())
                .createdAt(data.createdDate())
                .build();
    }

    private TransactionDTO buildData(CreateTransactionInput input) {
        return TransactionDTO.builder()
                .description(input.description())
                .amount(input.amount())
                .category(input.category())
                .tagId(input.tagId())
                .build();
    }
}
