# Technický backlog

## Účel
Tento dokument obsahuje technická zlepšení, která byla během vývoje identifikována, ale záměrně odložena na pozdější fázi projektu.

Cílem je oddělit vývoj nové funkcionality od refaktoringu a architektonických úprav, aby jednotlivé feature branche řešily vždy pouze jeden konkrétní úkol.

---

## Pravidla práce s backlogem
Technical Backlog obsahuje technické úkoly, které byly během vývoje identifikovány, ale nebyly implementovány v rámci aktuálního business Use Casu.

Nové položky vznikají během **Project Review**.

Implementace backlogu probíhá podle priority:

### High Priority
Implementuje se bezprostředně po dokončení Project Review aktuálního Use Casu.

Typicky:
- společná infrastruktura projektu,
- Exception Handling,
- Bean Validation,
- změny ovlivňující všechny budoucí funkcionality.

### Medium Priority
Implementuje se po dokončení několika Use Casů nebo během plánovaného refaktoringu.

Typicky:
- odstranění duplicitního kódu,
- architektonické úpravy,
- optimalizace stávající implementace.

### Low Priority
Volitelná nebo kosmetická vylepšení projektu.

Podrobný vývojový workflow je popsán v dokumentu:

`DEVELOPMENT_WORKFLOW.md`

---

# Vysoká priorita

## TECH-001 – Globální zpracování výjimek

**Stav:** ✅ Dokončeno

**Popis:**
Nahradit ruční vracení HTTP chyb ve všech controllerech centrálním zpracováním pomocí `@ControllerAdvice`.

**Důvod:**
Jednotnější chování API, méně duplicitního kódu a lepší dodržování doporučených postupů Spring Boot.

---

## TECH-002 – Validace vstupních dat

**Stav:** ✅ Dokončeno

**Popis:**
Přidat validaci DTO pomocí Jakarta Bean Validation (`@NotBlank`, `@Email`, `@Size` apod.).

**Důvod:**
V současnosti API přijímá i neplatná vstupní data.

---

## TECH-006 – Izolace testovací databáze

**Stav:** ✅ Dokončeno

**Popis:**
Oddělit automatizované integrační testy od persistentních aplikačních/testovacích dat tak, aby jednotlivé testy nebyly navzájem ovlivňovány změnami databázového stavu.

**Důvod:**
Současné integrační testy používají stejnou MySQL databázi a mohou měnit persistentní data. To způsobuje závislost testů na pořadí jejich spuštění a může vést k nepředvídatelným výsledkům.

**Cíl:**
Zajistit izolované a opakovatelné automatizované testy.

---

# Střední priorita

## TECH-003 – Refaktoring mapování DTO

**Stav:** Plánováno

**Popis:**
Vytvořit společnou metodu pro převod `Client` → `ClientResponse`.

**Důvod:**
Stejný mapovací kód se opakuje ve více metodách služby.

---

## TECH-004 – Soft Delete klientů

**Stav:** Plánováno

**Popis:**
Nahradit fyzické mazání klientů logickým mazáním pomocí příznaku `active` nebo stavového atributu.

**Důvod:**
Bankovní systémy standardně historická data fyzicky nemažou.

---

## TECH-005 – Automatizované testy UC002

**Stav:** Plánováno

**Popis:**
Doplnit automatizované testy pro funkcionalitu UC002 – Open Account.

**Rozsah:**
- test úspěšného vytvoření účtu,
- test neexistujícího klienta,
- test neplatného typu účtu,
- test nepodporované měny,
- test nevalidních vstupních dat.

**Důvod:**
UC002 je v současnosti ověřen pomocí Maven/JUnit testů, Postmanu a DBeaveru. Automatizované testy zaměřené přímo na business scénáře UC002 zvýší regresní pokrytí při dalších změnách.

## TECH-008 – Refaktorizace endpointů Deposit/Withdraw

**Stav:** Plánováno

**Popis:**
Refaktorovat endpointy pro vklad a výběr peněz z `/accounts/{id}/deposit` a `/accounts/{id}/withdraw` na transakčně orientované endpointy.

**Navrhovaný cílový design:**
- POST /transactions/deposit
- POST /transactions/withdraw

**Důvod:**
Deposit a Withdraw vytvářejí finanční Transaction a z pohledu doménového návrhu je vhodnější, aby jejich API odpovědnost odpovídala transakční doméně.

**Rozsah:**
- vytvoření TransactionController,
- přesun odpovědnosti pro Deposit/Withdraw z AccountController,
- odpovídající úprava service vrstvy,
- zachování stávající business funkcionality a testovacího pokrytí,
- aktualizace související dokumentace a Postman requestů.

**Priorita:** Medium

**Poznámka:**
Refaktorizace není součástí žádného UC a bude řešena jako samostatný technický úkol.

---

# Nízká priorita

## TECH-007 – Odstranění duplicity testovacích dat

**Stav:** Plánováno

**Popis:**
Odstranit duplicitu mezi `database/test_reset.sql` a `src/test/resources/test_reset.sql`.

**Důvod:**
Stejný dataset je udržován ve dvou souborech, což může vést k jejich nekonzistenci.

**Cíl:**
Zajistit jediný zdroj testovacích dat a odstranit duplicitní údržbu.

---

## Aktuální plán implementace
### Dokončeno
- UC001 – Client Management
- PR-001 – Project Review po UC001
- TECH-001 – Globální zpracování výjimek
- TECH-002 – Validace vstupních dat
- PR-002 – Project Review po TECH-002
- UC002 – Open Account
- PR-003 – Project Review po UC002
- UC003 - Deposit Money
- PR-004 - Project Review po UC003
- TECH-006 - Izolace testovací databáze
- PR-005 - Project Review po TECH-006
- UC004 - Withdraw Money
- PR-006 - Project Review po UC004
- UC005 - Transfer Money
- PR-007 - Project Review po UC005
- UC006 - Issue Card

### High Priority

### Medium Priority
- TECH-003 – Refaktoring mapování DTO
- TECH-004 – Soft Delete klientů
- TECH-005 – Automatizované testy UC002
- TECH-008 – Refaktorizace endpointů Deposit/Withdraw

### Low Priority
- TECH-007 – Odstranění duplicity testovacích dat

### Následuje
- PR-008 - Project Review po UC006

### Poznámky: