package com.github.green.rato.expense.tracker.api.service.transcation.list;

import java.util.List;

public interface ListTransactionService {
    List<ListTransactionOutput> getPage(Integer page, Integer size);
}
