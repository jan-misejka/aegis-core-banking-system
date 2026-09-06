# Testing
## Aegis Core Banking System

## 1. Účel
Tento dokument popisuje praktický způsob manuálního testování projektu Aegis Core Banking System.

Slouží jako pracovní návod pro:
- přípravu testování
- přípravu testovacích dat
- testování REST API
- ověřování databáze
- provádění pozitivních, negativních a hraničních scénářů
- regresní testování
- evidenci výsledků
- reprodukci nalezených chyb

Testování se provádí především z pohledu uživatele API a následně se ověřuje skutečný stav systému v databázi.

---

## 2. Základní princip testování
Každý testovaný Use Case musí být ověřen proti:
1. business požadavkům
2. očekávanému API chování
3. očekávanému stavu databáze
4. relevantním business pravidlům

Testování proto nekončí pouze kontrolou HTTP response. Pokud operace mění data, musí být podle charakteru testu ověřeno také, zda byla databáze změněna správným způsobem.

---

## 3. Příprava testování
Před zahájením testování:
1. Seznámit se s příslušným Use Case v `docs/business/BUSINESS_REQUIREMENTS.md`.
2. Zkontrolovat relevantní stav projektu v `docs/project/CURRENT_STATE.md`.
3. Připravit nebo vybrat potřebná testovací data.
4. Ověřit dostupnost testovací databáze.
5. Spustit aplikaci.
6. Ověřit dostupnost příslušného API endpointu.
7. Připravit testovací scénáře.
8. Určit očekávané výsledky.

Testovací scénáře musí vycházet z business požadavků, nikoliv pouze z implementace endpointu.

---

## 4. Testovací data
### 4.1 Příprava
Testovací data musí odpovídat konkrétním scénářům.

Podle testované funkcionality mohou být potřeba například:
- existující klient
- neexistující klient
- existující účet
- neexistující účet
- účet s konkrétním zůstatkem
- existující karta
- karta v konkrétním stavu
- účty vhodné pro převod
- data potřebná pro kontrolu transakcí

### 4.2 Izolace
Testování musí probíhat nad testovací databází. Testovací data nesmí být zaměňována s běžnými vývojovými daty. Pokud test vyžaduje čistý nebo známý počáteční stav, musí být před testem databáze odpovídajícím způsobem připravena nebo resetována.

### 4.3 Opakovatelnost
Testovací scénář musí být pokud možno opakovatelný. Pokud výsledek závisí na konkrétním stavu databáze, musí být tento stav uveden v testovacích datech nebo v předpokladech testu.

---

## 5. API Testing
API testování je prováděno především pomocí Postmanu.

U každého testu se ověřuje podle charakteru scénáře zejména:
- HTTP metoda
- endpoint
- request
- HTTP status code
- response body
- případná chybová zpráva
- změna stavu systému
- databázový stav

### 5.1 Pozitivní scénář
Pozitivní scénář ověřuje, že systém správně zpracuje validní požadavek.

Typický postup:
1. Připravit validní testovací data.
2. Odeslat validní request.
3. Ověřit HTTP status code.
4. Ověřit response body.
5. Ověřit očekávanou změnu systému.
6. Ověřit databázi, pokud operace mění data.
7. Zaznamenat výsledek testu.

### 5.2 Negativní scénář
Negativní scénář ověřuje, že systém správně odmítne nevalidní nebo nepovolenou operaci.

Typický postup:
1. Připravit podmínky pro nevalidní operaci.
2. Odeslat request.
3. Ověřit HTTP status code.
4. Ověřit response body nebo chybovou zprávu.
5. Ověřit, že nedošlo k nežádoucí změně systému.
6. Ověřit databázi podle charakteru testu.
7. Zaznamenat výsledek testu.

### 5.3 Hraniční scénář
Hraniční test ověřuje hodnoty na hranici business pravidel.

Typický postup:
1. Identifikovat hranici definovanou požadavkem.
2. Otestovat hodnotu na hranici.
3. Otestovat hodnotu těsně pod hranicí.
4. Otestovat hodnotu těsně nad hranicí.
5. Porovnat výsledek s očekáváním.
6. Ověřit případnou změnu databáze.

---

## 6. Database Verification
Databáze se ověřuje pomocí SQL a nástroje DBeaver.

