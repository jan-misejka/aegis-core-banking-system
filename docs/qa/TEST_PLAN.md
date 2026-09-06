# Test Plan
## Aegis Core Banking System

## 1. Účel
Tento dokument definuje základní plán testování projektu Aegis Core Banking System.

Slouží jako rámec pro:
- plánování testování
- definování rozsahu testování
- stanovení testovací strategie
- přípravu testovacích scénářů
- provádění testovacích běhů
- evidenci a vyhodnocování chyb
- posouzení připravenosti funkcionality k vydání

Dokument popisuje především **co a proč se testuje**. Konkrétní postupy provádění testů, práce s API a databází a evidence výsledků jsou vedeny v dalších QA dokumentech.

---

## 2. Cíle testování
Hlavním cílem testování je ověřit, že systém:
- splňuje definované business požadavky
- dodržuje definovaná business pravidla
- správně zpracovává validní vstupy
- správně odmítá nevalidní vstupy
- správně zpracovává hraniční hodnoty
- zachovává konzistenci dat
- správně mění stav databáze
- poskytuje očekávané API odpovědi
- nevytváří nežádoucí vedlejší efekty

Testování má současně odhalit chyby, které by mohly vést k nesprávnému zpracování bankovních operací nebo nekonzistentním datům.

---

## 3. Rozsah
### 3.1 In Scope
Testování zahrnuje zejména:
- klienty
- bankovní účty
- platební karty
- vklady
- výběry
- převody
- transakce
- změny stavů doménových objektů
- business validace
- REST API
- databázový stav
- integritu vztahů mezi entitami
- pozitivní scénáře
- negativní scénáře
- hraniční scénáře
- regresní testování

Hlavní rozsah funkcionality je definován pomocí Use Cases UC001–UC013 v `docs/business/BUSINESS_REQUIREMENTS.md`.

### 3.2 Out of Scope
Z testovacího rozsahu jsou v aktuální verzi projektu mimo jiné:
- cloudové prostředí
- cloudová bezpečnost
- frontendové testování
- performance testing
- load testing
- security testing v enterprise rozsahu
- automatizace API testů
- CI/CD testovací pipeline
- mainframe prostředí
- COBOL
- JCL
- batch processing

Tyto oblasti mohou být řešeny v samostatných projektech nebo v pozdějších rozšířeních Aegis.

---

## 4. Testovací strategie
Testování je zaměřeno především na funkční správnost systému z pohledu business požadavků.

### 4.1 Functional Testing
Ověřuje, že jednotlivé Use Cases fungují podle definovaných požadavků.

Testuje se zejména:
- správné zpracování validních vstupů
- správné změny stavu systému
- správné API odpovědi
- správné vytvoření nebo změna databázových záznamů
- dodržení business pravidel

### 4.2 Negative Testing
Ověřuje chování systému při nevalidních nebo nepovolených operacích.

Testují se například:
- neexistující entity
- neplatné hodnoty
- chybějící povinné údaje
- záporné nebo nulové částky
- nedostatečný zůstatek
- nepovolené změny stavů
- jiné porušení business pravidel

U zamítnuté operace se zároveň ověřuje, že nedojde k nežádoucí změně stavu systému.

### 4.3 Boundary Testing
Ověřuje chování systému na hranicích definovaných hodnot.

Testují se zejména:
- minimální povolené hodnoty
- hodnoty těsně pod minimem
- hodnoty těsně nad minimem
- maximální hodnoty, pokud jsou definovány
- hodnoty na hranici povolených stavů nebo pravidel

U finančních operací je důležité ověřovat zejména minimální povolenou částku.

### 4.4 Regression Testing
Regresní testování ověřuje, že změna jedné části systému nenarušila již funkční existující funkcionalitu. Regresní rozsah se bude rozšiřovat s přibývajícími Use Cases. Po dokončení významné funkcionality budou podle potřeby znovu ověřovány dříve dokončené části systému.

### 4.5 API Testing
API testování ověřuje chování REST endpointů z pohledu klienta API.

Ověřuje se zejména:
- HTTP metoda
- endpoint
- request
- response
- HTTP status code
- response body
- validace vstupů
- chování při chybových stavech

API testování je prováděno především manuálně pomocí Postmanu.

### 4.6 Database Testing
Databázové testování ověřuje, že stav databáze odpovídá očekávanému výsledku operace.

Ověřuje se například:
- vytvoření záznamu
- změna záznamu
- odstranění nebo změna stavu záznamu
- správná hodnota zůstatku
- vytvoření transakcí
- správné vazby mezi entitami
- zachování databázových omezení
- konzistence dat po úspěšné i neúspěšné operaci

Databázové ověření je prováděno pomocí SQL a nástroje DBeaver.

---

## 5. Testovací úrovně
V rámci projektu jsou využívány především následující úrovně testování:

