# Databázový Model

## Aegis Core Banking System

### Účel dokumentu
Tento dokument popisuje první verzi logického databázového modelu projektu Aegis Core Banking System.

Cílem modelu je vytvořit realistický základ pro:

* výuku SQL
* návrh databází
* databázové testování
* návrh REST API
* testování API
* business analýzu

Tento dokument popisuje logický model systému.
Neobsahuje SQL implementaci.

---

# Entity Overview
První verze systému obsahuje následující entity:

1. Client
2. Account
3. Card
4. Transaction
5. Transfer

---

# Entity: Client

## Účel
Reprezentuje klienta banky.
Klient je vlastníkem jednoho nebo více bankovních účtů.

## Business význam
Bez klienta nemůže existovat účet.
Každý účet musí být přiřazen konkrétnímu klientovi.

---

# Entity: Account

## Účel
Reprezentuje bankovní účet.
Účet slouží k ukládání finančních prostředků a provádění bankovních operací.

## Business význam
Nad účtem probíhají:
* vklady
* výběry
* převody
* práce s platebními kartami

---

# Entity: Card

## Účel
Reprezentuje platební kartu vydanou k účtu.

## Business význam
Karta umožňuje klientovi přístup k prostředkům na účtu.
Karta může být:

* aktivní (ACTIVE)
* blokovaná (BLOCKED)
* expirovaná (EXPIRED)

---

# Entity: Transaction

## Účel
Reprezentuje finanční pohyb na účtu.

## Business význam
Každá změna zůstatku musí být evidována formou transakce.
Příklady:

* vklad (DEPOSIT)
* výběr (WITHDRAWAL)
* příchozí převod (INBOUND)
* odchozí převod (OUTBOUND)

Transakce tvoří historii účtu.

---

# Entity: Transfer

## Účel
Reprezentuje převod finančních prostředků mezi dvěma účty.

## Business význam
Převod je samostatný business proces.
Každý převod musí mít:

* zdrojový účet (SOURCE)
* cílový účet (TARGET)
* částku (AMOUNT)
* stav převodu (STATUS)

Transfer může vytvářet související transakce na obou účtech.

---

# Relace (Relationships)

## Client → Account
Mohutnost (Cardinality):

1 : N

Význam:

Jeden klient může vlastnit více účtů.
Každý účet musí patřit právě jednomu klientovi.

---

## Account → Card
Mohutnost (Cardinality):

1 : N

Význam:

Jeden účet může mít více karet.
Každá karta musí být navázána na jeden účet.

---

## Account → Transaction
Mohutnost (Cardinality):

1 : N

Význam:

Jeden účet může obsahovat mnoho transakcí.
Každá transakce musí patřit jednomu účtu.

---

## Account → Transfer (Source)
Mohutnost (Cardinality):

1 : N

Význam:

Účet může být zdrojovým účtem mnoha převodů.

---

## Account → Transfer (Target)
Mohutnost (Cardinality):

1 : N

Význam:

Účet může být cílovým účtem mnoha převodů.

---

# Logický Diagram
Client
│
└── Account
│
├── Card
│
├── Transaction
│
└── Transfer

Transfer
├── Source Account
└── Target Account

---

# Business Pravidla
Systém musí respektovat následující pravidla:

* Účet musí patřit konkrétnímu klientovi.
* Transakce musí být přiřazena ke konkrétnímu účtu.
* Převod musí mít zdrojový a cílový účet.
* Zablokovanou kartu nelze použít.
* Zůstatek účtu nesmí být záporný, pokud není implementován kontokorent.

---

# Mimo Rozsah (Verze 1)
Následující oblasti nejsou součástí první verze databázového modelu:

* úvěry
* hypotéky
* investiční produkty
* pobočky
* zaměstnanci banky
* více měn na jednom účtu
* auditní logy
* dávkové zpracování
* mainframe integrace

Tyto oblasti mohou být přidány v budoucích verzích projektu.

---

# Další Krok
Dalším krokem projektu bude návrh atributů jednotlivých entit.
Po schválení atributů bude vytvořeno fyzické databázové schéma:

- database/schema.sql
