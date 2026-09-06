# Dokumentace
Tento adresář obsahuje projektovou dokumentaci k projektu Aegis Core Banking System. Dokumentace je rozdělena podle účelu jednotlivých dokumentů.

---

## Projekt
### `project/PROJECT_VISION.md`

Dlouhodobá vize projektu, hlavní cíle a budoucí směřování.

### `project/PROJECT_CONTEXT.md`
Stabilní kontext projektu, jeho účel, doména, technický kontext a vztah k profesnímu cíli.

### `project/CURRENT_STATE.md`
Aktuální stav projektu, dokončené milníky, další Use Case, stav technického dluhu a stav dokumentace.

### `project/ROADMAP.md`
Plán vývoje projektu, jednotlivé části, fáze, Use Cases, technické úkoly a budoucí rozšíření.

---

## Business
### `business/BUSINESS_REQUIREMENTS.md`
Business požadavky projektu a definice jednotlivých Use Cases.

---

## Development
### `development/DEVELOPMENT_WORKFLOW.md`
Standardizovaný workflow projektu včetně životního cyklu Use Case, Git workflow, Project Review, Technical Backlog, Definition of Done a pravidel práce s AI.

---

## Technical
### `technical/TECH_STACK.md`
Používané technologie, nástroje a vývojové prostředí.

### `technical/DATABASE_MODEL.md`
Logický a fyzický kontext databázového modelu projektu včetně entit, vztahů, atributů a databázových omezení.

### `technical/TECHNICAL_BACKLOG.md`
Evidence technického dluhu, architektonických zlepšení a plánovaných technických úkolů.

---

## QA
### `qa/TEST_PLAN.md`
Testovací plán, cíle, rozsah, strategie, testovací úrovně, prostředí, entry/exit criteria a rizika.

### `qa/TEST_CASES.md`
Konkrétní testovací scénáře pro jednotlivé Use Cases.

### `qa/TEST_DATA.md`
Přehled účelu a použití testovacích dat pro jednotlivé testovací scénáře.

### `qa/TEST_RUNS.md`
Evidence skutečně provedených Test Runs a jejich výsledků.

### `qa/TRACEABILITY.md`
Vazby mezi business požadavky, Use Cases, Test Cases, Test Data, Test Runs a bug reporty.

### `qa/RELEASE_ASSESSMENT.md`
Závěrečné QA vyhodnocení testované verze a release-like rozhodnutí.

---

## Další projektové artefakty
### `CHANGELOG.md`
Historie významných změn projektu.

---

## Praktická metodika testování
### `../testing/TESTING.md`

Praktická metodika manuálního testování používaná v projektu.

Obsahuje principy:
- přípravy testování
- API testování
- databázového ověřování
- pozitivních, negativních a hraničních scénářů
- regresního testování
- evidence důkazů
- reprodukce chyb
- QA Review

---

## Související adresáře
### `../database/`
Databázové artefakty projektu:
- `schema.sql`
- `test_data.sql`
- `test_data_part2.sql`
- `test_reset.sql`
- `SQL_EXERCISES.md`
- `SQL_VALIDATION.md`

### `../jira/`
Evidence bug reportů:
- `BUG_REPORTS.md`

### `../postman/`
Postman artefakty používané pro testování REST API.

---

## Zdroj pravdy
Dokumentace projektu je rozdělena podle účelu jednotlivých artefaktů.

Aktuální stav projektu je veden v:
`project/CURRENT_STATE.md`

Plán projektu je veden v:
`project/ROADMAP.md`

Business požadavky jsou vedeny v:
`business/BUSINESS_REQUIREMENTS.md`

Technický dluh je veden v:
`technical/TECHNICAL_BACKLOG.md`

Testovací dokumentace je vedena v:
`qa/`

Pravidla vývojového workflow jsou vedena v:
`development/DEVELOPMENT_WORKFLOW.md`