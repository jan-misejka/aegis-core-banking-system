# Test Cases
## Aegis Core Banking System

## 1. Účel
Tento dokument obsahuje konkrétní testovací scénáře pro ověřování funkcionality projektu Aegis Core Banking System.

Test Cases vycházejí z:
- `docs/business/BUSINESS_REQUIREMENTS.md`
- `docs/qa/TEST_PLAN.md`
- `testing/TESTING.md`

Každý testovací scénář má ověřovat konkrétní očekávané chování systému a musí být dohledatelný k příslušnému Use Case. Tento dokument obsahuje **definici testovacích scénářů**, nikoliv výsledky jejich konkrétního provedení. Výsledky jednotlivých testovacích běhů jsou vedeny v `docs/qa/TEST_RUNS.md`.

---

## 2. Struktura Test Case
Každý testovací scénář obsahuje podle potřeby:
- Test Case ID
- Use Case
- Název
- Typ
- Prioritu
- Předpoklady
- Testovací data
- Kroky
- Očekávaný výsledek

### Typy testů
Používané typy zahrnují:
- **Positive** – validní a očekávané použití
- **Negative** – nevalidní nebo nepovolené použití
- **Boundary** – ověření hraničních hodnot nebo podmínek
- **Regression** – ověření, že změna nenarušila existující funkcionalitu

Jeden Test Case může podle potřeby pokrývat více charakteristik.

---

# 3. Test Cases
## UC001 – Client Management
### TC-001-01 – Vytvoření klienta s validními údaji
- **Use Case:** UC001
- **Typ:** Positive
- **Priorita:** High
- **Předpoklady:** Systém je dostupný.
- **Testovací data:** Validní údaje nového klienta.
- **Kroky:**
    1. Odeslat request pro vytvoření klienta.
    2. Ověřit HTTP response.
    3. Ověřit vytvoření klienta v databázi.
- **Očekávaný výsledek:**
    - klient je úspěšně vytvořen
    - API vrátí očekávaný HTTP status
    - uložená data odpovídají requestu

### TC-001-02 – Vytvoření klienta s nevalidními údaji
- **Use Case:** UC001
- **Typ:** Negative
- **Priorita:** High
- **Předpoklady:** Systém je dostupný.
- **Testovací data:** Nevalidní nebo neúplné údaje klienta.
- **Kroky:**
    1. Odeslat request s nevalidními údaji.
    2. Ověřit HTTP response.
    3. Ověřit databázi.
- **Očekávaný výsledek:**
    - request je odmítnut
    - API vrátí očekávaný chybový status
    - klient není vytvořen

### TC-001-03 – Získání seznamu klientů
- **Use Case:** UC001
- **Typ:** Positive
- **Priorita:** Medium
- **Předpoklady:** V databázi existují klienti.
- **Testovací data:** Existující klienti.
- **Kroky:**
    1. Odeslat request pro získání seznamu klientů.
    2. Ověřit HTTP response.
    3. Porovnat vrácená data s databází.
- **Očekávaný výsledek:**
    - API vrátí očekávaný status
    - seznam obsahuje očekávané klienty
    - vrácená data odpovídají databázi

### TC-001-04 – Získání detailu existujícího klienta
- **Use Case:** UC001
- **Typ:** Positive
- **Priorita:** Medium
- **Předpoklady:** Klient existuje.
- **Testovací data:** ID existujícího klienta.
- **Kroky:**
    1. Odeslat request na detail klienta.
    2. Ověřit HTTP response.
    3. Porovnat data s databází.
- **Očekávaný výsledek:**
    - API vrátí očekávaný status
    - detail odpovídá existujícímu klientovi

### TC-001-05 – Získání detailu neexistujícího klienta
- **Use Case:** UC001
- **Typ:** Negative
- **Priorita:** Medium
- **Předpoklady:** Klient s použitým ID neexistuje.
- **Testovací data:** Neexistující ID klienta.
- **Kroky:**
    1. Odeslat request na detail neexistujícího klienta.
    2. Ověřit HTTP response.
