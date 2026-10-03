package com.github.green.rato.expense.tracker.api.controller;

import com.github.green.rato.expense.tracker.api.service.transcation.create.CreateTransactionInput;
import com.github.green.rato.expense.tracker.api.service.transcation.create.CreateTransactionOutput;
import com.github.green.rato.expense.tracker.api.service.transcation.create.CreateTransactionService;
import com.github.green.rato.expense.tracker.api.service.transcation.list.ListTransactionOutput;
import com.github.green.rato.expense.tracker.api.service.transcation.list.ListTransactionService;
import com.github.green.rato.expense.tracker.api.web.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final CreateTransactionService createTransactionService;
    private final ListTransactionService listTransactionService;

    @PostMapping()
    public ApiResponse<CreateTransactionOutput> addTransaction(@RequestBody CreateTransactionInput input) {
        return ApiResponse.success(createTransactionService.serve(input), "SUCCESS");
    }

    @GetMapping()
    public ApiResponse<ListTransactionOutput> getTransactions(@RequestParam(required = false) String userId) {
        return ApiResponse.success(listTransactionService.getPage(), "SUCCESS");
    }

}
