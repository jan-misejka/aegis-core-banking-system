# Release Assessment
## Aegis Core Banking System

## 1. Účel
Tento dokument slouží k závěrečnému QA hodnocení aktuálního stavu projektu před release-like předáním.

Cílem je posoudit, zda implementovaný rozsah:
- odpovídá business požadavkům
- má odpovídající testovací pokrytí
- byl skutečně otestován
- neobsahuje známé kritické problémy
- má dostupné důkazy o provedeném testování
- je z pohledu QA připraven k release-like předání

Dokument představuje QA hodnocení konkrétního stavu projektu, nikoliv obecný plán testování.

---

## 2. Hodnocený rozsah
Release assessment musí vždy uvádět konkrétní rozsah, který byl hodnocen.

### Implementovaný rozsah
- **UC001 – Client Management:** TBD
- **UC002 – Open Account:** TBD
- **UC003 – Deposit Money:** TBD
- **UC004 – Withdraw Money:** TBD
- **UC005 – Transfer Money:** TBD
- **UC006 – Issue Card:** TBD
- **UC007 – Block Card:** TBD
- **UC008 – Unblock Card:** TBD
- **UC009 – Account Detail:** TBD
- **UC010 – Client Accounts:** TBD
- **UC011 – Transaction History:** TBD
- **UC012 – Transfer Detail:** TBD
- **UC013 – Close Account:** TBD

### Hodnocený Test Run
`TBD`

### Datum hodnocení
`TBD`

---

## 3. QA vstupní podklady
Release assessment vychází zejména z těchto artefaktů:
- `docs/business/BUSINESS_REQUIREMENTS.md`
- `docs/qa/TEST_PLAN.md`
- `docs/qa/TEST_CASES.md`
- `docs/qa/TEST_DATA.md`
- `docs/qa/TEST_RUNS.md`
- `docs/qa/TRACEABILITY.md`
- `testing/TESTING.md`
- `jira/BUG_REPORTS.md`
- `docs/technical/TECHNICAL_BACKLOG.md`

Podle potřeby mohou být použity také:
- výsledky API testování
- výsledky databázového ověření
- další důkazy z provedeného testování

---

## 4. Testovací pokrytí
Hodnotí se, zda jsou požadavky hodnoceného rozsahu pokryty odpovídajícími Test Cases.

| Oblast             | Stav | Poznámka |
|--------------------|------|----------|
| Business požadavky | TBD  | TBD      |
| Test Cases         | TBD  | TBD      |
| Test Data          | TBD  | TBD      |
| Test Runs          | TBD  | TBD      |
| Traceability       | TBD  | TBD      |
| Regression Testing | TBD  | TBD      |

---

## 5. Výsledky testování
Závěrečné hodnocení musí vycházet ze skutečně provedených Test Runs.

### Výsledky
- **PASS:** TBD
- **FAIL:** TBD
- **BLOCKED:** TBD

### Celkové hodnocení testování
`TBD`

Výsledky nesmí být doplňovány pouze na základě očekávaného chování systému.

---

## 6. Defect Assessment
Hodnotí se známé chyby zjištěné během testování.

### Kritické chyby
`TBD`

### Vysoké chyby
`TBD`

### Střední chyby
`TBD`

### Nízké chyby
`TBD`

### Celkové hodnocení defectů
`TBD`

Relevantní chyby musí být dohledatelné v:
`jira/BUG_REPORTS.md`

---

## 7. Technický dluh
Při release assessmentu se posuzuje také aktuální stav technického dluhu.

Zdroj:
`docs/technical/TECHNICAL_BACKLOG.md`

### Stav
`TBD`

### Dopad na release-like předání
`TBD`

Technický dluh se neposuzuje pouze podle jeho existence, ale podle jeho priority a potenciálního dopadu na funkčnost, testovatelnost a stabilitu systému.

---

## 8. Regression Assessment
Hodnotí se, zda byly po významných změnách provedeny odpovídající regresní testy.

### Regression Testing
- **Provedeno:** TBD
- **Rozsah:** TBD
- **Výsledek:** TBD

### Závěr
`TBD`

---

## 9. Business Requirements Assessment
Hodnotí se shoda implementovaného chování s business požadavky.

### Hodnocení
- požadavky jsou dohledatelné
- požadavky mají odpovídající testovací pokrytí
- pozitivní scénáře jsou ověřeny
- negativní scénáře jsou ověřeny
- hraniční scénáře jsou ověřeny
- relevantní business pravidla jsou ověřena

### Výsledek
`TBD`

---

## 10. Evidence Assessment
Hodnotí se dostupnost důkazů o provedeném testování.

Kontroluje se zejména:
- API response
- databázové ověření
- výsledky Test Runs
- reprodukční postupy
- Bug Reports
- další relevantní důkazy

### Výsledek
`TBD`

---

## 11. Release-like Decision
Na základě provedeného hodnocení je stanoven jeden z následujících výsledků:

### READY
Hodnocený rozsah splňuje definovaná QA kritéria a nejsou identifikovány překážky bránící release-like předání.

### READY WITH RISKS
Hodnocený rozsah je možné předat, ale existují známá rizika nebo omezení, která musí být zdokumentována.

### NOT READY
Hodnocený rozsah nesplňuje podmínky pro release-like předání.

### Výsledek
`TBD`

### Odůvodnění
`TBD`

---

## 12. Known Risks
Před release-like předáním musí být zaznamenána známá rizika.

| Riziko | Dopad | Pravděpodobnost | Mitigace | Stav |
|--------|-------|-----------------|----------|------|
| TBD    | TBD   | TBD             | TBD      | TBD  |

---

## 13. Release-like QA Summary
### Scope
`TBD`

### Test Coverage
`TBD`

### Test Results
`TBD`

### Defects
`TBD`

### Technical Debt
`TBD`

### Risks
`TBD`

### Final Decision
`TBD`

### QA Conclusion
`TBD`

---

## 14. Údržba dokumentu
Release Assessment se aktualizuje při provedení závěrečného QA hodnocení významného rozsahu projektu.

Při aktualizaci musí být použity aktuální:
- Business Requirements
- Test Cases
- Test Data
- Test Runs
- Traceability
- Bug Reports
- Technical Backlog

Hodnocení musí odpovídat skutečnému stavu projektu v době posouzení. Dokument nesmí obsahovat fiktivní výsledky testování nebo smyšlené důkazy. Historické release assessments mohou být zachovány jako samostatné záznamy, pokud bude projekt v budoucnu procházet více release-like hodnoceními.