- **Očekávaný výsledek:**
    - API vrátí očekávaný chybový status
    - nedojde ke změně databáze

### TC-001-06 – Aktualizace existujícího klienta
- **Use Case:** UC001
- **Typ:** Positive
- **Priorita:** Medium
- **Předpoklady:** Klient existuje.
- **Testovací data:** Validní nové údaje klienta.
- **Kroky:**
    1. Odeslat request pro aktualizaci klienta.
    2. Ověřit HTTP response.
    3. Ověřit změnu v databázi.
- **Očekávaný výsledek:**
    - klient je úspěšně aktualizován
    - změněné údaje odpovídají requestu

### TC-001-07 – Aktualizace neexistujícího klienta
- **Use Case:** UC001
- **Typ:** Negative
- **Priorita:** Medium
- **Předpoklady:** Klient s použitým ID neexistuje.
- **Testovací data:** Neexistující ID klienta.
- **Kroky:**
    1. Odeslat request pro aktualizaci klienta.
    2. Ověřit HTTP response.
    3. Ověřit databázi.
- **Očekávaný výsledek:**
    - request je odmítnut
    - API vrátí očekávaný chybový status
    - databáze není změněna

### TC-001-08 – Odstranění existujícího klienta
- **Use Case:** UC001
- **Typ:** Positive
- **Priorita:** High
- **Předpoklady:** Klient splňuje podmínky pro odstranění.
- **Testovací data:** Existující klient.
- **Kroky:**
    1. Odeslat request pro odstranění klienta.
    2. Ověřit HTTP response.
    3. Ověřit stav klienta v databázi.
- **Očekávaný výsledek:**
    - operace je úspěšná
    - stav klienta odpovídá definovanému business pravidlu

---

## UC002 – Open Account
### TC-002-01 – Otevření účtu pro existujícího klienta
- **Use Case:** UC002
- **Typ:** Positive
- **Priorita:** High
- **Předpoklady:** Klient existuje.
- **Testovací data:** Existující klient, validní typ účtu a měna.
- **Kroky:**
    1. Odeslat request pro otevření účtu.
    2. Ověřit HTTP response.
    3. Ověřit účet v databázi.
- **Očekávaný výsledek:**
    - účet je vytvořen
    - účet je navázán na správného klienta
    - počáteční balance je 0
    - IBAN je vytvořen a unikátní

### TC-002-02 – Otevření účtu pro neexistujícího klienta
- **Use Case:** UC002
- **Typ:** Negative
- **Priorita:** High
- **Předpoklady:** Klient neexistuje.
- **Testovací data:** Neexistující ID klienta.
- **Kroky:**
    1. Odeslat request pro otevření účtu.
    2. Ověřit HTTP response.
    3. Ověřit databázi.
- **Očekávaný výsledek:**
    - request je odmítnut
    - účet není vytvořen

### TC-002-03 – Otevření účtu s nevalidním typem účtu
- **Use Case:** UC002
- **Typ:** Negative
- **Priorita:** Medium
- **Předpoklady:** Klient existuje.
- **Testovací data:** Nepodporovaný typ účtu.
- **Kroky:**
    1. Odeslat request s nevalidním typem účtu.
    2. Ověřit response.
    3. Ověřit databázi.
- **Očekávaný výsledek:**
    - request je odmítnut
    - účet není vytvořen

### TC-002-04 – Otevření účtu s podporovanou měnou
- **Use Case:** UC002
- **Typ:** Positive
- **Priorita:** Medium
- **Předpoklady:** Klient existuje.
- **Testovací data:** CZK, EUR nebo USD.
- **Kroky:**
    1. Odeslat request s podporovanou měnou.
    2. Ověřit response.
    3. Ověřit hodnotu měny v databázi.
- **Očekávaný výsledek:**
    - účet je vytvořen
    - měna odpovídá requestu

### TC-002-05 – Otevření účtu s počátečním zůstatkem 0
- **Use Case:** UC002
- **Typ:** Boundary
- **Priorita:** High
- **Předpoklady:** Klient existuje.
- **Testovací data:** Počáteční balance 0.
- **Kroky:**
    1. Odeslat request pro otevření účtu.
    2. Ověřit response.
    3. Ověřit balance v databázi.
