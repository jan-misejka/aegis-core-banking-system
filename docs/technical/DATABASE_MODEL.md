# Databázový model
## Aegis Core Banking System
### Účel dokumentu
Tento dokument popisuje logický databázový model projektu Aegis Core Banking System.

Cílem modelu je vytvořit realistický základ pro:
- návrh databáze
- výuku SQL
- databázové testování
- návrh REST API
- testování API
- business analýzu

Dokument popisuje logický model a jeho business význam.

Fyzická implementace databáze je uložena v `database/schema.sql`.

---

## Entity Overview
Databázový model obsahuje následující entity:

1. Client
2. Account
3. Card
4. Transaction
5. Transfer

---

## Entity: Client
### Účel
Reprezentuje klienta banky.

### Business význam
Klient je vlastníkem jednoho nebo více bankovních účtů. Bez klienta nemůže existovat účet.

---

## Entity: Account
### Účel
Reprezentuje bankovní účet. Účet slouží k ukládání finančních prostředků a provádění bankovních operací.

### Business význam
Nad účtem probíhají:
- vklady
- výběry
- převody
- práce s platebními kartami

#### Atributy
- `account_id`
- `client_id`
- `iban`
- `account_type`
- `balance`
- `currency`
- `created_at`

#### Povolené typy účtu
- `CURRENT`
- `SAVINGS`

#### Currency
Účet obsahuje atribut `currency` reprezentující měnu účtu. V aktuálním testovacím datasetu jsou účty vedeny v měně `CZK`.

---

## Entity: Card
### Účel
Reprezentuje platební kartu vydanou k účtu.

### Business význam
Karta umožňuje klientovi přístup k prostředkům na účtu.

#### Atributy
- `card_id`
- `account_id`
- `card_number`
- `card_status`
- `expiry_date`
- `created_at`

#### Povolené stavy
- `ACTIVE`
- `BLOCKED`
- `EXPIRED`

---

## Entity: Transaction
### Účel
Reprezentuje finanční pohyb na účtu.

### Business význam
Každá změna zůstatku musí být evidována formou transakce. 

Příklady:
- `DEPOSIT`
- `WITHDRAWAL`
- `INBOUND`
- `OUTBOUND`

Transakce tvoří historii účtu.

#### Atributy
- `tx_id`
- `account_id`
- `transfer_id`
- `tx_type`
- `amount`
- `description`
- `tx_date`

#### Povolené typy
- `DEPOSIT`
- `WITHDRAWAL`
- `INBOUND`
- `OUTBOUND`

---

## Entity: Transfer
### Účel
Reprezentuje převod finančních prostředků mezi dvěma účty.

### Business význam
Převod je samostatný business proces.

Každý převod obsahuje:
- zdrojový účet
- cílový účet
- částku
- stav převodu

Transfer může vytvářet související transakce na obou účtech.

#### Atributy
- `transfer_id`
- `source_acc_id`
- `target_acc_id`
- `amount`
- `transfer_status`
- `created_at`

#### Povolené stavy
- `PENDING`
- `COMPLETED`
- `FAILED`

---

## Relace
### Client → Account
**Mohutnost:** 1 : N

**Význam:**

Jeden klient může vlastnit více účtů. Každý účet musí patřit právě jednomu klientovi.

---

### Account → Card
**Mohutnost:** 1 : N

**Význam:**

Jeden účet může mít více platebních karet. Každá karta musí být navázána na jeden účet.

---

### Account → Transaction
**Mohutnost:** 1 : N

**Význam:**

Jeden účet může obsahovat mnoho transakcí. Každá transakce musí patřit jednomu účtu.

---

### Account → Transfer (Source)
**Mohutnost:** 1 : N

**Význam:**

Účet může být zdrojovým účtem mnoha převodů.

---

### Account → Transfer (Target)
**Mohutnost:** 1 : N

**Význam:**

Účet může být cílovým účtem mnoha převodů.

---

### Transfer → Transaction
**Mohutnost:** 1 : N

**Význam:**

Jeden převod může vytvářet více souvisejících transakcí.

Typicky:
- jednu `OUTBOUND` transakci
- jednu `INBOUND` transakci

Transakce nemusí být součástí převodu, například u vkladu nebo výběru.

---

## Logický diagram
```text
Client
│
└── Account
    │
    ├── Card
    │
    ├── Transaction
    │
    └── Transfer
        │
        ├── Source Account
        └── Target Account
```

---

## Databázová omezení
Fyzické databázové schéma definuje zejména:
- primární klíče (PK)
- cizí klíče (FK)
- UNIQUE omezení
- CHECK omezení
- NOT NULL omezení
- výchozí hodnoty některých atributů

Mezi důležitá omezení patří:
- email klienta musí být unikátní
- IBAN účtu musí být unikátní
- číslo karty musí být unikátní
- zůstatek účtu nesmí být záporný
- částka převodu musí být větší než 0
- zdrojový a cílový účet převodu nesmí být stejný
- částka transakce musí být větší než 0
- hodnoty stavů a typů jsou omezeny definovanými hodnotami

---

## Business pravidla
Systém musí respektovat následující pravidla:
- Účet musí patřit konkrétnímu klientovi.
- Transakce musí být přiřazena ke konkrétnímu účtu.
- Převod musí mít zdrojový a cílový účet.
- Zdrojový a cílový účet převodu nesmí být stejný.
- Zůstatek účtu nesmí být záporný.
- Zablokovanou kartu nelze použít.
- Transakce související s převodem musí být navázány na konkrétní Transfer.

---

## Mimo rozsah
Databázový model v aktuálním rozsahu projektu neobsahuje:
- úvěry
- hypotéky
- investiční produkty
- pobočky
- zaměstnance banky
- auditní logy
- dávkové zpracování
- mainframe integraci

Tyto oblasti mohou být řešeny v budoucích projektech nebo rozšířeních.

---

## Fyzická implementace
Fyzické databázové schéma je uloženo v:
```text
database/schema.sql
```

Testovací data jsou uložena v:
```text
database/test_data.sql
database/test_data_part2.sql
```

SQL cvičení jsou uložena v:
```text
database/SQL_EXERCISES.md
```

SQL validační testy jsou uloženy v:
```text
database/SQL_VALIDATION.md
```