### 6.1 Kdy databázi ověřovat
Databázové ověření je důležité zejména tehdy, pokud testovaná operace:
- vytváří nový záznam
- mění existující záznam
- mění finanční zůstatek
- vytváří transakci
- mění stav entity
- vytváří vztah mezi entitami
- mění více souvisejících záznamů

### 6.2 Co ověřovat
Podle testovaného Use Case se ověřuje například:
- existence očekávaného záznamu
- správné hodnoty atributů
- správný zůstatek
- správný stav entity
- správný typ transakce
- správná částka
- správné vazby mezi entitami
- počet vytvořených záznamů
- absence nežádoucích změn

### 6.3 Ověření zamítnuté operace
U zamítnutých operací je důležité ověřit nejen správnou chybovou odpověď API, ale také to, že nedošlo k nežádoucí změně databáze.

Například u zamítnutého finančního převodu lze ověřit:
- původní zůstatek zdrojového účtu
- původní zůstatek cílového účtu
- vznik nebo nevznik transakce
- vznik nebo nevznik převodu

---

## 7. Testování finančních operací
Finanční operace vyžadují zvláštní důraz na konzistenci dat.

U operací jako:
- vklad
- výběr
- převod

se ověřuje minimálně:
1. výchozí stav účtu
2. provedení API operace
3. API response
4. nový stav účtu
5. vytvoření odpovídající transakce
6. správná částka
7. správný typ transakce
8. případné vazby mezi transakcemi a převodem

U zamítnuté operace se ověřuje, že systém nezanechal nekonzistentní nebo částečně změněný stav.

---

## 8. Testování stavů
Entity, které mají definované stavy, musí být testovány také z pohledu povolených a nepovolených přechodů.

Při testování se ověřuje:
- výchozí stav
- povolený přechod
- nepovolený přechod
- očekávaný výsledný stav
- případná chybová odpověď
- případná změna databáze

Příklad:
`ACTIVE → BLOCKED`

je povolený přechod pro kartu, zatímco pokus o opakované zablokování již zablokované karty musí být vyhodnocen podle business pravidel.

---

## 9. Regression Testing
Po změně funkcionality se podle rozsahu změny provádí regresní testování. Regresní testování má ověřit, že nová změna nenarušila již existující funkcionalitu.

Regresní rozsah se vybírá podle:
- změněné funkcionality
- závislostí mezi funkcionalitami
- změněných databázových částí
- změněných business pravidel
- předchozích nalezených chyb

S rostoucím rozsahem projektu se regresní sada postupně rozšiřuje.

---

## 10. Test Execution
Každý testovací běh musí mít jasně definovaný:
- rozsah
- testovací prostředí
- testovací data
- seznam testů
- očekávané výsledky
- skutečné výsledky
- status testu

Výsledek jednotlivého testu se zaznamenává například jako:
- **PASS** – skutečný výsledek odpovídá očekávání
- **FAIL** – skutečný výsledek neodpovídá očekávání
- **BLOCKED** – test nelze provést kvůli překážce

U výsledku **FAIL** musí být podle závažnosti a relevance vytvořen bug report.

---

## 11. Bug Reproduction
Pokud je nalezena chyba:
1. Ověřit, že chyba je reprodukovatelná.
2. Zaznamenat výchozí stav.
3. Zaznamenat testovací data.
4. Zaznamenat přesné kroky.
5. Zaznamenat request.
6. Zaznamenat očekávaný výsledek.
7. Zaznamenat skutečný výsledek.
8. Podle potřeby ověřit databázi.
9. Vytvořit bug report.
10. Po opravě provést retest.

Cílem je umožnit jinému člověku chybu zopakovat pouze na základě bug reportu.

---

## 12. Evidence důkazů
U významných testů musí být možné doložit výsledek testování.

Podle charakteru testu mohou důkazy zahrnovat:
- Postman request
- API response
- HTTP status code
- SQL dotaz
- výsledek SQL dotazu
- stav databáze před testem
- stav databáze po testu
- screenshot
- bug report
- výsledek retestu

Důkaz musí být dostatečný k ověření skutečného výsledku testu.

---

## 13. Traceability
Testování musí být dohledatelné zpět k business požadavkům.

