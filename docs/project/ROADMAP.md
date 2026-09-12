# Roadmapa projektu
## Projekt: Aegis Core Banking System
Aegis je studijní a portfolio projekt zaměřený na simulaci práce junior manual QA v bankovním a enterprise prostředí. Roadmapa určuje plánovaný rozsah projektu a pořadí hlavních milníků.

Aktuální stav projektu je veden v `CURRENT_STATE.md`.

---

# 1. část – Minimum
Povinný rozsah projektu zaměřený na vytvoření funkčního bankovního systému a základní praktické zkušenosti s testováním.

## Fáze 1 – Databázový základ
### Databázový model
- Návrh logického databázového modelu – dokončeno
- Fyzické databázové schéma – dokončeno
- Testovací data – dokončeno
- SQL cvičení – dokončeno
- SQL validační testy – dokončeno

## Fáze 2 – Backendový základ
### Backend
- Základní Spring Boot aplikace – dokončeno
- JPA entity a relace – dokončeno
- Repository vrstva – dokončeno
- Základní REST API architektura – dokončeno

## Fáze 3 – Základní bankovní funkcionalita
### Client Management
- UC001 – Client Management – dokončeno
- PR-001 – Project Review po UC001 – dokončeno
- TECH-001 – Globální zpracování výjimek – dokončeno
- TECH-002 – Validace vstupních dat – dokončeno
- PR-002 – Project Review po TECH-001 a TECH-002 – dokončeno

### Account Management
- UC002 – Open Account – dokončeno
- PR-003 – Project Review po UC002 – dokončeno

### Account Transactions
- UC003 – Deposit Money – dokončeno
- PR-004 – Project Review po UC003 – dokončeno
- TECH-006 – Izolace testovací databáze – dokončeno
- PR-005 – Project Review po TECH-006 – dokončeno
- UC004 – Withdraw Money – dokončeno
- PR-006 – Project Review po UC004 – dokončeno
- UC005 – Transfer Money – dokončeno
- PR-007 – Project Review po UC005 – dokončeno

### Card Management
- UC006 – Issue Card – dokončeno
- PR-008 – Project Review po UC006 – dokončeno
- UC007 – Block Card – dokončeno
- PR-009 – Project Review po UC007 – dokončeno
- UC008 – Unblock Card – dokončeno
- PR-010 - Project Review po UC008 - dokončeno

### Account & Transaction Queries
- UC009 – Zobrazení detailu účtu – plánováno
- UC010 – Zobrazení účtů klienta – plánováno
- UC011 – Zobrazení historie transakcí účtu – plánováno
- UC012 – Zobrazení detailu převodu – plánováno

### Account Lifecycle
- UC013 – Uzavření účtu – plánováno

---

# 2. část – Optimum / Portfolio
Rozšíření projektu zaměřené na vytvoření realistického QA portfolia.

## Fáze 4 – QA dokumentace
- Test Plan včetně Test Strategy – dokončeno
- Traceability Matrix – dokončeno
- Test Cases – dokončeno
- Test Data – dokončeno
- Test Runs – připraveno pro evidenci skutečných běhů

## Fáze 5 – Testovací pokrytí
- Happy-path scénáře – plánováno
- Negativní scénáře – plánováno
- Hraniční scénáře – plánováno
- Regresní scénáře – plánováno
- Minimálně dva evidované Test Runs – plánováno

## Fáze 6 – Bug Management
- Bug Reports – plánováno
- Reprodukce nalezených vad – plánováno
- Severity a Priority – plánováno
- Evidence opravy a retestu – plánováno

## Fáze 7 – Release-like assessment
- Vyhodnocení výsledků testování – plánováno
- Identifikace zbývajících rizik – plánováno
- Release / No Release rozhodnutí – plánováno
- QA-oriented README – plánováno

---

# 3. část – Bonus / Bridge (BB)
Nepovinné rozšíření připravující přechod k projektu #2.

## Fáze 8 – Handover a lokální zdroj pravdy
- Ruční ověření převzetí projektu pouze z dokumentace a zdrojů – plánováno
- Krátký technický zápis o převzetí projektu – plánováno
- Inventura lokálních souborů a dokumentační struktury – volitelné

## Fáze 9 – Náhled na další projekt
- Identifikace jedné hranice systému vhodné pro API kontrakt – plánováno
- Návrh malé testovací matice pro API kontrakt – plánováno

Bonus nesmí rozšířit Aegis na samostatný projekt zaměřený na API automation nebo CI. Tyto oblasti patří do následujících projektů.

---

# Aktuální milestone
- ✅️ Dokončeno: UC001–UC008 a PR-001–PR-010
- ⌛ Aktuálně: dokončená část základní bankovní funkcionality
- ⏳ Následuje: UC009 – Zobrazení detailu účtu

---

# Pravidla roadmapy
- Roadmapa určuje plánovaný rozsah a pořadí projektu.
- Aktuální stav jednotlivých položek je současně udržován v `CURRENT_STATE.md`.
- Detailní business požadavky jsou vedeny v `BUSINESS_REQUIREMENTS.md`.
- Technický dluh je veden v `docs/technical/TECHNICAL_BACKLOG.md`.
- Vývojový workflow je popsán v `docs/development/DEVELOPMENT_WORKFLOW.md`.
- Historie skutečně provedených změn je vedena v `docs/CHANGELOG.md`.

Každý Use Case prochází standardním vývojovým workflow a Project Review. 
Nový Use Case nezačíná před dokončením předchozího Use Casu a všech relevantních High Priority položek.
Roadmapa se aktualizuje pouze při změně plánovaného rozsahu, pořadí nebo stavu významného milníku.