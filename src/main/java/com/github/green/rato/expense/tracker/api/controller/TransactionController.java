package com.github.green.rato.expense.tracker.api.controller;

import com.github.green.rato.expense.tracker.api.common.ResponseMessage;
import com.github.green.rato.expense.tracker.api.service.transcation.create.CreateTransactionInput;
import com.github.green.rato.expense.tracker.api.service.transcation.create.CreateTransactionOutput;
import com.github.green.rato.expense.tracker.api.service.transcation.create.CreateTransactionService;
import com.github.green.rato.expense.tracker.api.service.transcation.edit.UpdateTransactionInput;
import com.github.green.rato.expense.tracker.api.service.transcation.edit.UpdateTransactionOutput;
import com.github.green.rato.expense.tracker.api.service.transcation.edit.UpdateTransactionService;
import com.github.green.rato.expense.tracker.api.service.transcation.list.ListTransactionOutput;
import com.github.green.rato.expense.tracker.api.service.transcation.list.ListTransactionService;
import com.github.green.rato.expense.tracker.api.web.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final CreateTransactionService createTransactionService;
    private final ListTransactionService listTransactionService;
    private final UpdateTransactionService updateTransactionService;

    @PostMapping()
    public ResponseEntity<ApiResponse<CreateTransactionOutput>> addTransaction(@RequestBody CreateTransactionInput input) {
        return new ResponseEntity<>(ApiResponse.success(createTransactionService.serve(input), ResponseMessage.SUCCESS_CREATED.getMessage()), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<ApiResponse<List<ListTransactionOutput>>> getTransactions(
                                                                    @RequestParam(required = false) Integer page,
                                                                    @RequestParam(required = false) Integer size) {
        return ResponseEntity.ok(ApiResponse.success(listTransactionService.getPage(page, size), ResponseMessage.SUCCESS_FETCHED.getMessage()));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<UpdateTransactionOutput>> editTransaction(@PathVariable String id, @RequestBody UpdateTransactionInput input) {
        return ResponseEntity.ok(ApiResponse.success(updateTransactionService.serve(id, input), ResponseMessage.SUCCESS_UPDATED.getMessage()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<UpdateTransactionOutput>> deleteTransaction(@PathVariable String id) {
        return new ResponseEntity<>(ApiResponse.success(updateTransactionService.delete(id), ResponseMessage.SUCCESS_DELETED.getMessage()), HttpStatus.NO_CONTENT);
    }

}
