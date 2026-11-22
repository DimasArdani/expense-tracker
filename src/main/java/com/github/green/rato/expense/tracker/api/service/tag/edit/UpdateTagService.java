package com.github.green.rato.expense.tracker.api.service.tag.edit;

import java.util.UUID;

public interface UpdateTagService {
    UpdateTagOutput serve(UUID id, UpdateTagInput input);
    UpdateTagOutput delete(UUID id);
}