- **Očekávaný výsledek:**
    - účet je vytvořen
    - balance je 0

---

## UC003 – Deposit Money
### TC-003-01 – Vklad kladné částky
- **Use Case:** UC003
- **Typ:** Positive
- **Priorita:** High
- **Předpoklady:** Účet existuje.
- **Testovací data:** Kladná částka.
- **Kroky:**
    1. Ověřit počáteční balance.
    2. Provést vklad.
    3. Ověřit API response.
    4. Ověřit nový balance.
    5. Ověřit vytvoření DEPOSIT transakce.
- **Očekávaný výsledek:**
    - vklad je úspěšný
    - balance se zvýší o vloženou částku
    - vznikne odpovídající DEPOSIT transakce

### TC-003-02 – Vklad částky 0
- **Use Case:** UC003
- **Typ:** Boundary / Negative
- **Priorita:** High
- **Předpoklady:** Účet existuje.
- **Testovací data:** 0
- **Kroky:**
    1. Ověřit počáteční balance.
    2. Provést vklad částky 0.
    3. Ověřit response.
    4. Ověřit balance a transakce.
- **Očekávaný výsledek:**
    - operace je odmítnuta
    - balance se nezmění
    - nevznikne nežádoucí transakce

### TC-003-03 – Vklad záporné částky
- **Use Case:** UC003
- **Typ:** Negative
- **Priorita:** High
- **Předpoklady:** Účet existuje.
- **Testovací data:** Záporná částka.
- **Kroky:**
    1. Provést vklad záporné částky.
    2. Ověřit response.
    3. Ověřit databázi.
- **Očekávaný výsledek:**
    - operace je odmítnuta
    - nedojde ke změně balance
    - nevznikne nežádoucí transakce

### TC-003-04 – Vklad minimální povolené částky
- **Use Case:** UC003
- **Typ:** Boundary
- **Priorita:** High
- **Předpoklady:** Účet existuje.
- **Testovací data:** 0,01
- **Kroky:**
    1. Provést vklad částky 0,01.
    2. Ověřit response.
    3. Ověřit balance.
    4. Ověřit transakci.
- **Očekávaný výsledek:**
    - operace je úspěšná
    - balance se zvýší o 0,01
    - vznikne DEPOSIT transakce

### TC-003-05 – Vklad na neexistující účet
- **Use Case:** UC003
- **Typ:** Negative
- **Priorita:** High
- **Předpoklady:** Účet neexistuje.
- **Testovací data:** Neexistující ID účtu.
- **Kroky:**
    1. Provést vklad.
    2. Ověřit response.
- **Očekávaný výsledek:**
    - operace je odmítnuta
    - nevznikne transakce

---

## UC004 – Withdraw Money
### TC-004-01 – Výběr částky s dostatečným zůstatkem
- **Use Case:** UC004
- **Typ:** Positive
- **Priorita:** High
- **Předpoklady:** Účet existuje a má dostatečný balance.
- **Testovací data:** Kladná částka nepřevyšující balance.
- **Kroky:**
    1. Ověřit počáteční balance.
    2. Provést výběr.
    3. Ověřit API response.
    4. Ověřit nový balance.
    5. Ověřit WITHDRAWAL transakci.
- **Očekávaný výsledek:**
    - výběr je úspěšný
    - balance se sníží o vybranou částku
    - vznikne odpovídající WITHDRAWAL transakce

### TC-004-02 – Výběr částky 0
- **Use Case:** UC004
- **Typ:** Boundary / Negative
- **Priorita:** High
- **Předpoklady:** Účet existuje.
- **Testovací data:** 0
- **Kroky:**
    1. Provést výběr částky 0.
    2. Ověřit response.
    3. Ověřit balance a transakce.
- **Očekávaný výsledek:**
    - operace je odmítnuta
    - balance se nezmění
    - nevznikne nežádoucí transakce

