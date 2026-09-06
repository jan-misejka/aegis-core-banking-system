# Aegis Core Banking System – Kontext projektu

## Účel projektu

Aegis Core Banking System je dlouhodobý studijní projekt navržený pro simulaci realistického bankovního prostředí.

Hlavním cílem projektu je vybudovat praktický základ pro práci v bankovním IT, který propojuje:

* business požadavky
* návrh databází
* SQL
* backendový vývoj
* REST API
* testování
* Git/GitHub
* dokumentaci
* základní software architecture
* SDLC

Projekt zároveň slouží jako první úroveň dlouhodobého projektového studia definovaného v dokumentu `AI_projects_workflow.md`.

Aegis představuje Level 01 – Foundation.

Projekt je primárně veden jako guided learning projekt. AI poskytuje významnou část vysvětlení, návrhů a review, ale cílem není nahrazovat porozumění uživatele.

Projekt se má postupně vyvíjet od databáze a backendu přes REST API a testování k pokročilejším bankovním konceptům.

---

## Aktuální cíl

Vytvořit realistický bankovní systém, který lze využít pro:

* výuku SQL
* testování databází
* testování API
* procvičování práce s Postmanem
* návrh testovacích scénářů
* tvorbu bug reportů
* procvičování business analýzy

Projekt by měl svým charakterem připomínat systémy běžně používané v bankách.

---

## Studijní režim

Aegis je první projekt dlouhodobého projektového workflow.

### Úroveň samostatnosti

Aegis používá guided learning model:

* AI poskytuje většinu návrhu a vysvětlení.
* Uživatel implementuje jednotlivé kroky s vedením AI.
* Každý nový koncept musí být nejprve vysvětlen a předveden.
* Uživatel nemá být nucen samostatně implementovat koncept, který dosud nebyl vysvětlen nebo procvičen.
* Úroveň samostatnosti se má postupně zvyšovat.

Cílem není maximalizovat rychlost implementace, ale postupně převádět odpovědnost za návrh a rozhodování na uživatele.

### Princip opakování

Důležité technologie a koncepty se nemají naučit pouze jednou.

Koncepty z Aegisu budou v dalších projektech znovu použity s postupně menší mírou vedení AI.

Typicky:

* první použití – AI vysvětluje a demonstruje,
* další použití – uživatel část řešení navrhuje,
* pozdější použití – uživatel navrhuje řešení a AI provádí review.

---

## Používané technologie

### Vývoj

* Java
* Spring Boot
* Maven
* IntelliJ IDEA Community

### Databáze

* MySQL
* DBeaver

### Testování

* Postman
* Jira
* Excel

### Prostředí

* Git
* GitHub
* WSL

---

## Struktura repozitáře

```text
aegis-core-banking-system/

database/
docs/
testing/
postman/
jira/
src/
mvnw
mvnw.cmd
pom.xml
README.md
```

---

## Aktuální fáze: Level 01 - Foundation / Fáze 3 - REST API

### Fáze 1 – Databáze

Aktuální databáze:
```text
aegiscore_banking
```
Aktuální stav repozitáře:
```text
docs/
└── DATABASE_MODEL.md
└── PROJECT_CONTEXT.md
└── ROADMAP.md
└── BUSINESS_REQUIREMENTS.md
└── CHANGELOG.md
└── PROJECT_VISION.md
└── TECH_STACK.md
└── TECHNICAL_BACKLOG.md
└── DEVELOPMENT_WORKFLOW.md
└── README.md

database/
└── schema.sql
└── SQL_EXERCISES.md
└── SQL_VALIDATION.md
└── test_data.sql
└── test_data_part2.sql
```
* Logický databázový model byl navržen a zdokumentován v souboru docs/DATABASE_MODEL.md.
* Bylo definováno pět základních entit systému:
    - Client
    - Account
    - Card
    - Transaction
    - Transfer

* Byly definovány základní vztahy mezi entitami.
* Byla doplněna relace:
    - Transaction → Transfer (transakce může být navázána na převod prostřednictvím transfer_id)

