package com.github.green.rato.expense.tracker.api.controller;

import com.github.green.rato.expense.tracker.api.common.ResponseMessage;
import com.github.green.rato.expense.tracker.api.service.tag.create.CreateTagInput;
import com.github.green.rato.expense.tracker.api.service.tag.create.CreateTagOutput;
import com.github.green.rato.expense.tracker.api.service.tag.create.CreateTagService;
import com.github.green.rato.expense.tracker.api.service.tag.edit.UpdateTagInput;
import com.github.green.rato.expense.tracker.api.service.tag.edit.UpdateTagOutput;
import com.github.green.rato.expense.tracker.api.service.tag.edit.UpdateTagService;
import com.github.green.rato.expense.tracker.api.service.tag.list.ListTagOutput;
import com.github.green.rato.expense.tracker.api.service.tag.list.ListTagService;
import com.github.green.rato.expense.tracker.api.web.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tag")
@RequiredArgsConstructor
public class TagController {

    private final CreateTagService createTagService;
    private final ListTagService listTagService;
    private final UpdateTagService updateTagService;

    @PostMapping()
    public ResponseEntity<ApiResponse<CreateTagOutput>> addTag(@RequestBody CreateTagInput input) {
        return new ResponseEntity<>(ApiResponse.success(createTagService.serve(input), ResponseMessage.SUCCESS_CREATED.getMessage()), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<ApiResponse<List<ListTagOutput>>> getTags(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size) {
        return new ResponseEntity<>(ApiResponse.success(listTagService.getPage(page, size), ResponseMessage.SUCCESS_FETCHED.getMessage()), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<UpdateTagOutput>> editTag(@PathVariable UUID id, @RequestBody UpdateTagInput input) {
        return new ResponseEntity<>(ApiResponse.success(updateTagService.serve(id, input), ResponseMessage.SUCCESS_UPDATED.getMessage()), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<UpdateTagOutput>> deleteTag(@PathVariable UUID id) {
        return new ResponseEntity<>(ApiResponse.success(updateTagService.delete(id), ResponseMessage.SUCCESS_UPDATED.getMessage()), HttpStatus.OK);
    }
}
