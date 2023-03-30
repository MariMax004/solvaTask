create sequence currency_seq;
create table currency
(
    id             int primary key,
    currency_type  text,
    value_currency float,
    date_time      date

);

create sequence limit_seq;
create table client_limit
(
    id                       int primary key,
    bank_account             text,
    limit_sum                float,
    limit_balance_product          float,
    limit_balance_service    float,
    limit_datetime           date,
    limit_currency_shortname text,
    is_first_limit           boolean
);

CREATE TYPE type_expense AS ENUM ('PRODUCT', 'SERVICE', 'TEST');
create sequence transaction_seq;
create table transaction
(
    id                 int primary key,
    account_from       text,
    account_to         text,
    sum                float,
    currency_shortname text,
    expense_category   text,
    limit_exceed       boolean,
    datetime           date,
    limit_id           int,
    FOREIGN KEY (limit_id) REFERENCES client_limit (id)
);