* Byl dokončen návrh atributů všech entit databázového modelu.
* Byly schváleny atributy pro:
    - Client
    - Account
    - Card
    - Transaction
    - Transfer

* Byly definovány povolené hodnoty pro:
    - account_type
    - card_status
    - tx_type
    - transfer_status

* Fyzické databázové schéma (database/schema.sql) bylo vytvořeno. Byly definovány:

    - primární klíče (PK)
    - cizí klíče (FK)
    - UNIQUE omezení
    - CHECK omezení

* Byla vytvořena první verze testovacích dat (database/test_data.sql, database/test_data_part2.sql).
* Testovací dataset obsahuje:
    * 10 klientů
    * 15 účtů
    * 12 platebních karet
    * 20 převodů
    * 50 transakcí

* Byly ověřeny vazby mezi všemi entitami databázového modelu.
* Byla doplněna vazba:
    - Transfer → Transaction
    prostřednictvím atributu:
    ```
    transfer_id
    ```
* Byly vytvořeny SQL cvičení a validační testy pro všechny entity a jejich vazby. Cvičení a testy jsou uloženy v:
    - docs/SQL_EXERCISES.md
    - docs/SQL_VALIDATION.md

REST API v době dokončení Fáze 1 ještě nebylo implementováno.

---

### Fáze 2 - Backend

* Spring Boot aplikace byla vytvořena a základní struktura projektu byla nastavena.
* Aplikace se úspěšně spouští a připojuje k databázi aegiscore_banking.
* Byla dokončena konfigurace:
    - Spring Data JPA
    - MySQL datasource
    - Hibernate

#### Implementace entit a jejich vazeb
* Byla vytvořena první entita Client v package pro entity.
* Byla upravena entita Client zahrnutím anotace @GeneratedValue(strategy = GenerationType.IDENTITY) pro automatické generování ID.
* Byla vytvořena entita Account.
* Byla vytvořena entita Card.
* Byla vytvořena entita Transfer.
* Byla vytvořena entita Transaction.

#### Implementace repository vrstvy
* Byla vytvořena repository vrstva pro entitu Client (ClientRepository).
* Byla vytvořena repository vrstva pro entitu Account (AccountRepository).
* Byla vytvořena repository vrstva pro entitu Card (CardRepository).
* Byla vytvořena repository vrstva pro entitu Transfer (TransferRepository).
* Byla vytvořena repository vrstva pro entitu Transaction (transactionRepository).

#### Implementace JPA relací
* Byla vytvořena a ověřena relace Account -> Client.
* Byla vytvořena a ověřena relace Card -> Account.
* Byla vytvořena a ověřena relace Card -> Account -> Client.
* Byly vytvořeny a ověřeny relace Transfer -> Account (sourceAccount, targetAccount).
* Byly vytvořeny relace Transaction -> Account, Transaction -> Transfer.

#### Implementace integračních testů
* Byl vytvořen první integrační test pro entitu Client.
* Byl vytvořen první integrační test pro entitu Account.
* Byl vytvořen první integrační test pro entitu Card.
* Byl vytvořen první integrační test pro entitu Transfer.
* Byl vytvořen první integrační test pro entitu Transaction.

---

### Fáze 3 - REST API

* Byla vytvořena první REST API vrstva pro entitu Client.
* Byly vytvořeny DTO objekty:
    - CreateClientRequest
    - ClientResponse
    - 
* Byla vytvořena service vrstva (ClientService).
* Byl vytvořen REST Controller (ClientController).
* Byl implementován endpoint:
    - POST /clients
    - GET / clients
    - GET /clients/{id}
    - PUT /clients/{id}
    - DELETE /clients/{id}
    - 
* Endpoint POST /clients úspěšně vytváří klienta v databázi prostřednictvím repository vrstvy.
* Endpoint GET /clients úspěšně vrací seznam všech klientů z databáze.
* Endpoint GET /clients/{id} úspěšně vrací detail klienta podle jeho ID.
* Endpoint PUT /clients/{id} úspěšně aktualizuje údaje existujícího klienta.
* Endpoint DELETE /clients/{id} úspěšně odstraňuje klienta z databáze.
* 
* Entita Client automaticky nastavuje atribut createdAt pomocí JPA callbacku @PrePersist.
* Funkčnost endpointů byla úspěšně ověřena pomocí Postmanu a DBeaveru.