### TC-004-03 – Výběr záporné částky
- **Use Case:** UC004
- **Typ:** Negative
- **Priorita:** High
- **Předpoklady:** Účet existuje.
- **Testovací data:** Záporná částka.
- **Kroky:**
    1. Provést výběr záporné částky.
    2. Ověřit response.
    3. Ověřit databázi.
- **Očekávaný výsledek:**
    - operace je odmítnuta
    - balance se nezmění

### TC-004-04 – Výběr minimální povolené částky
- **Use Case:** UC004
- **Typ:** Boundary
- **Priorita:** High
- **Předpoklady:** Účet má dostatečný balance.
- **Testovací data:** 0,01
- **Kroky:**
    1. Provést výběr 0,01.
    2. Ověřit response.
    3. Ověřit nový balance.
    4. Ověřit transakci.
- **Očekávaný výsledek:**
    - operace je úspěšná
    - balance se sníží o 0,01
    - vznikne WITHDRAWAL transakce

### TC-004-05 – Výběr vyšší částky než balance
- **Use Case:** UC004
- **Typ:** Negative
- **Priorita:** High
- **Předpoklady:** Účet existuje.
- **Testovací data:** Částka vyšší než aktuální balance.
- **Kroky:**
    1. Ověřit počáteční balance.
    2. Provést výběr vyšší částky.
    3. Ověřit response.
    4. Ověřit balance.
    5. Ověřit transakce.
- **Očekávaný výsledek:**
    - operace je odmítnuta
    - balance se nezmění
    - nevznikne odpovídající WITHDRAWAL transakce

### TC-004-06 – Výběr z neexistujícího účtu
- **Use Case:** UC004
- **Typ:** Negative
- **Priorita:** High
- **Předpoklady:** Účet neexistuje.
- **Testovací data:** Neexistující ID účtu.
- **Kroky:**
    1. Provést výběr.
    2. Ověřit response.
- **Očekávaný výsledek:**
    - operace je odmítnuta
    - databáze není změněna

---

## UC005 – Transfer Money
### TC-005-01 – Převod mezi dvěma existujícími účty
- **Use Case:** UC005
- **Typ:** Positive
- **Priorita:** High
- **Předpoklady:** Zdrojový i cílový účet existují a zdrojový účet má dostatečný balance.
- **Testovací data:** Validní zdrojový účet, cílový účet a kladná částka.
- **Kroky:**
    1. Ověřit počáteční balance obou účtů.
    2. Provést převod.
    3. Ověřit API response.
    4. Ověřit balance obou účtů.
    5. Ověřit Transfer.
    6. Ověřit OUTBOUND a INBOUND transakce.
- **Očekávaný výsledek:**
    - převod je úspěšný
    - zdrojový účet je snížen o částku
    - cílový účet je zvýšen o částku
    - Transfer má očekávaný stav
    - vzniknou odpovídající transakce

### TC-005-02 – Převod částky 0
- **Use Case:** UC005
- **Typ:** Boundary / Negative
- **Priorita:** High
- **Předpoklady:** Oba účty existují.
- **Testovací data:** 0
- **Kroky:**
    1. Ověřit počáteční balance.
    2. Provést převod částky 0.
    3. Ověřit response.
    4. Ověřit databázi.
- **Očekávaný výsledek:**
    - převod je odmítnut
    - balance účtů se nezmění
    - nevzniknou nežádoucí transakce

### TC-005-03 – Převod záporné částky
- **Use Case:** UC005
- **Typ:** Negative
- **Priorita:** High
- **Předpoklady:** Oba účty existují.
- **Testovací data:** Záporná částka.
- **Kroky:**
    1. Provést převod záporné částky.
    2. Ověřit response.
    3. Ověřit databázi.
- **Očekávaný výsledek:**
    - převod je odmítnut
    - nedojde ke změně zůstatků

### TC-005-04 – Převod minimální povolené částky
- **Use Case:** UC005
- **Typ:** Boundary
- **Priorita:** High
- **Předpoklady:** Zdrojový účet má dostatečný balance.
- **Testovací data:** 0,01
- **Kroky:**
    1. Provést převod částky 0,01.
    2. Ověřit response.
    3. Ověřit oba balance.
    4. Ověřit transakce.
