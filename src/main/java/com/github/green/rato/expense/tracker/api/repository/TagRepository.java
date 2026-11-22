package com.github.green.rato.expense.tracker.api.repository;

import com.github.green.rato.expense.tracker.api.model.TagDTO;
import com.github.green.rato.expensetracker.jooq.tables.pojos.Tag;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TagRepository {
    Tag save(TagDTO tag);
    Tag update(UUID id, TagDTO tag);
    List<Tag> findAll(Integer page, Integer size);
    Optional<Tag> findById(UUID id);
    int delete(String id);
}