#### Plán implementace REST API
Vývoj REST API probíhá iterativně po jednotlivých business Use Casech.

Aktuální stav:

✅ UC001 – Client Management (CRUD) – dokončeno
✅ PR-001 – Project Review #1 – dokončeno
✅ TECH-001 – Globální zpracování výjimek – dokončeno
✅ TECH-002 – Validace vstupních dat – dokončeno
✅ PR-002 – Project Review #2 – dokončeno
✅ UC002 – Open Account – implementováno a otestováno
✅ PR-003 - Project Review #3 - dokončeno
✅ UC003 - Deposit Money - dokončeno
✅ PR-004 - Project Review #4 - dokončeno
✅ TECH-006 - Izolace testovací databáze - dokončeno
✅ PR-005 - Project Review #5 - dokončeno
✅ UC004 - Withdraw Money - dokončeno
✅ PR-006 - Project Review #6 - dokončeno
✅ UC005 - Transfer Money - dokončeno
✅ PR-007 - Project Review #7 - dokončeno
✅ UC-006 - Issue Card - dokončeno
✅ PR-008 - Project Review #8 - dokončeno
✅ UC007 - Block Card - dokončeno
✅ PR-009 - Project Review po UC007 - dokončeno

### UC002 – Open Account
Implementováno:

- POST /accounts
- vytvoření účtu pro existujícího klienta
- validace accountType:
  - CURRENT
  - SAVINGS
- validace currency:
  - CZK
  - EUR
  - USD
- počáteční balance = 0
- automatické nastavení createdAt pomocí @PrePersist
- generování realistického českého IBANu
- kontrola unikátnosti IBANu
- HTTP 404 pro neexistujícího klienta
- HTTP 400 pro neplatný typ účtu nebo měnu
- HTTP 400 pro nevalidní request podle Bean Validation

Testování:
- Maven testy úspěšně prošly.
- Pozitivní scénář POST /accounts byl úspěšně ověřen pomocí Postmanu.
- Negativní scénáře byly úspěšně ověřeny pomocí Postmanu.
- Uložení vytvořeného účtu a správnost dat byly ověřeny pomocí DBeaveru.

### UC003 - Deposit Money
Implementováno:

- POST /accounts/{id}/deposit
- validace existence účtu
- validace částky pomocí Jakarta Bean Validation
- minimální částka vkladu 0.01
- navýšení balance účtu
- vytvoření Transaction se type DEPOSIT
- přiřazení Transaction ke konkrétnímu účtu
- automatické nastavení času transakce
- použití @Transactional pro společné uložení změny účtu a transakce
- HTTP 200 při úspěšném vkladu
- HTTP 400 při nevalidní částce
- HTTP 404 při neexistujícím účtu

Testování:
- Pozitivní scénář ověřen pomocí Postmanu.
- Negativní scénáře ověřeny pomocí Postmanu.
- Správnost změny balance ověřena pomocí DBeaveru.
- Vytvoření DEPOSIT transaction ověřeno pomocí DBeaveru.
- Automatizované controller testy vytvořeny pro pozitivní a negativní scénáře.
- Automatizované testy ověřily HTTP 200, HTTP 400 a HTTP 404.

### TECH-006 - Izolace testovací databáze
Implementováno:

- byla vytvořena samostatná testovací databáze `aegiscore_banking_test`
- byla vytvořena testovací konfigurace v `application-test.properties`
- testovací prostředí používá Spring profil `test`
- byl vytvořen společný základ `TestDatabaseReset` pro integrační testy
- před každým testem se provádí reset testovací databáze pomocí SQL skriptu
- testovací databáze je před každým testem naplněna deterministickým datasetem
- testy již nejsou závislé na stavu databáze po předchozích testech
- byl vytvořen testovací resetovací skript `test_reset.sql`
- testovací resetovací skript je umístěn v:
  - `database/test_reset.sql`
  - `src/test/resources/test_reset.sql`
