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

### High Priority
- Žádné

### Medium Priority
- TECH-003 – Refaktoring mapování DTO
- TECH-004 – Soft Delete klientů
- TECH-005 – Automatizované testy UC002

### Následuje
- UC003 – Deposit Money

### Poznámky:
Během implementace a automatizovaného testování UC003 bylo zjištěno, že integrační testy používají stejnou MySQL databázi jako aplikace a mohou měnit persistentní testovací data. Tento problém bude vyhodnocen během PR-004 a případně bude vytvořena samostatná položka Technical Backlog s odpovídající prioritou.