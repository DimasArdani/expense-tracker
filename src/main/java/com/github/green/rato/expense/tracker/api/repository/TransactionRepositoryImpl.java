package com.github.green.rato.expense.tracker.api.repository;

import com.github.green.rato.expense.tracker.api.common.Status;
import com.github.green.rato.expense.tracker.api.model.TransactionDTO;
import com.github.green.rato.expensetracker.jooq.tables.pojos.Transactions;
import org.springframework.stereotype.Repository;
import org.jooq.*;

import static com.github.green.rato.expensetracker.jooq.tables.Transactions.TRANSACTIONS;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

    private final DSLContext dsl;
    public TransactionRepositoryImpl(DSLContext create) {
        this.dsl = create;
    }

    @Override
    public Transactions save(TransactionDTO transaction) {
        return dsl.insertInto(TRANSACTIONS)
                .set(TRANSACTIONS.AMOUNT, transaction.amount())
                .set(TRANSACTIONS.CATEGORY, transaction.category())
                .set(TRANSACTIONS.TAG_ID, transaction.tagId())
                .set(TRANSACTIONS.DESCRIPTION, transaction.description())
                .set(TRANSACTIONS.STATUS, Status.ACTIVE.getStatus())
                .returning()
                .fetchSingleInto(Transactions.class);
    }

    @Override
    public List<Transactions> findAll() {
        return dsl.selectFrom(TRANSACTIONS)
                .where(TRANSACTIONS.STATUS.eq(Status.ACTIVE.getStatus()))
                .fetchInto(Transactions.class);
    }

    @Override
    public Transactions edit(UUID id, TransactionDTO transactions) {
        return dsl.update(TRANSACTIONS)
                .set(TRANSACTIONS.AMOUNT, transactions.amount())
                .set(TRANSACTIONS.CATEGORY, transactions.category())
                .set(TRANSACTIONS.TAG_ID, transactions.tagId())
                .set(TRANSACTIONS.DESCRIPTION, transactions.description())
                .set(TRANSACTIONS.UPDATED_DATE, transactions.updatedDate())
                .set(TRANSACTIONS.STATUS, Status.ACTIVE.getStatus())
                .where(TRANSACTIONS.ID.eq(id))
                .returning()
                .fetchSingleInto(Transactions.class);
    }

    @Override
    public Transactions delete(UUID id) {
        return dsl.update(TRANSACTIONS)
                .set(TRANSACTIONS.STATUS, Status.INACTIVE.getStatus())
                .set(TRANSACTIONS.UPDATED_DATE, java.time.OffsetDateTime.now())
                .where(TRANSACTIONS.ID.eq(id))
                .returning()
                .fetchSingleInto(Transactions.class);
    }

    @Override
    public Transactions hardDelete(UUID id) {
        return dsl.delete(TRANSACTIONS)
                .where(TRANSACTIONS.ID.eq(id))
                .returning()
                .fetchSingleInto(Transactions.class);
    }

    @Override
    public Optional<Transactions> getById(UUID id) {
        return dsl.selectFrom(TRANSACTIONS)
                .where(TRANSACTIONS.ID.eq(id))
                .fetchOptionalInto(Transactions.class);
    }
}
