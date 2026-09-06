# Bug Reports
## Účel dokumentu
Tento dokument obsahuje evidenci nalezených nebo modelových vad v projektu Aegis Core Banking System.

Bug report musí umožnit jinému testerovi nebo vývojáři:
- jednoznačně identifikovat problém
- zopakovat problém podle uvedených kroků
- porovnat očekávané a skutečné chování
- určit závažnost a prioritu vady
- ověřit stav opravy
- dohledat související Test Case, Test Run nebo jiný důkaz

Skutečně nalezené vady musí být založeny na reálně provedeném testování. Modelové bug reporty jsou výslovně označeny jako modelové a nesmí být prezentovány jako skutečně nalezené vady.

---

## Šablona
### BUG-[ID] – [stručný název vady]
**Typ:** [Skutečná vada / Modelový příklad]  
**Stav:** [Open / Fixed / Retest / Closed]  
**Severity:** [Critical / High / Medium / Low]  
**Priority:** [High / Medium / Low]  
**Use Case:** [UCxxx]  
**Test Case:** [TC-xxx-xx]  
**Test Run:** [TR-xxx / TBD]  
**Prostředí:** [verze aplikace, databáze, datum]
**Předpoklady:**
* [konkrétní připravený stav dat]

**Kroky k reprodukci:**
1. [krok]
2. [krok]
3. [krok]

**Očekávaný výsledek:**
* [ověřitelné očekávané chování]

**Skutečný výsledek:**
* [skutečně pozorované chování]

**Důkaz:**
* [Postman response, SQL kontrola, screenshot nebo odkaz na Test Run]

**Retest:**
* [výsledek retestu nebo TBD]

---

## Modelové Bug Reporty
Následující reporty jsou **modelové příklady** vytvořené pro demonstraci QA procesu. Nejedná se o tvrzení, že tyto vady byly v Aegis skutečně nalezeny.

### BUG-001 – Opakované zablokování již zablokované karty
**Typ:** Modelový příklad  
**Stav:** Open  
**Severity:** Medium  
**Priority:** Medium  
**Use Case:** UC007  
**Test Case:** TC-007-03  
**Test Run:** TBD  
**Prostředí:** Aegis Core Banking System, testovací prostředí
**Předpoklady:**
* Existuje platební karta ve stavu `BLOCKED`.

**Kroky k reprodukci:**
1. Odeslat `PATCH /cards/{cardId}/block` pro kartu ve stavu `BLOCKED`.
2. Zkontrolovat HTTP response.
3. Ověřit stav karty v databázi.

**Očekávaný výsledek:**
* Systém odmítne pokus o opětovné zablokování karty.
* Stav karty zůstane `BLOCKED`.
* Databázový záznam karty se jinak nezmění.

**Skutečný výsledek:**
* Modelový scénář předpokládá, že API požadavek je chybně přijat jako úspěšný.

**Důkaz:**
* Modelový Postman response – TBD.
* Modelová SQL kontrola stavu karty – TBD.

**Retest:**
* TBD.

---

### BUG-002 – Změna stavu EXPIRED karty na BLOCKED
**Typ:** Modelový příklad  
**Stav:** Open  
**Severity:** High  
**Priority:** High  
**Use Case:** UC007  
**Test Case:** TC-007-04  
**Test Run:** TBD  
**Prostředí:** Aegis Core Banking System, testovací prostředí
**Předpoklady:**
* Existuje platební karta ve stavu `EXPIRED`.

**Kroky k reprodukci:**
1. Odeslat `PATCH /cards/{cardId}/block` pro kartu ve stavu `EXPIRED`.
2. Zkontrolovat HTTP response.
3. Ověřit stav karty v databázi.

**Očekávaný výsledek:**
* Systém odmítne pokus o zablokování karty ve stavu `EXPIRED`.
* Stav karty zůstane `EXPIRED`.
* Ostatní atributy karty zůstanou nezměněny.

**Skutečný výsledek:**
* Modelový scénář předpokládá, že systém chybně změní stav karty z `EXPIRED` na `BLOCKED`.

**Důkaz:**
* Modelový Postman response – TBD.
* Modelová SQL kontrola stavu karty – TBD.

**Retest:**
* TBD.

---

## Vazba na QA artefakty
Bug reporty jsou propojeny s ostatními QA artefakty podle následující vazby:
`Business Requirement → Use Case → Test Case → Test Data → Test Run → Bug`

Bug report musí být možné dohledat zpět k testu, který problém odhalil.

Relevantní QA dokumentace:
- Test Plan: `docs/qa/TEST_PLAN.md`
- Test Cases: `docs/qa/TEST_CASES.md`
- Test Data: `docs/qa/TEST_DATA.md`
- Test Runs: `docs/qa/TEST_RUNS.md`
- Traceability: `docs/qa/TRACEABILITY.md`
- Bug Reports: `jira/BUG_REPORTS.md`

## Evidence skutečných vad
Při skutečném testování se modelové reporty nesmí používat jako důkaz provedeného testování.

Pokud bude při testování nalezena skutečná vada, bude přidán nový report s:
- konkrétním Test Case
- konkrétním Test Data
- konkrétním Test Run
- skutečnými kroky k reprodukci
- skutečným očekávaným výsledkem
- skutečným výsledkem
- důkazem vady
- stavem opravy a případným retestem

## Údržba dokumentu
Dokument se aktualizuje při:
- nalezení nové skutečné vady
- změně stavu existující vady
- provedení retestu
- doplnění důkazů
- změně vazby na Test Case nebo Test Run

Modelové bug reporty zůstávají označeny jako modelové, dokud nejsou nahrazeny skutečnou evidencí získanou z provedeného testování.