- byly upraveny integrační testy tak, aby používaly testovací profil a společný reset databáze
- byla upravena databázová struktura kvůli správnému pořadí mazání dat při respektování FK vazeb
- bylo upraveno globální zpracování výjimek tak, aby odpovídalo očekávaným HTTP statusům integračních testů

Testování:
- Maven testy úspěšně prošly.
- Testovací databáze je izolována od vývojové databáze.
- Integrační testy jsou deterministické a lze je spouštět opakovaně.

### UC004 - Withdraw Money

Byl implementován endpoint POST /accounts/{id}/withdraw pro výběr peněz z bankovního účtu.

Implementace:
- WithdrawMoneyRequest s validací částky.
- Kontrola existence účtu.
- Kontrola dostatečného zůstatku účtu.
- Snížení balance o vybranou částku.
- Vytvoření WITHDRAWAL transaction.
- Uložení změny účtu a transakce v rámci jedné databázové transakce.
- HTTP 400 při nevalidní částce nebo nedostatečném zůstatku.
- HTTP 404 při neexistujícím účtu.

Testování:
- Maven/JUnit testy pro pozitivní a negativní scénáře.
- Ověření úspěšného výběru pomocí Postmanu.
- Ověření negativních scénářů pomocí Postmanu.
- Ověření změny balance pomocí DBeaveru.
- Ověření vytvoření WITHDRAWAL transaction pomocí DBeaveru.
- Ověření, že zamítnutý výběr nezmění balance ani nevytvoří transaction.

### PR-006 - Project Review po UC004

- Revize architektury projektu.
- Kontrola dokumentace.
- Kontrola technického dluhu.
- Rozhodnutí o High Priority položkách.
- Nebyla identifikována žádná nová High Priority položka.

### UC005 - Transfer Money

- Implementován endpoint POST /transfers.
- Přidán TransferMoneyRequest s validací vstupních dat.
- Přidán TransferResponse pro odpověď API.
- Přidán TransferService pro zpracování převodů.
- Přidána kontrola existence zdrojového a cílového účtu.
- Přidána kontrola, že zdrojový a cílový účet nejsou stejné.
- Přidána kontrola dostatečného balance zdrojového účtu.
- Implementováno snížení balance zdrojového účtu.
- Implementováno navýšení balance cílového účtu.
- Implementováno vytvoření Transfer se stavem COMPLETED.
- Implementováno vytvoření OUTBOUND Transaction na zdrojovém účtu.
- Implementováno vytvoření INBOUND Transaction na cílovém účtu.
- Obě Transaction jsou navázány na konkrétní Transfer.
- Transfer automaticky nastavuje createdAt pomocí JPA callbacku @PrePersist.
- Celá operace převodu je provedena v rámci jedné databázové transakce pomocí @Transactional.
- Přidána SameAccountTransferException pro převod mezi stejným účtem.
- Rozšířen GlobalExceptionHandler o zpracování SameAccountTransferException.
- Přidány automatizované controller testy pro pozitivní a negativní scénáře UC005.
- Ověřeno, že zamítnutý převod nemění balance a nevytváří Transfer ani Transaction.
- Pozitivní scénář ověřen pomocí Postmanu.
- Negativní scénáře ověřeny pomocí Postmanu.
- Změny balance, vytvoření Transfer a souvisejících Transaction ověřeny pomocí DBeaveru.

### PR-007 - Project Review po UC005

- Revize architektury projektu.
- Kontrola dokumentace.
- Kontrola technického dluhu.
- Aktualizace Technical Backlog.
- Nebyla identifikována žádná nová High Priority položka.
- TECH-008 - Refaktorizace endpointů Deposit/Withdraw byl zařazen do Medium Priority.

### UC006 - Issue Card

