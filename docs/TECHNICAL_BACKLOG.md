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

**Stav:** Plánováno

**Popis:**
Nahradit ruční vracení HTTP chyb ve všech controllerech centrálním zpracováním pomocí `@ControllerAdvice`.

**Důvod:**
Jednotnější chování API, méně duplicitního kódu a lepší dodržování doporučených postupů Spring Boot.

---

## TECH-002 – Validace vstupních dat

**Stav:** Plánováno

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

---

## Aktuální plán implementace
### Probíhá
- Project Review #1

### Následuje
1. TECH-001 – Globální zpracování výjimek
2. TECH-002 – Validace vstupních dat

Po dokončení těchto položek bude zahájena implementace:

- UC002 – Open Account