# Business požadavky

## Rozsah systému

Systém představuje zjednodušenou platformu pro správu osobního bankovnictví.

## Případy užití

### UC001 – Vytvoření klienta
Bankovní pracovník vytvoří nového klienta.
**Stav:** ✅ Dokončeno

**Implementováno:**

- POST /clients
- GET /clients
- GET /clients/{id}
- PUT /clients/{id}
- DELETE /clients/{id}

**Ověření:**

- Manuální testování v Postman.
- Ověření dat v DBeaver.
- CRUD funkcionalita dokončena.

---

### UC002 – Založení účtu
Bankovní pracovník založí účet existujícímu klientovi.
**Stav:** ✅ Dokončeno

**Implementováno:**

- Dokončený Project Review #1
- Implementovaný TECH-001
- Implementovaný TECH-002
- POST /accounts
- účet je vždy přiřazen existujícímu klientovi
- accountType:
    - CURRENT
    - SAVINGS
- currency:
    - CZK
    - EUR
    - USD
- počáteční balance = 0
- automatické vytvoření createdAt
- generování IBAN
- kontrola unikátnosti IBAN

**HTTP chování:**

- 201 Created – účet byl úspěšně vytvořen
- 400 Bad Request – nevalidní vstup nebo nepovolený typ účtu/měna
- 404 Not Found – klient neexistuje

**Ověření:**

- Maven testy prošly.
- Pozitivní scénář byl ověřen pomocí Postmanu.
- Negativní scénáře byly ověřeny pomocí Postmanu.
- Uložení a správnost dat byly ověřeny pomocí DBeaveru.

---

### UC003 – Vklad peněz
Na účet jsou vloženy peníze.
**Stav:** ✅ Dokončeno

**Implementováno:**

- POST /accounts/{id}/deposit
- účet musí existovat
- částka musí být větší než 0
- minimální částka vkladu je 0.01
- balance účtu je navýšen o vloženou částku
- při vkladu je vytvořena Transaction
- Transaction má typ DEPOSIT
- Transaction je přiřazena ke konkrétnímu účtu
- datum a čas transakce je uložen
- změna účtu a vytvoření transakce probíhají v rámci jedné databázové transakce

**HTTP chování:**

- 200 OK – vklad byl úspěšně proveden
- 400 Bad Request – částka je nevalidní
- 404 Not Found – účet neexistuje

**Ověření:**

- Maven/JUnit testy prošly.
- Pozitivní scénář byl ověřen pomocí Postmanu.
- Negativní scénáře byly ověřeny pomocí Postmanu.
- Změna balance byla ověřena pomocí DBeaveru.
- Vytvoření DEPOSIT transaction a její vazba na účet byly ověřeny pomocí DBeaveru.

---

### UC004 – Výběr peněz
Z účtu jsou vybrány peníze.
**Stav:** ✅ Dokončeno

**Implementováno:**

- POST /accounts/{id}/withdraw
- účet musí existovat
- částka musí být větší než 0
- minimální částka výběru je 0.01
- balance účtu je snížen o vybranou částku
- výběr nesmí překročit aktuální balance účtu
- při výběru je vytvořena Transaction
- Transaction má typ WITHDRAWAL
- Transaction je přiřazena ke konkrétnímu účtu
- datum a čas transakce je uložen
- změna účtu a vytvoření transakce probíhají v rámci jedné databázové transakce

**HTTP chování:**

- 200 OK – výběr byl úspěšně proveden
- 400 Bad Request – částka je nevalidní nebo není dostatečný balance
- 404 Not Found – účet neexistuje

**Ověření:**

- Maven/JUnit testy prošly.
- Pozitivní scénář byl ověřen pomocí Postmanu.
- Negativní scénáře byly ověřeny pomocí Postmanu.
- Změna balance byla ověřena pomocí DBeaveru.
- Vytvoření WITHDRAWAL transaction a její vazba na účet byly ověřeny pomocí DBeaveru.
- Ověřeno, že zamítnutý výběr nezmění balance ani nevytvoří novou transaction.

---

### UC005 – Převod peněz
Peníze jsou převedeny mezi dvěma účty.
**Stav:** ⏳ Plánováno

### UC006 – Vydání platební karty
K účtu je vydána platební karta.
**Stav:** ⏳ Plánováno

### UC007 – Blokace platební karty
Platební karta je zablokována.
**Stav:** ⏳ Plánováno

## Business pravidla

- Účet musí patřit konkrétnímu klientovi.
- Transakce musí být přiřazena ke konkrétnímu účtu.
- Převod musí mít zdrojový a cílový účet.
- Zablokovanou kartu nelze použít.
- Zůstatek na účtu nesmí být záporný, pokud není implementována podpora kontokorentu.

---

# Implementační pořadí

Business Use Casy jsou implementovány postupně.

Po dokončení každého Use Casu nebo významného technického milníku následuje:
1. Project Review.
2. Aktualizace dokumentace.
3. Aktualizace Technical Backlog.
4. Implementace položek označených jako High Priority.
5. Zahájení dalšího Use Casu.

Podrobný vývojový postup je popsán v dokumentu:

`DEVELOPMENT_WORKFLOW.md`