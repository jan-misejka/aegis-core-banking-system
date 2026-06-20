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
target/
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

#### Implementace repository vrstvy
* Byla vytvořena repository vrstva pro entitu Client (ClientRepository).
* Byla vytvořena repository vrstva pro entitu Account (AccountRepository).
* Byla vytvořena repository vrstva pro entitu Card (CardRepository).
* Byla vytvořena repository vrstva pro entitu Transfer (TransferRepository).

#### Implementace JPA relací
* Byla vytvořena a ověřena relace Account -> Client.
* Byla vytvořena a ověřena relace Card -> Account.
* Byla vytvořena a ověřena relace Card -> Account -> Client.
* Byly vytvořeny a ověřeny relace Transfer -> Account (sourceAccount, targetAccount).

#### Implementace integračních testů
* Byl vytvořen první integrační test pro entitu Client.
* Byl vytvořen první integrační test pro entitu Account.
* Byl vytvořen první integrační test pro entitu Card.
* Byl vytvořen první integrační test pro entitu Transfer.


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
* Byla vytvořena první entita Client v package pro entity.

* Další krok je dokončit implementaci všech entit a jejich vazeb.