- **Očekávaný výsledek:**
    - převod je úspěšný
    - zdrojový účet se sníží o 0,01
    - cílový účet se zvýší o 0,01

### TC-005-05 – Převod bez dostatečného zůstatku
- **Use Case:** UC005
- **Typ:** Negative
- **Priorita:** High
- **Předpoklady:** Zdrojový účet má nedostatečný balance.
- **Testovací data:** Částka vyšší než balance zdrojového účtu.
- **Kroky:**
    1. Ověřit počáteční balance.
    2. Provést převod.
    3. Ověřit response.
    4. Ověřit oba účty.
    5. Ověřit Transfer a transakce.
- **Očekávaný výsledek:**
    - převod je odmítnut
    - balance obou účtů se nezmění
    - nevznikne nežádoucí převod nebo transakce

### TC-005-06 – Převod na stejný účet
- **Use Case:** UC005
- **Typ:** Negative
- **Priorita:** High
- **Předpoklady:** Účet existuje.
- **Testovací data:** Stejný účet jako source a target.
- **Kroky:**
    1. Provést převod na stejný účet.
    2. Ověřit response.
    3. Ověřit databázi.
- **Očekávaný výsledek:**
    - převod je odmítnut
    - nedojde ke změně balance
    - nevzniknou nežádoucí transakce

### TC-005-07 – Převod na neexistující cílový účet
- **Use Case:** UC005
- **Typ:** Negative
- **Priorita:** High
- **Předpoklady:** Zdrojový účet existuje.
- **Testovací data:** Neexistující cílový účet.
- **Kroky:**
    1. Ověřit balance zdrojového účtu.
    2. Provést převod.
    3. Ověřit response.
    4. Ověřit databázi.
- **Očekávaný výsledek:**
    - převod je odmítnut
    - zdrojový účet se nezmění
    - nevzniknou nežádoucí transakce

---

## UC006 – Issue Card
### TC-006-01 – Vydání karty pro existující účet
- **Use Case:** UC006
- **Typ:** Positive
- **Priorita:** High
- **Předpoklady:** Účet existuje.
- **Testovací data:** Existující účet.
- **Kroky:**
    1. Provést request pro vydání karty.
    2. Ověřit API response.
    3. Ověřit kartu v databázi.
- **Očekávaný výsledek:**
    - karta je vytvořena
    - karta má unikátní číslo
    - karta má stav ACTIVE
    - karta je navázána na správný účet

### TC-006-02 – Vydání karty pro neexistující účet
- **Use Case:** UC006
- **Typ:** Negative
- **Priorita:** High
- **Předpoklady:** Účet neexistuje.
- **Testovací data:** Neexistující ID účtu.
- **Kroky:**
    1. Provést request pro vydání karty.
    2. Ověřit response.
    3. Ověřit databázi.
- **Očekávaný výsledek:**
    - request je odmítnut
    - karta není vytvořena

### TC-006-03 – Ověření formátu čísla karty
- **Use Case:** UC006
- **Typ:** Positive / Boundary
- **Priorita:** Medium
- **Předpoklady:** Karta byla vydána.
- **Testovací data:** Nově vytvořená karta.
- **Kroky:**
    1. Vydat kartu.
    2. Ověřit číslo karty v response.
    3. Ověřit číslo karty v databázi.
- **Očekávaný výsledek:**
    - číslo karty obsahuje 16 číslic
    - číslo odpovídá uložené hodnotě

### TC-006-04 – Vydání více karet pro stejný účet
- **Use Case:** UC006
- **Typ:** Positive
- **Priorita:** Medium
- **Předpoklady:** Účet existuje.
- **Testovací data:** Existující účet.
- **Kroky:**
    1. Vydat první kartu.
    2. Vydat druhou kartu pro stejný účet.
    3. Ověřit obě karty.
- **Očekávaný výsledek:**
    - obě karty jsou vytvořeny
    - každá karta má vlastní unikátní číslo
    - obě karty jsou navázány na správný účet

