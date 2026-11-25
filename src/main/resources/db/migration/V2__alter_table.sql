ALTER TABLE tag
    ALTER COLUMN updated_date DROP NOT NULL,
    ALTER COLUMN updated_date DROP DEFAULT;

ALTER TABLE transactions
    ALTER COLUMN updated_date DROP NOT NULL,
    ALTER COLUMN updated_date DROP DEFAULT;