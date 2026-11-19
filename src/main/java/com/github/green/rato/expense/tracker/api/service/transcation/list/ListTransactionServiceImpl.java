package com.github.green.rato.expense.tracker.api.service.transcation.list;

import com.github.green.rato.expense.tracker.api.repository.TransactionRepository;

import com.github.green.rato.expensetracker.jooq.tables.pojos.Transactions;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ListTransactionServiceImpl implements ListTransactionService{

    private final TransactionRepository transactionRepository;

    @Override
    public List<ListTransactionOutput> getPage(Integer page, Integer size) {
        List<Transactions> transactionOutputs = transactionRepository.findAll();
        return buildOutput(transactionOutputs);
    }

    private List<ListTransactionOutput> buildOutput(List<Transactions> transactionOutputs) {
        return transactionOutputs.stream()
                .map(this::convertToOutput)
                .collect(Collectors.toList());
    }

    private ListTransactionOutput convertToOutput(Transactions transaction) {
        return ListTransactionOutput.builder()
                .id(transaction.id())
                .amount(transaction.amount())
                .category(transaction.category())
                .tagId(transaction.tagId())
                .description(transaction.description())
                .createdAt(transaction.createdDate())
                .build();
    }
}
