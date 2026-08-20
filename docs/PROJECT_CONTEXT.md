# Aegis Core Banking System – Kontext projektu

## Účel projektu

Aegis Core Banking System je dlouhodobý studijní projekt navržený pro simulaci realistického bankovního prostředí.

Hlavním cílem projektu je příprava na pozici Junior IT Tester v bankovním a enterprise prostředí.

Projekt by se měl postupně vyvíjet od návrhu databáze a testování k pokročilejším bankovním konceptům.

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

## Aktuální fáze: Fáze 3 - REST API

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

REST API zatím nebylo implementováno.

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

### Další krok

Po dokončení Git workflow pro UC002 bude následovat Project Review po UC002 podle dokumentu DEVELOPMENT_WORKFLOW.md.

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
3. Zaměř se na bankovní testování a výuku databází.
4. Preferuj realistické bankovní scénáře.
5. Vyhýbej se zbytečné složitosti.
6. Navrhuj další logický milník projektu.
7. Udržuj doporučení v souladu s aktuální fází projektu.

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

* Dalším plánovaným krokem je dokončení Project Review #1.

* Součástí Project Review je:
  - kontrola architektury projektu,
  - kontrola dokumentace,
  - aktualizace Technical Backlog,
  - implementace všech položek označených jako High Priority.

* Po úspěšném dokončení Project Review bude zahájena implementace UC002 – Open Account podle postupu definovaného v dokumentu DEVELOPMENT_WORKFLOW.md.

---

## Aktuální milestone
**UC001 – Client Management:** ✅ Dokončeno
**PR-001 – Project Review:** ✅ Dokončeno
**TECH-001 – Globální zpracování výjimek:** ✅ Dokončeno
**TECH-002 - Validace vstupních dat:** ✅ Dokončeno
**PR-002 - Project Review #2:** ✅ Dokončeno
**UC002 - Open Account:** ✅ Dokončeno
**PR-003 - Project Review po UC002:** ✅ Dokončeno

### Aktuálně probíhá:
- Příprava na UC003 – Deposit Money

### Následující krok / Další milestone:
- UC003 – Deposit Money