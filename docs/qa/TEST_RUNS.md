# Test Runs
## Aegis Core Banking System

## 1. Účel
Tento dokument slouží k evidenci skutečně provedených testovacích běhů projektu Aegis Core Banking System. Test Run představuje konkrétní provedení skupiny testovacích případů v určitém prostředí, s konkrétními testovacími daty a s zaznamenaným výsledkem.

Dokument slouží především jako:
- evidence provedeného testování
- historický záznam testovacích běhů
- podklad pro regresní testování
- evidence nalezených chyb
- podklad pro QA hodnocení projektu

Test Cases definují **co se má testovat**. 

Test Data definují **s jakými daty se testuje**.

Test Runs evidují **co bylo skutečně provedeno a s jakým výsledkem**.

---

## 2. Princip evidence
Každý skutečně provedený testovací běh má být zaznamenán samostatně.

Test Run by měl obsahovat minimálně:
- identifikaci testovacího běhu
- datum provedení
- testovaný rozsah
- použité testovací případy
- použité testovací prostředí
- použitá testovací data
- výsledek testování
- případné nalezené chyby
- relevantní poznámky nebo důkazy

Do dokumentu se zapisují pouze skutečně provedené testy. Výsledky testování nesmí být doplňovány pouze na základě předpokladu nebo očekávaného chování systému.

---

## 3. Struktura Test Run
Každý Test Run používá následující strukturu:

### Test Run ID
Jedinečný identifikátor testovacího běhu.

Formát:
`TR-[číslo]`

Příklad:
`TR-001`

### Datum
Datum skutečného provedení testovacího běhu.

### Scope
Use Case nebo oblast systému, která byla testována.

Příklad:
`UC005 – Transfer Money`

### Test Cases
Seznam provedených Test Case ID.

Příklad:
`TC-005-01, TC-005-02, TC-005-03`

### Test Environment
Prostředí, ve kterém testování proběhlo.

Příklad:
- Windows
- Spring Boot application
- MySQL test database
- Postman
- DBeaver

### Test Data
Identifikace použitých Test Data.

Příklad:
`TD-005-01, TD-005-02`

### Result
Celkový výsledek testovacího běhu.

Používané hodnoty:
- `PASS`
- `FAIL`
- `BLOCKED`

### Bugs
Odkazy na případné nalezené bugy v `jira/BUG_REPORTS.md`.

Pokud nebyl nalezen žádný bug:
`None`

### Evidence
Odkaz nebo popis dostupných důkazů o provedeném testování.

Může se jednat například o:
- Postman response
- SQL dotaz a výsledek
- screenshot
- log
- reprodukční postup
- jiný relevantní důkaz

### Notes
Doplňující poznámky k testovacímu běhu.

---

## 4. Výsledky testování
### PASS
Testovací případ nebo testovací běh splnil očekávané chování.

### FAIL
Testovací případ nebo testovací běh nesplnil očekávané chování. V případě `FAIL` má být zaznamenán odpovídající bug report, pokud je chyba relevantní pro evidenci projektu.

### BLOCKED
Testování nebylo možné dokončit kvůli překážce, která znemožnila provedení testu.

Například:
- nedostupné testovací prostředí
- chybějící testovací data
- nefunkční závislá funkcionalita
- jiná překážka znemožňující provedení testu

---

## 5. Evidence Test Runs
Aktuální testovací běhy budou doplňovány podle skutečně provedeného testování. Každý skutečně provedený Test Run musí být zaznamenán podle struktury uvedené v tomto dokumentu. Do dokumentu se nezapisují hypotetické nebo neprovedené Test Runs.

<!-- Vzor zápisu:
### TR-001
- **Datum:** TBD
- **Scope:** TBD
- **Test Cases:** TBD
- **Test Environment:** TBD
- **Test Data:** TBD
- **Result:** TBD
- **Bugs:** TBD
- **Evidence:** TBD
- **Notes:** TBD
-->

