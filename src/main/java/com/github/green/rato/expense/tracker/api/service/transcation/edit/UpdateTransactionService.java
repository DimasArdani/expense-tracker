package com.github.green.rato.expense.tracker.api.service.transcation.edit;


public interface UpdateTransactionService {
    UpdateTransactionOutput serve(String id, UpdateTransactionInput input);
    UpdateTransactionOutput delete(String id);
}