### 5.1 Component / Unit Testing
Ověření jednotlivých částí aplikační logiky pomocí automatizovaných testů. V projektu jsou využívány především JUnit testy.

### 5.2 Integration Testing
Ověření spolupráce jednotlivých částí aplikace, například:
- Controller
- Service
- Repository
- databáze

Součástí je také ověření správného uložení a načtení dat.

### 5.3 API / System Testing
Ověření systému prostřednictvím REST API z pohledu jeho uživatele. Tato úroveň je hlavní součástí manuálního testování projektu.

### 5.4 Database Verification
Ověření výsledného databázového stavu po provedení testované operace.

---

## 6. Testovací prostředí
Testování probíhá v lokálním vývojovém prostředí projektu.

Používané nástroje a technologie zahrnují:
- Java
- Spring Boot
- MySQL
- Maven
- JUnit
- Postman
- DBeaver
- Git
- GitHub
- Windows
- WSL

Testovací databáze je oddělena od vývojové databáze, aby testování neovlivňovalo běžná vývojová data.

---

## 7. Testovací data
Testovací data musí umožňovat ověření pozitivních, negativních a hraničních scénářů.

Používána jsou zejména data pro:
- klienty
- účty
- karty
- převody
- transakce
- různé stavy doménových objektů

Testovací data musí být připravena tak, aby bylo možné reprodukovat konkrétní testovací scénáře. Databázová testovací data jsou udržována odděleně od aplikační logiky.

---

## 8. Testovací artefakty
QA dokumentace projektu bude postupně obsahovat zejména:
- Test Plan
- Test Strategy
- Traceability
- Test Cases
- Test Data
- Test Runs
- Bug Reports
- Release-like Assessment

Jednotlivé artefakty mají rozdílný účel a nemají vzájemně zbytečně duplikovat informace. Konkrétní výsledky testování budou zaznamenávány v příslušných QA artefaktech.

---

## 9. Defect Management
Nalezené chyby jsou evidovány v `jira/BUG_REPORTS.md`.

Každý relevantní bug report by měl obsahovat zejména:
- identifikaci chyby
- popis problému
- předpoklady
- kroky k reprodukci
- očekávaný výsledek
- skutečný výsledek
- závažnost
- prioritu
- stav
- případně informace o retestu

Po opravě chyby musí být podle potřeby proveden:
- retest opravené funkcionality
- regresní ověření související funkcionality

---

## 10. Entry Criteria
Testování funkcionality může začít, pokud jsou splněny relevantní podmínky, zejména:
- business požadavky jsou dostatečně definované
- testovaná funkcionalita je implementována
- aplikace je možné spustit
- potřebná testovací data jsou dostupná
- testovací prostředí je připravené
- jsou definována akceptační kritéria
- testovací scénáře jsou připravené v rozsahu odpovídajícím testované funkcionalitě

Konkrétní podmínky mohou být upraveny podle charakteru testované změny.

---

## 11. Exit Criteria
Testování funkcionality lze považovat za dokončené, pokud:
- byly provedeny relevantní pozitivní scénáře
- byly provedeny relevantní negativní scénáře
- byly provedeny relevantní hraniční scénáře
- byly ověřeny důležité databázové změny
- byly vyhodnoceny nalezené chyby
- kritické chyby nejsou nevyřešené
- případné opravy byly retestovány
- byl proveden odpovídající regresní test
- výsledky testování byly zaznamenány
- dokumentace byla aktualizována
- bylo provedeno závěrečné QA posouzení

Splnění Exit Criteria samo o sobě neznamená automatické vydání funkcionality. Konečné rozhodnutí musí zohlednit také známá rizika a stav otevřených problémů.

---

## 12. Rizika
Mezi hlavní rizika testování projektu patří:
- nedostatečné pokrytí business pravidel
- chybějící negativní scénáře
- chybějící hraniční scénáře
- nesprávně připravená testovací data
- nekonzistentní databázový stav
- regresní chyba po změně existující funkcionality
- přehlédnutí chyby pouze kvůli správné HTTP odpovědi
- ověření API bez kontroly skutečného stavu databáze
- nedostatečně reprodukovatelné testovací scénáře

Rizika jsou průběžně vyhodnocována během testování a Project Review.

---

## 13. Release-like Assessment
Po dokončení významné části projektu bude provedeno závěrečné QA posouzení ve formě release-like assessment.

Posouzení bude zahrnovat zejména:
- rozsah provedeného testování
- výsledky testovacích běhů
- počet a závažnost nalezených chyb
- stav opravených a otevřených chyb
- regresní rizika
- známá omezení
- zbývající rizika
- celkové QA doporučení

Výsledkem bude rozhodnutí, zda je testovaná verze z pohledu definovaného rozsahu:
- **Ready for Release**
- **Release with Known Risks**
- **Not Ready for Release**

Toto posouzení slouží jako simulace procesu, který může QA tým provádět před vydáním softwaru.