### TR-008 (po UC008)
- **Datum:** 2026-09-12
- **Scope:** UC008 – Unblock Card
- **Test Cases:** TC-008-01, TC-008-02, TC-008-03, TC-008-04
- **Test Environment:**
    - Windows
    - Spring Boot application
    - MySQL test database
    - Postman
    - DBeaver
    - Maven / JUnit
- **Test Data:** TD-008-01, TD-008-02, TD-008-03, TD-008-04
- **Result:** PASS
- **Bugs:** None
- **Evidence:**
    - automatizované controller testy pro TC-008-01 až TC-008-04
    - Postman ověření všech čtyř scénářů
    - SQL ověření výsledného stavu karty po úspěšném odblokování
- **Notes:** Všechny pozitivní, negativní a relevantní stavové scénáře UC008 byly úspěšně ověřeny. Při úspěšném odblokování byla ověřena změna BLOCKED → ACTIVE a zachování ostatních atributů karty.

---

### TR-009 (po UC009)
- **Datum:** 2026-09-13
- **Scope:** UC009 – Account Detail
- **Test Cases:** TC-009-01, TC-009-02, TC-009-03, TC-009-04
- **Test Environment:**
  - Windows
  - Spring Boot application
  - MySQL test database
  - Postman
  - DBeaver
  - Maven / JUnit
- **Test Data:** TD-009-01, TD-009-02
- **Result:** PASS
- **Bugs:** None
- **Evidence:**
  - automatizované controller testy pro TC-009-01 až TC-009-04
  - Postman ověření pozitivního a negativního scénáře
  - SQL ověření dat účtu v databázi
  - ověření, že GET operace nezměnila stav účtu
  - opakovaná reprodukce pozitivního a negativního scénáře
- **Notes:** Všechny scénáře UC009 byly úspěšně ověřeny. Ověřeno zobrazení detailu existujícího účtu, zpracování neexistujícího účtu, nulový zůstatek a zachování stavu databáze při GET operaci.

---

## 6. Regression Testing
Test Runs mohou být použity jako podklad pro regresní testování.

Při regresním testování se zaznamenává:
- která funkcionalita byla znovu testována
- které Test Cases byly použity
- důvod regresního testování
- výsledek
- případné nově nalezené chyby

Regresní testování může být provedeno například po:
- implementaci nového Use Case
- opravě chyby
- změně databázového modelu
- změně business logiky
- významné refaktorizaci
- jiné změně, která může ovlivnit již existující funkcionalitu

---

## 7. Vazba na ostatní QA artefakty
Test Runs jsou propojeny s ostatními QA dokumenty:
- `docs/qa/TEST_PLAN.md` – definuje plán a strategii testování
- `docs/qa/TEST_CASES.md` – definuje jednotlivé Test Cases
- `docs/qa/TEST_DATA.md` – definuje účel a použití testovacích dat
- `docs/qa/TRACEABILITY.md` – propojuje požadavky, Test Cases a výsledky testování
- `docs/qa/RELEASE_ASSESSMENT.md` – využívá výsledky testování pro závěrečné QA hodnocení
- `testing/TESTING.md` – popisuje praktickou metodiku manuálního testování
- `jira/BUG_REPORTS.md` – eviduje nalezené chyby

Skutečná data používaná při testování jsou uložena v:
`database/test_data.sql`
`database/test_data_part2.sql`

---

## 8. Údržba dokumentu
Test Runs se aktualizují po provedení významného testovacího běhu.

Při každém záznamu musí být zachována vazba na:
- Test Cases
- Test Data
- testovací prostředí
- výsledek
- případné bugy
- dostupné důkazy

Historické výsledky testování se nemají zpětně měnit bez důvodu. Nové Test Runs se přidávají jako nové záznamy. Tento dokument obsahuje výsledky skutečně provedeného testování, nikoliv plánované nebo hypotetické výsledky.