Základní vazba je:
`Business Requirement → Use Case → Test Case → Test Data → Test Run → Bug`

Pokud je nalezena chyba, musí být možné určit:
- kterého Use Case se týká
- kterého požadavku se týká
- kterým testem byla nalezena
- zda byla opravena
- zda byla následně úspěšně retestována

---

## 14. Testovací dokumentace
QA dokumentace projektu je rozdělena podle účelu jednotlivých artefaktů.

### Test Plan
`docs/qa/TEST_PLAN.md`

Definuje:
- co se testuje
- proč se testuje
- rozsah
- testovací strategii
- testovací úrovně
- entry a exit criteria
- rizika

### Test Cases
`docs/qa/TEST_CASES.md`

Obsahují konkrétní testovací scénáře, jejich předpoklady, kroky a očekávané výsledky.

### Test Data
`docs/qa/TEST_DATA.md`

Obsahují přehled testovacích dat používaných pro jednotlivé testovací scénáře.

### Test Runs
`docs/qa/TEST_RUNS.md`

Obsahují výsledky konkrétních provedení testovacích scénářů nebo testovacích sad.

### Traceability
`docs/qa/TRACEABILITY.md`

Obsahuje vazby mezi business požadavky, Use Cases, testovacími scénáři, výsledky testů a bug reporty.

### Bug Reports
`jira/BUG_REPORTS.md`

Obsahují nalezené a evidované chyby.

### Release-like Assessment
`docs/qa/RELEASE_ASSESSMENT.md`

Obsahuje závěrečné QA vyhodnocení testované verze.

---

## 15. Minimální testovací pokrytí Use Case
Každý významnější Use Case by měl být podle charakteru funkcionality pokryt minimálně:
- pozitivním scénářem
- negativním scénářem
- hraničním scénářem, pokud existuje relevantní hranice
- databázovým ověřením, pokud dochází ke změně dat
- regresním ověřením, pokud změna ovlivňuje existující funkcionalitu

Konkrétní rozsah testování se určuje podle rizika a charakteru Use Case.

---

## 16. QA Review
Po dokončení testování se provádí kontrola:
- zda byly pokryty relevantní požadavky
- zda byly provedeny pozitivní scénáře
- zda byly provedeny negativní scénáře
- zda byly pokryty relevantní hranice
- zda byly ověřeny důležité databázové změny
- zda byly zaznamenány výsledky
- zda byly evidovány nalezené chyby
- zda byly opravené chyby retestovány
- zda byl proveden relevantní regresní test
- zda jsou známá rizika zdokumentována

Výsledek QA Review je součástí rozhodnutí o dokončení testované funkcionality.

---

## 17. Praktický testovací postup
Pro běžný Use Case lze použít následující postup:

### Příprava
1. Přečíst business požadavky.
2. Určit testovací scénáře.
3. Připravit testovací data.
4. Připravit testovací prostředí.

### Provedení
5. Zkontrolovat výchozí stav.
6. Provést API request.
7. Ověřit HTTP response.
8. Ověřit databázi.
9. Porovnat skutečný výsledek s očekáváním.

### Vyhodnocení
10. Označit test jako PASS / FAIL / BLOCKED.
11. Při FAIL ověřit a reprodukovat chybu.
12. Vytvořit bug report podle potřeby.
13. Po opravě provést retest.
14. Provést relevantní regresní test.

### Záznam
15. Zaznamenat výsledek testování.
16. Aktualizovat relevantní QA dokumentaci.
17. Aktualizovat stav projektu podle `DEVELOPMENT_WORKFLOW.md`.

---

## 18. Zásady manuálního testování
Při testování Aegis platí zejména:
- netestovat pouze happy path
- ověřovat také nevalidní vstupy
- myslet na hraniční hodnoty
- ověřovat databázi, pokud je relevantní
- kontrolovat vedlejší efekty operace
- u finančních operací ověřovat konzistenci dat
- u změn stavů ověřovat povolené i nepovolené přechody
- chyby reprodukovat
- testovací výsledky dokumentovat
- nespoléhat pouze na správný HTTP status
- oddělovat očekávaný výsledek od skutečného výsledku

Cílem testování není pouze potvrdit, že systém funguje. Cílem je získat dostatečné důkazy o tom, že systém se v definovaném rozsahu chová správně a předvídatelně.