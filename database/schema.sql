CREATE DATABASE IF NOT EXISTS aegiscore_banking;

USE aegiscore_banking;

CREATE TABLE clients (
client_id BIGINT AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(100) NOT NULL,
last_name VARCHAR(100) NOT NULL,
email VARCHAR(255) NOT NULL UNIQUE,
phone_number VARCHAR(50),
created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE accounts (
account_id BIGINT AUTO_INCREMENT PRIMARY KEY,
client_id BIGINT NOT NULL,
iban VARCHAR(34) NOT NULL UNIQUE,
account_type VARCHAR(20) NOT NULL,
balance DECIMAL(15,2) NOT NULL DEFAULT 0.00,
currency CHAR(3) NOT NULL DEFAULT 'CZK',
created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

CONSTRAINT fk_accounts_client
    FOREIGN KEY (client_id)
    REFERENCES clients(client_id),

CONSTRAINT chk_account_type
    CHECK (account_type IN ('CURRENT', 'SAVINGS')),

CONSTRAINT chk_account_balance
    CHECK (balance >= 0)
);

CREATE TABLE cards (
card_id BIGINT AUTO_INCREMENT PRIMARY KEY,
account_id BIGINT NOT NULL,
card_number VARCHAR(32) NOT NULL UNIQUE,
card_status VARCHAR(20) NOT NULL,
expiry_date DATE NOT NULL,
created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

CONSTRAINT fk_cards_account
    FOREIGN KEY (account_id)
    REFERENCES accounts(account_id),

CONSTRAINT chk_card_status
    CHECK (card_status IN ('ACTIVE', 'BLOCKED', 'EXPIRED'))
);

CREATE TABLE transfers (
transfer_id BIGINT AUTO_INCREMENT PRIMARY KEY,
source_acc_id BIGINT NOT NULL,
target_acc_id BIGINT NOT NULL,
amount DECIMAL(15,2) NOT NULL,
transfer_status VARCHAR(20) NOT NULL,
created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

CONSTRAINT fk_transfer_source
    FOREIGN KEY (source_acc_id)
        REFERENCES accounts(account_id),

CONSTRAINT fk_transfer_target
    FOREIGN KEY (target_acc_id)
        REFERENCES accounts(account_id),

CONSTRAINT chk_transfer_amount
    CHECK (amount > 0),

CONSTRAINT chk_transfer_accounts
    CHECK (source_acc_id <> target_acc_id),

CONSTRAINT chk_transfer_status
    CHECK (transfer_status IN ('PENDING', 'COMPLETED', 'FAILED'))
);

CREATE TABLE transactions (
tx_id BIGINT AUTO_INCREMENT PRIMARY KEY,
account_id BIGINT NOT NULL,
transfer_id BIGINT NULL,
tx_type VARCHAR(20) NOT NULL,
amount DECIMAL(15,2) NOT NULL,
description VARCHAR(255),
tx_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

CONSTRAINT fk_transactions_account
    FOREIGN KEY (account_id)
    REFERENCES accounts(account_id),

CONSTRAINT fk_transactions_transfer
    FOREIGN KEY (transfer_id)
    REFERENCES transfers(transfer_id),

CONSTRAINT chk_tx_type
    CHECK (tx_type IN ('DEPOSIT', 'WITHDRAWAL', 'INBOUND', 'OUTBOUND')),

CONSTRAINT chk_tx_amount
    CHECK (amount > 0)
);