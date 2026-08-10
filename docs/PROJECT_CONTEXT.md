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

## Aktuální fáze

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
└── README.md
└── TECH_STACK.md

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
    - 
* Endpoint POST /clients úspěšně vytváří klienta v databázi prostřednictvím repository vrstvy.
* Endpoint GET /clients úspěšně vrací seznam všech klientů z databáze.
* Endpoint GET /clients/{id} úspěšně vrací detail klienta podle jeho ID.
* Entita Client automaticky nastavuje atribut createdAt pomocí JPA callbacku @PrePersist.
* Funkčnost endpointů byla úspěšně ověřena pomocí Postmanu a DBeaveru.

#### Plán implementace REST API

* Další vývoj REST API bude probíhat po jednotlivých entitách. Každá entita bude nejprve implementována jako kompletní CRUD funkcionalita a teprve poté bude projekt pokračovat dalšími business use cases.
* Aktuální pořadí implementace:
    1. UC001 - Create Client
    2. GET /clients
    3. GET /clients/{id}
    4. PUT /clients/{id}
    5. DELETE /clients/{id}
    6. Validace vstupních dat
    7. Globální zpracování výjimek (Exception Handling)
    8. UC002 - Create Account
    9. 

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

* Endpoint POST /clients byl úspěšně otestován pomocí Postmanu.
* Endpoint GET /clients byl úspěšně otestován pomocí Postmanu.
* Endpoint GET /clients/{id} byl úspěšně otestován pomocí Postmanu.
* 
* Bylo ověřeno uložení dat do databáze pomocí DBeaveru.

* Dalším plánovaným krokem je rozšíření Client API o další CRUD operace a validaci vstupních dat.