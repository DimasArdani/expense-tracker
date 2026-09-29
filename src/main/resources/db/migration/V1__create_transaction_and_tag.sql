CREATE TABLE tag
(
    id           UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name         VARCHAR(100) NOT NULL UNIQUE,
    created_date TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_date TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE TABLE transactions
(
    id           UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    category     VARCHAR(100) NOT NULL,
    tag_id       UUID NOT NULL,
    description  VARCHAR(255),
    amount       NUMERIC(15, 2) NOT NULL,
    created_date TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_date TIMESTAMPTZ NOT NULL DEFAULT NOW(),

    CONSTRAINT fk_transactions_tag
        FOREIGN KEY (tag_id)
            REFERENCES tag (id)
);