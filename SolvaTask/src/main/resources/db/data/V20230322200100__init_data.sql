INSERT into client_limit (id, limit_sum,  limit_currency_shortname, limit_balance_product, limit_balance_service, limit_datetime, is_first_limit, bank_account)
VALUES(nextval('limit_seq'), '1000',  'USD', '1000', '1000', '2023-02-21', 'true', '12345'),
(nextval('limit_seq'), '1000', 'USD', '0', '0', '2023-02-21', 'true', '123forTest')
