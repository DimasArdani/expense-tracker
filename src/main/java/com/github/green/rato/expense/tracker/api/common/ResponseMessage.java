package com.github.green.rato.expense.tracker.api.common;

public enum ResponseMessage {
    SUCCESS_CREATED("ITEM HAS BEEN CREATED"),
    SUCCESS_UPDATED("ITEM HAS BEEN UPDATED"),
    SUCCESS_DELETED("ITEM HAS BEEN DELETED"),
    SUCCESS_FETCHED("ITEM HAS BEEN FETCHED"),
    ERROR("ERROR");

    private final String message;

    ResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
