-- =====================================
-- TRANSFERS
-- =====================================

INSERT INTO transfers
(source_acc_id, target_acc_id, amount, transfer_status)
VALUES
(1, 3, 1500.00, 'COMPLETED'),
(3, 5, 500.00, 'COMPLETED'),
(6, 8, 2500.00, 'COMPLETED'),
(9, 10, 3000.00, 'COMPLETED'),
(11, 13, 5000.00, 'COMPLETED'),

(2, 4, 12000.00, 'COMPLETED'),
(12, 14, 8000.00, 'COMPLETED'),
(8, 7, 750.00, 'COMPLETED'),
(10, 1, 2500.00, 'COMPLETED'),
(13, 3, 1000.00, 'COMPLETED'),

(14, 5, 4000.00, 'COMPLETED'),
(4, 6, 3000.00, 'COMPLETED'),
(5, 8, 250.00, 'COMPLETED'),
(1, 9, 15000.00, 'COMPLETED'),
(11, 2, 7000.00, 'COMPLETED'),

(3, 14, 50000.00, 'FAILED'),
(5, 12, 100000.00, 'FAILED'),
(7, 10, 2000.00, 'FAILED'),

(8, 11, 1500.00, 'PENDING'),
(13, 14, 2500.00, 'PENDING');

-- =====================================
-- TRANSACTIONS - TRANSFERS
-- =====================================

INSERT INTO transactions
(account_id, transfer_id, tx_type, amount, description)
VALUES

(1, 1, 'OUTBOUND', 1500.00, 'Převod na účet 3'),
(3, 1, 'INBOUND', 1500.00, 'Příchozí převod z účtu 1'),

(3, 2, 'OUTBOUND', 500.00, 'Převod na účet 5'),
(5, 2, 'INBOUND', 500.00, 'Příchozí převod z účtu 3'),

(6, 3, 'OUTBOUND', 2500.00, 'Převod na účet 8'),
(8, 3, 'INBOUND', 2500.00, 'Příchozí převod z účtu 6'),

(9, 4, 'OUTBOUND', 3000.00, 'Převod na účet 10'),
(10, 4, 'INBOUND', 3000.00, 'Příchozí převod z účtu 9'),

(11, 5, 'OUTBOUND', 5000.00, 'Převod na účet 13'),
(13, 5, 'INBOUND', 5000.00, 'Příchozí převod z účtu 11'),

(2, 6, 'OUTBOUND', 12000.00, 'Převod na účet 4'),
(4, 6, 'INBOUND', 12000.00, 'Příchozí převod z účtu 2'),

(12, 7, 'OUTBOUND', 8000.00, 'Převod na účet 14'),
(14, 7, 'INBOUND', 8000.00, 'Příchozí převod z účtu 12'),

(8, 8, 'OUTBOUND', 750.00, 'Převod na účet 7'),
(7, 8, 'INBOUND', 750.00, 'Příchozí převod z účtu 8'),

(10, 9, 'OUTBOUND', 2500.00, 'Převod na účet 1'),
(1, 9, 'INBOUND', 2500.00, 'Příchozí převod z účtu 10'),

(13, 10, 'OUTBOUND', 1000.00, 'Převod na účet 3'),
(3, 10, 'INBOUND', 1000.00, 'Příchozí převod z účtu 13'),

(14, 11, 'OUTBOUND', 4000.00, 'Převod na účet 5'),
(5, 11, 'INBOUND', 4000.00, 'Příchozí převod z účtu 14'),

(4, 12, 'OUTBOUND', 3000.00, 'Převod na účet 6'),
(6, 12, 'INBOUND', 3000.00, 'Příchozí převod z účtu 4'),

(5, 13, 'OUTBOUND', 250.00, 'Převod na účet 8'),
(8, 13, 'INBOUND', 250.00, 'Příchozí převod z účtu 5'),

(1, 14, 'OUTBOUND', 15000.00, 'Převod na účet 9'),
(9, 14, 'INBOUND', 15000.00, 'Příchozí převod z účtu 1'),

(11, 15, 'OUTBOUND', 7000.00, 'Převod na účet 2'),
(2, 15, 'INBOUND', 7000.00, 'Příchozí převod z účtu 11');

-- =====================================
-- TRANSACTIONS - DEPOSITS
-- =====================================

INSERT INTO transactions
(account_id, transfer_id, tx_type, amount, description)
VALUES

(1, NULL, 'DEPOSIT', 10000.00, 'Hotovostní vklad'),
(3, NULL, 'DEPOSIT', 2500.00, 'Vklad na pobočce'),
(5, NULL, 'DEPOSIT', 1000.00, 'Hotovostní vklad'),
(7, NULL, 'DEPOSIT', 5000.00, 'Vklad přes bankomat'),
(8, NULL, 'DEPOSIT', 3000.00, 'Hotovostní vklad'),

(10, NULL, 'DEPOSIT', 1500.00, 'Vklad na pobočce'),
(11, NULL, 'DEPOSIT', 25000.00, 'Hotovostní vklad'),
(13, NULL, 'DEPOSIT', 4000.00, 'Hotovostní vklad'),
(14, NULL, 'DEPOSIT', 8000.00, 'Vklad přes bankomat'),
(15, NULL, 'DEPOSIT', 12000.00, 'Hotovostní vklad');

-- =====================================
-- TRANSACTIONS - WITHDRAWALS
-- =====================================

INSERT INTO transactions
(account_id, transfer_id, tx_type, amount, description)
VALUES

(1, NULL, 'WITHDRAWAL', 500.00, 'Výběr z bankomatu'),
(2, NULL, 'WITHDRAWAL', 1000.00, 'Výběr z bankomatu'),
(4, NULL, 'WITHDRAWAL', 2000.00, 'Výběr na přepážce'),
(6, NULL, 'WITHDRAWAL', 1500.00, 'Výběr z bankomatu'),
(8, NULL, 'WITHDRAWAL', 250.00, 'Výběr z bankomatu'),

(9, NULL, 'WITHDRAWAL', 5000.00, 'Výběr na přepážce'),
(10, NULL, 'WITHDRAWAL', 750.00, 'Výběr z bankomatu'),
(11, NULL, 'WITHDRAWAL', 10000.00, 'Výběr na přepážce'),
(13, NULL, 'WITHDRAWAL', 500.00, 'Výběr z bankomatu'),
(14, NULL, 'WITHDRAWAL', 3000.00, 'Výběr z bankomatu');