-- =====================================
-- CLIENTS
-- =====================================

INSERT INTO clients
(first_name, last_name, email, phone_number)
VALUES
('Jan', 'Novák', '[jan.novak@email.cz](mailto:jan.novak@email.cz)', '+420601111111'),
('Petra', 'Svobodová', '[petra.svobodova@email.cz](mailto:petra.svobodova@email.cz)', '+420602222222'),
('Tomáš', 'Dvořák', '[tomas.dvorak@email.cz](mailto:tomas.dvorak@email.cz)', '+420603333333'),
('Martin', 'Procházka', '[martin.prochazka@email.cz](mailto:martin.prochazka@email.cz)', '+420604444444'),
('Jiří', 'Černý', '[jiri.cerny@email.cz](mailto:jiri.cerny@email.cz)', '+420605555555'),
('Lucie', 'Novotná', '[lucie.novotna@email.cz](mailto:lucie.novotna@email.cz)', '+420606666666'),
('Jana', 'Horáková', '[jana.horakova@email.cz](mailto:jana.horakova@email.cz)', '+420607777777'),
('Veronika', 'Kučerová', '[veronika.kucerova@email.cz](mailto:veronika.kucerova@email.cz)', '+420608888888'),
('Kateřina', 'Němcová', '[katerina.nemcova@email.cz](mailto:katerina.nemcova@email.cz)', '+420609999999'),
('Petr', 'Veselý', '[petr.vesely@email.cz](mailto:petr.vesely@email.cz)', '+420601123456');

-- =====================================
-- ACCOUNTS
-- =====================================

INSERT INTO accounts
(client_id, iban, account_type, balance, currency)
VALUES
(1, 'CZ6508000000000000000001', 'CURRENT', 25000.00, 'CZK'),
(1, 'CZ6508000000000000000002', 'SAVINGS', 100000.00, 'CZK'),

(2, 'CZ6508000000000000000003', 'CURRENT', 5000.00, 'CZK'),

(3, 'CZ6508000000000000000004', 'CURRENT', 15000.00, 'CZK'),

(4, 'CZ6508000000000000000005', 'CURRENT', 500.00, 'CZK'),
(4, 'CZ6508000000000000000006', 'SAVINGS', 250000.00, 'CZK'),

(5, 'CZ6508000000000000000007', 'CURRENT', 0.00, 'CZK'),

(6, 'CZ6508000000000000000008', 'CURRENT', 8000.00, 'CZK'),

(7, 'CZ6508000000000000000009', 'CURRENT', 45000.00, 'CZK'),

(8, 'CZ6508000000000000000010', 'CURRENT', 12000.00, 'CZK'),

(9, 'CZ6508000000000000000011', 'CURRENT', 300000.00, 'CZK'),
(9, 'CZ6508000000000000000012', 'SAVINGS', 500000.00, 'CZK'),

(10, 'CZ6508000000000000000013', 'CURRENT', 2000.00, 'CZK'),
(10, 'CZ6508000000000000000014', 'SAVINGS', 75000.00, 'CZK'),

(2, 'CZ6508000000000000000015', 'SAVINGS', 25000.00, 'CZK');

-- =====================================
-- CARDS
-- =====================================

INSERT INTO cards
(account_id, card_number, card_status, expiry_date)
VALUES
(1, '4000000000000001', 'ACTIVE', '2028-12-31'),
(2, '4000000000000002', 'ACTIVE', '2029-06-30'),

(3, '4000000000000003', 'ACTIVE', '2028-08-31'),

(4, '4000000000000004', 'ACTIVE', '2027-10-31'),

(5, '4000000000000005', 'BLOCKED', '2028-03-31'),

(6, '4000000000000006', 'ACTIVE', '2029-01-31'),

(7, '4000000000000007', 'EXPIRED', '2024-12-31'),

(8, '4000000000000008', 'ACTIVE', '2028-07-31'),

(9, '4000000000000009', 'ACTIVE', '2029-09-30'),

(10, '4000000000000010', 'BLOCKED', '2028-11-30'),

(11, '4000000000000011', 'ACTIVE', '2029-04-30'),

(13, '4000000000000012', 'EXPIRED', '2023-12-31');