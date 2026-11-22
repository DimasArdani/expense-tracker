package com.github.green.rato.expense.tracker.api.model;

import lombok.Builder;

import java.time.OffsetDateTime;
import java.util.UUID;

@Builder
public record TagDTO(
        UUID id,
        String name,
        OffsetDateTime createdDate,
        OffsetDateTime updatedDate,
        String status
) { }
