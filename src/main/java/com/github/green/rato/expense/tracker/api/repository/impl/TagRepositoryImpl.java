package com.github.green.rato.expense.tracker.api.repository.impl;

import com.github.green.rato.expense.tracker.api.common.Status;
import com.github.green.rato.expense.tracker.api.model.TagDTO;
import com.github.green.rato.expense.tracker.api.repository.TagRepository;
import com.github.green.rato.expensetracker.jooq.tables.pojos.Tag;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.github.green.rato.expensetracker.jooq.tables.Tag.TAG;
@Repository
public class TagRepositoryImpl implements TagRepository {

    private final DSLContext dsl;
    public TagRepositoryImpl(DSLContext create) {this.dsl = create;}


    @Override
    public Tag save(TagDTO tag) {
        return dsl.insertInto(TAG)
                .set(TAG.NAME, tag.name())
                .set(TAG.STATUS, tag.status())
                .set(TAG.CREATED_DATE, OffsetDateTime.now())
                .returning()
                .fetchSingleInto(Tag.class);
    }

    @Override
    public Tag update(UUID id, TagDTO tag) {
        return dsl.update(TAG)
                .set(TAG.NAME, tag.name())
                .set(TAG.STATUS, tag.status())
                .set(TAG.UPDATED_DATE, java.time.OffsetDateTime.now())
                .where(TAG.ID.eq(id))
                .returning()
                .fetchSingleInto(Tag.class);
    }

    @Override
    public List<Tag> findAll(Integer page, Integer size) {
        return dsl.selectFrom(TAG)
                .where(TAG.STATUS.eq(Status.ACTIVE.getStatus()))
                .limit(size)
                .offset(page)
                .fetchInto(Tag.class);
    }

    @Override
    public Optional<Tag> findById(UUID id) {
        return dsl.selectFrom(TAG)
                .where(TAG.ID.eq(id))
                .fetchOptionalInto(Tag.class);
    }

    @Override
    public int delete(String id) {
        return dsl.deleteFrom(TAG)
                .where(TAG.ID.eq(UUID.fromString(id)))
                .execute();

    }
}
