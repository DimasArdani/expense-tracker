package com.github.green.rato.expense.tracker.api.common;

import lombok.Getter;

@Getter
public enum Status {
    ACTIVE("ACT"),
    INACTIVE("INA");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    public static Enum<Status> of(String status) {
        for (Status s : Status.values()) {
            if (s.getStatus().equalsIgnoreCase(status)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Invalid status: " + status);
    }

}
