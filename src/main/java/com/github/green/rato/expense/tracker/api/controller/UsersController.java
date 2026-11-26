package com.github.green.rato.expense.tracker.api.controller;


import com.github.green.rato.expense.tracker.api.common.ResponseMessage;
import com.github.green.rato.expense.tracker.api.service.users.create.CreateUsersInput;
import com.github.green.rato.expense.tracker.api.service.users.create.CreateUsersOutput;
import com.github.green.rato.expense.tracker.api.service.users.create.CreateUsersService;
import com.github.green.rato.expense.tracker.api.web.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

    private final CreateUsersService createUsersService;

    @PostMapping()
    public ResponseEntity<ApiResponse<CreateUsersOutput>> addUsers(@RequestBody CreateUsersInput input) {
        return new ResponseEntity<>(ApiResponse.success(createUsersService.serve(input), ResponseMessage.SUCCESS_CREATED.getMessage()), HttpStatus.CREATED);
    }

}
