package com.github.green.rato.expense.tracker.api.service.tag.edit;

import lombok.Builder;

@Builder
public record UpdateTagInput(
    String name,
    String status
) {
}