### TC-006-05 – Ověření výchozího stavu karty
- **Use Case:** UC006
- **Typ:** Positive
- **Priorita:** High
- **Předpoklady:** Účet existuje.
- **Testovací data:** Nově vydaná karta.
- **Kroky:**
    1. Vydat kartu.
    2. Ověřit stav karty.
    3. Ověřit stav v databázi.
- **Očekávaný výsledek:**
    - nová karta má stav ACTIVE

---

## UC007 – Block Card
### TC-007-01 – Zablokování aktivní karty
- **Use Case:** UC007
- **Typ:** Positive
- **Priorita:** High
- **Předpoklady:** Karta existuje a má stav ACTIVE.
- **Testovací data:** Aktivní karta.
- **Kroky:**
    1. Ověřit výchozí stav karty.
    2. Provést request pro zablokování karty.
    3. Ověřit API response.
    4. Ověřit stav karty v databázi.
- **Očekávaný výsledek:**
    - operace je úspěšná
    - stav karty se změní z ACTIVE na BLOCKED

### TC-007-02 – Opakované zablokování zablokované karty
- **Use Case:** UC007
- **Typ:** Negative
- **Priorita:** High
- **Předpoklady:** Karta má stav BLOCKED.
- **Testovací data:** Zablokovaná karta.
- **Kroky:**
    1. Ověřit výchozí stav karty.
    2. Pokusit se kartu znovu zablokovat.
    3. Ověřit response.
    4. Ověřit databázi.
- **Očekávaný výsledek:**
    - operace je odmítnuta
    - stav karty zůstane BLOCKED

### TC-007-03 – Zablokování neexistující karty
- **Use Case:** UC007
- **Typ:** Negative
- **Priorita:** High
- **Předpoklady:** Karta neexistuje.
- **Testovací data:** Neexistující ID karty.
- **Kroky:**
    1. Provést request pro zablokování karty.
    2. Ověřit response.
- **Očekávaný výsledek:**
    - operace je odmítnuta
    - nedojde ke změně databáze

### TC-007-04 – Zablokování karty ve stavu EXPIRED
- **Use Case:** UC007
- **Typ:** Negative
- **Priorita:** High
- **Předpoklady:** Karta má stav EXPIRED.
- **Testovací data:** Expirovaná karta.
- **Kroky:**
    1. Ověřit výchozí stav karty.
    2. Pokusit se kartu zablokovat.
    3. Ověřit response.
    4. Ověřit stav v databázi.
- **Očekávaný výsledek:**
    - operace je odmítnuta
    - stav karty zůstane EXPIRED

---

# 4. Plánované Test Cases
Pro dosud neimplementované Use Cases budou Test Cases doplněny před zahájením jejich testování.

Plánované Use Cases:
- UC008 – Unblock Card
- UC009 – Account Detail
- UC010 – Client Accounts
- UC011 – Transaction History
- UC012 – Transfer Detail
- UC013 – Close Account

Test Cases budou navrženy podle business požadavků příslušného Use Case a podle principů definovaných v `TEST_PLAN.md` a `testing/TESTING.md`.

---

# 5. Identifikace Test Cases
ID testovacích scénářů používá formát:
`TC-[UC]-[číslo]`

Příklad:
`TC-008-01`

kde:
- `TC` = Test Case
- `008` = Use Case UC008
- `01` = pořadové číslo testovacího scénáře

Test Case ID je stabilní identifikátor a nemění se při opakovaném provedení testu.

---

# 6. Údržba dokumentu
Test Cases se aktualizují při:
- přidání nového Use Case
- změně business požadavku
- změně business pravidla
- identifikaci chybějícího testovacího scénáře
- významné změně funkcionality

Výsledky konkrétního provedení testů se do tohoto dokumentu nezapisují. Výsledky patří do `docs/qa/TEST_RUNS.md`. Pokud změna vyvolá potřebu nového nebo upraveného testovacího scénáře, musí být odpovídajícím způsobem aktualizována také traceability v `docs/qa/TRACEABILITY.md`.