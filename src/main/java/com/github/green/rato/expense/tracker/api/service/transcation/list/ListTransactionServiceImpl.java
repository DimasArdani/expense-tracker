package com.github.green.rato.expense.tracker.api.service.transcation.list;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ListTransactionServiceImpl implements ListTransactionService{

    @Override
    public ListTransactionOutput getPage() {
        return null;
    }
}
