# Traceability
## Aegis Core Banking System

## 1. Účel
Tento dokument slouží k dohledatelnosti mezi business požadavky a jejich ověřením pomocí testování.

Traceability umožňuje sledovat vazbu:
`Business Requirement → Use Case → Test Case → Test Data → Test Run → Bug`

Dokument pomáhá ověřit, že požadavky projektu mají odpovídající testovací pokrytí a že výsledky testování lze dohledat zpět ke konkrétním požadavkům.

---

## 2. Princip traceability
Každý významný business požadavek by měl být propojen alespoň s jedním odpovídajícím Test Case.

Test Case může být propojen:
- s konkrétním Use Case
- s jedním nebo více Test Data
- s jedním nebo více Test Runs
- s případným Bug Reportem

Traceability se používá pro:
- kontrolu testovacího pokrytí
- identifikaci netestovaných požadavků
- dohledání původu testovacího scénáře
- dohledání výsledku konkrétního testování
- propojení nalezených chyb s požadavkem

---

## 3. Zdroje požadavků
Business požadavky jsou vedeny v:
`docs/business/BUSINESS_REQUIREMENTS.md`

Test Cases jsou vedeny v:
`docs/qa/TEST_CASES.md`

Test Data jsou vedeny v:
`docs/qa/TEST_DATA.md`

Test Runs jsou vedeny v:
`docs/qa/TEST_RUNS.md`

Bug Reports jsou vedeny v:
`jira/BUG_REPORTS.md`

---

## 4. Traceability Matrix
| Requirement / Use Case      | Test Cases            | Test Data             | Test Runs | Bugs |
|-----------------------------|-----------------------|-----------------------|-----------|------|
| UC001 – Client Management   | TC-001-01 – TC-001-08 | TD-001-01 – TD-001-04 | TBD       | TBD  |
| UC002 – Open Account        | TC-002-01 – TC-002-05 | TD-002-01 – TD-002-06 | TBD       | TBD  |
| UC003 – Deposit Money       | TC-003-01 – TC-003-05 | TD-003-01 – TD-003-05 | TBD       | TBD  |
| UC004 – Withdraw Money      | TC-004-01 – TC-004-06 | TD-004-01 – TD-004-06 | TBD       | TBD  |
| UC005 – Transfer Money      | TC-005-01 – TC-005-07 | TD-005-01 – TD-005-08 | TBD       | TBD  |
| UC006 – Issue Card          | TC-006-01 – TC-006-05 | TD-006-01 – TD-006-04 | TBD       | TBD  |
| UC007 – Block Card          | TC-007-01 – TC-007-04 | TD-007-01 – TD-007-04 | TBD       | TBD  |
| UC008 – Unblock Card        | TC-008-01 – TC-008-04 | TD-008-01 – TD-008-04 | TR-008    | None |
| UC009 – Account Detail      | Planned               | Planned               | TBD       | TBD  |
| UC010 – Client Accounts     | Planned               | Planned               | TBD       | TBD  |
| UC011 – Transaction History | Planned               | Planned               | TBD       | TBD  |
| UC012 – Transfer Detail     | Planned               | Planned               | TBD       | TBD  |
| UC013 – Close Account       | Planned               | Planned               | TBD       | TBD  |

---

## 5. Status testovacího pokrytí
Pro účely traceability se používají následující stavy:

### Covered (Pokrytý)
Požadavek má vytvořený odpovídající Test Case.

### Partially Covered (Částečně pokrytý)
Požadavek má testovací pokrytí, ale některé jeho části nebo scénáře ještě nejsou pokryty.

### Not Covered (Nepokrytý)
Požadavek zatím nemá odpovídající Test Case.

### Planned (Plánováno)
Testovací pokrytí je plánováno, ale Use Case zatím není implementován nebo testován.

---

## 6. Detailní vazba
Traceability má být v případě potřeby dohledatelná až na úroveň konkrétního Test Case.

Příklad struktury:

`UC003 – Deposit Money`

→ `TC-003-01`

→ `TD-003-01`

→ konkrétní `Test Run`

→ případný `BUG-XXX`

Tímto způsobem lze dohledat:
- který požadavek byl testován
- jaký Test Case byl použit
- jaká testovací data byla použita
- kdy a v jakém Test Runu byl test proveden
- zda byl nalezen problém

---

## 7. Traceability a testovací výsledky
Samotné vytvoření Test Case neznamená, že byl požadavek skutečně otestován.

Je nutné rozlišovat:
- existenci Test Case
- skutečné provedení Test Case
- výsledek provedení
- případný Bug Report

Proto jsou Test Cases a Test Runs vedeny v samostatných dokumentech. Traceability se aktualizuje podle skutečně provedeného testování.

---

## 8. Traceability a bug management
Pokud testování odhalí chybu, měl by být Bug Report propojen s relevantním Test Case.

Vazba může být například:
`UC005 → TC-005-04 → TR-002 → BUG-001`

Díky tomu lze dohledat:
- požadavek, kterého se chyba týká
- Test Case, při kterém byla chyba nalezena
- Test Run, ve kterém byla chyba reprodukována
- samotný Bug Report

Bug Reports jsou vedeny samostatně v:
`jira/BUG_REPORTS.md`

---

## 9. Údržba dokumentu
Traceability Matrix se aktualizuje při významných změnách testovacího pokrytí.

Dokument je potřeba aktualizovat zejména při:
- přidání nového Use Case
- vytvoření nových Test Cases
- vytvoření nových Test Data
- provedení významného Test Run
- nalezení relevantního Bug Reportu
- změně testovacího pokrytí

Do dokumentu se nezapisují hypotetické výsledky. Stav musí odpovídat skutečnému stavu testovací dokumentace.