- Implementován endpoint POST /cards.
- Přidán CreateCardRequest s accountId.
- Přidán CardResponse pro odpověď API.
- Přidán CardService pro zpracování vydání karty.
- Přidán CardController pro REST API endpoint.
- Doplněn atribut createdAt do entity Card.
- Automatické nastavení createdAt pomocí JPA callbacku @PrePersist.
- Implementováno ověření existence účtu před vydáním karty.
- Implementováno generování unikátního 16místného čísla karty.
- Nová karta je při vydání nastavena do stavu ACTIVE.
- Implementována expirace karty 10 let od data vydání se stejným dnem a měsícem.
- Implementováno ověření unikátnosti čísla karty prostřednictvím CardRepository.
- Přidána validace accountId pomocí Jakarta Bean Validation.
- HTTP 201 při úspěšném vydání karty.
- HTTP 400 při nevalidním requestu.
- HTTP 404 při neexistujícím účtu.
- Automatizované controller testy vytvořeny pro pozitivní a negativní scénáře UC006.
- Pozitivní scénář ověřen pomocí Postmanu.
- Negativní scénáře ověřeny pomocí Postmanu.
- Uložení karty, vazba na účet, status, číslo karty, createdAt a expiryDate ověřeny pomocí DBeaveru.
- Ověřena unikátnost čísel karet v databázi.
- Ověřeno vydání více karet ke stejnému účtu.

### PR-008 - Project Review po UC006

- Revize architektury projektu.
- Kontrola dokumentace.
- Kontrola technického dluhu.
- Aktualizace Technical Backlog.
- Nebyla identifikována žádná nová technická položka.
- Nebyla identifikována žádná High Priority položka.
- Stávající Medium a Low Priority položky zůstávají v Technical Backlogu.
- Projekt je připraven na další Use Case.

### UC007 - Block Card

- Implementován endpoint PATCH /cards/{cardId}/block.
- Přidána metoda blockCard do CardController.
- Přidána metoda blockCard do CardService.
- Implementována kontrola existence karty.
- Implementováno blokování karty pouze ze stavu ACTIVE.
- Stav ACTIVE je změněn na BLOCKED.
- Implementována kontrola již blokované karty.
- Implementována kontrola expirované karty.
- Přidány výjimky:
  - CardNotFoundException
  - CardAlreadyBlockedException
  - ExpiredCardException
- Rozšířen GlobalExceptionHandler o zpracování nových výjimek.
- HTTP 200 při úspěšném zablokování karty.
- HTTP 404 při neexistující kartě.
- HTTP 400 při pokusu zablokovat již blokovanou kartu.
- HTTP 400 při pokusu zablokovat expirovanou kartu.
- Ověřeno, že při blokaci se mění pouze card_status.
- Ověřeno, že account_id, card_number, expiry_date a created_at zůstávají nezměněny.
- Přidány automatizované controller testy pro pozitivní a negativní scénáře UC007.
- Pozitivní scénář ověřen pomocí Postmanu.
- Negativní scénáře ověřeny pomocí Postmanu.
- Změna card_status a zachování ostatních atributů ověřeny pomocí DBeaveru.

### PR-009 - Project Review po UC007

- Revize architektury projektu.
- Kontrola dokumentace.
- Kontrola technického dluhu.
- Aktualizace Technical Backlog.
- Nebyla identifikována žádná nová technická položka.
- Nebyla identifikována žádná High Priority položka.
- Stávající Medium a Low Priority položky zůstávají v Technical Backlogu.
- Nebyl vytvořen nový technický dluh; ruční DTO mapping v CardService je pokryt stávající položkou TECH-003.
- Projekt je připraven na další Use Case.

---

### Další krok

Po dokončení Git workflow pro aktuální UCXXX bude následovat Project Review po UCXXX podle dokumentu DEVELOPMENT_WORKFLOW.md.

Project Review zahrne:

- kontrolu architektury,
- kontrolu dokumentace,
- kontrolu technického dluhu,
- aktualizaci Technical Backlog,
- rozhodnutí o případných High Priority položkách.

Po dokončení Project Review budou implementovány všechny položky označené jako **High Priority** v dokumentu:

`TECHNICAL_BACKLOG.md`

Teprve poté bude zahájen další Use Case.

Podrobný postup vývoje projektu je popsán v dokumentu:

`DEVELOPMENT_WORKFLOW.md`

---

## Filosofie učení

Porozumění je důležitější než rychlost.

Projekt by měl být budován postupně po jednotlivých krocích.

Cílem je pochopit principy, nikoliv generovat velké množství kódu.

Každé důležité návrhové rozhodnutí by mělo být vysvětleno.

Při navrhování řešení:
1. Nejprve vysvětli důvody návrhu.
2. Vysvětli business kontext.
3. Vysvětli dopady na testování.
4. Kód generuj pouze tehdy, pokud je to skutečně potřeba.

### Git workflow

* Od implementace dalších REST funkcionalit bude projekt využívat Git Feature Branch workflow.

* Každá samostatná funkcionalita bude implementována ve vlastní větvi, následně otestována a po dokončení sloučena do hlavní větve (main).

* Příklady názvů větví:
    - feature/client-get-endpoints
    - feature/client-update-delete
    - feature/client-validation
    - feature/uc002-open-account

* Cílem je přiblížit vývoj projektu běžné praxi používané ve vývojových týmech.
* Podrobnější pravidla vývoje projektu, Project Review, Technical Backlog a Definition of Done jsou popsány v dokumentu:

`DEVELOPMENT_WORKFLOW.md`

---

## Rozsah systému

Bankovní systém by měl v budoucnu podporovat:

* klienty
* účty
* platební karty
* transakce
* převody peněz

Další funkcionalita může být přidána později.

---

## Mimo rozsah projektu (zatím)

Následující témata by neměla být zaváděna, pokud nejsou výslovně požadována:

* AWS
* Azure
* Kubernetes
* Terraform
* Cloud Security
* Mikroservisy

Tato témata patří do budoucích projektů.

---

## Budoucí rozšíření

Po dokončení verze zaměřené na testování může být projekt rozšířen o:

* koncepty mainframe prostředí
* koncepty COBOLu
* koncepty JCL
* dávkové zpracování (batch processing)
* simulaci legacy bankovních systémů

Tyto oblasti by neměly ovlivňovat současný návrh databáze, pokud to není nezbytné.

---

## Instrukce pro AI

Při práci na tomto projektu:

1. Považuj tento dokument za hlavní zdroj informací o projektu.
2. Před návrhy si vždy přečti dostupnou projektovou dokumentaci.
3. Ověř aktuální stav projektu podle PROJECT_CONTEXT.md.
4. Ověř další plánovaný krok podle ROADMAP.md.
5. Ověř business požadavky podle BUSINESS_REQUIREMENTS.md.
6. Ověř technický dluh podle TECHNICAL_BACKLOG.md.
7. Udržuj všechny dokumenty navzájem konzistentní.
8. Zaměř se na realistické bankovní scénáře.
9. Vyhýbej se zbytečné složitosti.
10. Navrhuj další logický milník projektu.
11. Neimplementuj nový koncept bez předchozího vysvětlení jeho principu a důvodu použití.
12. Před implementací vysvětli business kontext, technický důvod návrhu a dopad na testování.
13. Preferuj porozumění principu před rychlostí implementace.
14. Při review aktivně hledej:
  - chyby,
  - chybějící požadavky,
  - technický dluh,
  - nekonzistenci dokumentace,
  - bezpečnostní problémy,
  - problémy testovatelnosti,
  - koncepty, které je potřeba znovu procvičit.
15. Návrh řešení musí předcházet implementaci.
16. Implementace nezačíná před schválením navrženého řešení.
17. Po významném milníku musí být aktualizována relevantní dokumentace.
18. Každý dokončený milník má obsahovat stručné vyhodnocení:
  - co bylo naučeno,
  - co bylo obtížné,
  - co je potřeba zopakovat,
  - co se má přenést do dalšího projektu.

---

## Aktuální úkol
* Byla vytvořena testovací databázová data.
* Datový model obsahuje:
    * 10 klientů
    * 15 účtů
    * 12 platebních karet
    * 20 převodů
    * 50 transakcí

* Byly ověřeny:
    * relace mezi entitami
    * primární klíče
    * cizí klíče
    * CHECK omezení
    * UNIQUE omezení

* Byl vytvořen SQL Exercise Pack. (docs/SQL_EXERCISES.md)
* Byl vytvořen SQL Validation Pack. (docs/SQL_VALIDATION.md)
* Byly vytvořeny regresní databázové kontroly.
* Fáze 1 je dokončena.

* Byl vytvořen základ Spring Boot projektu. Projekt obsahuje:
    - Spring Boot
    - Spring Data JPA
    - MySQL Driver
    - Maven konfiguraci

* Aplikace se úspěšně spouští.
* Konfigurace databázového připojení je dokončena.
* Byly vytvořeny 5 entit v package pro entity a jejich relace.
* Byly vytvořeny integrační testy pro ověření funkčnosti entit a jejich vazeb.

* Dokončen základní JPA model databáze.

* Byla dokončena první REST API funkcionalita:
    - UC001 - Create Client
      - Implementováno:
        - Vytvoření klienta.
        - Výpis všech klientů.
        - Detailní výpis klienta dle jeho ID.
        - Aktualizace údajů klienta dle jeho ID.
        - Odstranění klienta dle jeho ID.

* Endpoint POST /clients byl úspěšně otestován pomocí Postmanu.
* Endpoint GET /clients byl úspěšně otestován pomocí Postmanu.
* Endpoint GET /clients/{id} byl úspěšně otestován pomocí Postmanu.
* Endpoint PUT /clients/{id} byl úspěšně otestován pomocí Postmanu.
* Endpoint DELETE /clients/{id} byl úspěšně otestován pomocí Postmanu.
* 
* Bylo ověřeno uložení dat do databáze pomocí DBeaveru.

## Project Reviews
* Dalším plánovaným krokem po dokončení aktuálního úkolu (UCXXX/TECH-XXX) je Project Review #X.

* Součástí Project Review je:
  - kontrola architektury projektu,
  - kontrola dokumentace,
  - aktualizace Technical Backlog,
  - implementace všech položek označených jako High Priority.

* Po úspěšném dokončení Project Review bude zahájena implementace dalšího UCXXX+1/TECH-XXX+1 podle postupu definovaného v dokumentu DEVELOPMENT_WORKFLOW.md.

---

## Aktuální milestone
**UC001 – Client Management:** ✅ Dokončeno

**PR-001 – Project Review:** ✅ Dokončeno

**TECH-001 – Globální zpracování výjimek:** ✅ Dokončeno

**TECH-002 - Validace vstupních dat:** ✅ Dokončeno

**PR-002 - Project Review #2:** ✅ Dokončeno

**UC002 - Open Account:** ✅ Dokončeno

**PR-003 - Project Review po UC002:** ✅ Dokončeno

**UC003 - Deposit Money:** ✅ Dokončeno

**PR-004 - Project Review po UC003:** ✅ Dokončeno

**TECH-006 - Izolace testovací databáze:** ✅ Dokončeno

**PR-005 - Project Review po TECH-006:** ✅ Dokončeno

**UC004 - Withdraw Money:** ✅ Dokončeno

**PR-006 - Project Review po UC004:** ✅ Dokončeno

**UC005 - Transfer Money:** ✅ Dokončeno

**PR-007 - Project Review po UC005:** ✅ Dokončeno

**UC006 - Issue Card:** ✅ Dokončeno

**PR-008 - Project Review po UC006:** ✅ Dokončeno

**UC007 - Block Card:** ✅ Dokončeno

**PR-009 - Project Review po UC007:** ✅ Dokončeno

### Aktuálně probíhá:
- Další Use Case dle ROADMAP.md

### Následující krok / Další milestone:
- Zahájení dalšího Use Case podle ROADMAP.md a BUSINESS_REQUIREMENTS.md