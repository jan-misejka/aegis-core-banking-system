# Roadmapa projektu

## Fáze 1 – Databáze
* návrh logického databázového modelu ✅
* vytvoření dokumentace:
    - docs/DATABASE_MODEL.md ✅
* návrh atributů entit ✅
* vytvoření fyzického databázového schématu (schema.sql) ✅
* vytvoření testovacích dat ✅
* vytvoření SQL cvičení a dotazů ✅

## Fáze 2 – Backend (Spring Boot)
* vytvoření projektu ✅
* konfigurace připojení k MySQL ✅
* vytvoření entit ✅
* vytvoření repository vrstev ✅

## Fáze 3 – REST API

### Studijní cíl Level 01 – Foundation

Aegis má během této fáze prokázat porozumění:

* Java
* Spring Boot
* Maven
* REST API
* HTTP
* JSON
* SQL
* MySQL
* DBeaver
* Postman
* Git/GitHub
* Jira
* requirements
* Use Cases
* základní software architecture
* testing
* documentation
* SDLC

Cílem není pouze implementovat jednotlivé endpointy, ale pochopit celý proces od business požadavku přes návrh a implementaci až po testování, review, dokumentaci a Git workflow.

### Client API
#### UC001 – Client Management
* Create Client (POST /clients) ✅
* Get All Clients (GET /clients) ✅
* Get Client by ID (GET /clients/{id}) ✅
* Update Client (PUT /clients/{id}) ✅
* Delete Client (DELETE /clients/{id}) ✅

#### PR-001 - Project Review po UC001
* Revize architektury projektu ✅
* Kontrola dokumentace ✅
* Aktualizace Technical Backlog ✅

#### High Priority (Technical Backlog)
* TECH-001 – Globální zpracování výjimek ✅
* TECH-002 – Validace vstupních dat ✅

#### PR-002 - Project Review po TECH-001,002
* Revize architektury projektu ✅
* Kontrola dokumentace ✅
* Aktualizace Technical Backlog ✅
* High Priority položky ✅

### Account API
#### UC002 – Open Account
* Create Account (POST /accounts) ✅
* Validace existence klienta ✅
* Validace typu účtu (CURRENT / SAVINGS) ✅
* Validace měny (CZK / EUR / USD) ✅
* Výchozí zůstatek účtu 0 ✅
* Generování IBAN ✅
* Ověření vytvoření účtu v databázi ✅

#### PR-003 - Project Review po UC002
* Revize architektury projektu ✅
* Kontrola dokumentace ✅
* Aktualizace Technical Backlog ✅
* Rozhodnutí o High Priority položkách ✅

#### High Priority (Technical Backlog)
* Žádné

#### UC003 - Deposit Money
* POST /accounts/{id}/deposit ✅
* Validace částky ✅
* Navýšení balance účtu ✅
* Vytvoření DEPOSIT transaction ✅
* Ověření dat v databázi ✅
* Automatizované controller testy ✅

#### PR-004 - Project Review po UC003
* Revize architektury projektu ✅
* Kontrola dokumentace ✅
* Kontrola technického dluhu ✅
* Aktualizace Technical Backlog ✅
* Identifikace TECH-006 - Izolace testovací databáze ✅
* Rozhodnutí o High Priority položkách ✅

#### High Priority (Technical Backlog)
* TECH-006 - Izolace testovací databáze ✅

#### PR-005 - Project Review po TECH-006
* Revize architektury projektu ✅
* Kontrola dokumentace ✅
* Kontrola technického dluhu ✅
* Aktualizace Technical Backlog ✅

#### UC004 - Withdraw Money
* POST /accounts/{id}/withdraw ✅
* Validace částky ✅
* Kontrola existence účtu ✅
* Kontrola dostatečného balance ✅
* Snížení balance účtu ✅
* Vytvoření WITHDRAWAL transaction ✅
* Ověření dat v databázi ✅
* Automatizované controller testy ✅

#### PR-006 - Project Review po UC004
* Revize architektury projektu ✅
* Kontrola dokumentace ✅
* Kontrola technického dluhu ✅
* Rozhodnutí o High Priority položkách ✅

#### High Priority (Technical Backlog)
* Žádné

#### UC005 - Transfer Money
* POST /transfers ✅
* Validace částky ✅
* Kontrola existence zdrojového účtu ✅
* Kontrola existence cílového účtu ✅
* Kontrola, že zdrojový a cílový účet nejsou stejné ✅
* Kontrola dostatečného balance zdrojového účtu ✅
* Snížení balance zdrojového účtu ✅
* Navýšení balance cílového účtu ✅
* Vytvoření COMPLETED Transfer ✅
* Vytvoření OUTBOUND transaction ✅
* Vytvoření INBOUND transaction ✅
* Ověření vazby Transaction → Transfer ✅
* Ověření dat v databázi ✅
* Automatizované controller testy ✅
* Pozitivní a negativní scénáře ověřeny pomocí Postmanu ✅

#### PR-007 - Project Review po UC005
* Revize architektury projektu ✅
* Kontrola dokumentace ✅
* Kontrola technického dluhu ✅
* Aktualizace Technical Backlog ✅
* Rozhodnutí o High Priority položkách ✅

#### High Priority (Technical Backlog)
* Žádné

#### UC006 - Issue Card
* POST /cards ✅
* Validace existence účtu ✅
* Validace accountId pomocí Bean Validation ✅
* Generování unikátního 16místného čísla karty ✅
* Nastavení card_status = ACTIVE při vydání ✅
* Nastavení created_at pomocí @PrePersist ✅
* Nastavení expiry_date na 10 let od data vydání ✅
* Ověření vydání více karet ke stejnému účtu ✅
* Ověření dat v databázi ✅
* Automatizované controller testy ✅
* Pozitivní a negativní scénáře ověřeny pomocí Postmanu ✅

#### PR-008 - Project Review po UC006
* Revize architektury projektu ✅
* Kontrola dokumentace ✅
* Kontrola technického dluhu ✅
* Aktualizace Technical Backlog ✅
* Rozhodnutí o High Priority položkách ✅

#### High Priority (Technical Backlog)
* Žádné

#### UC007 - Block Card
* PATCH /cards/{cardId}/block ✅
* Kontrola existence karty ✅
* Kontrola, že karta není již BLOCKED ✅
* Kontrola, že karta není EXPIRED ✅
* Změna card_status z ACTIVE na BLOCKED ✅
* Ověření, že ostatní atributy karty zůstávají nezměněny ✅
* Ověření dat v databázi ✅
* Automatizované controller testy ✅
* Pozitivní a negativní scénáře ověřeny pomocí Postmanu ✅

#### PR-009 - Project Review po UC007
* Revize architektury projektu ✅
* Kontrola dokumentace ✅
* Kontrola technického dluhu ✅
* Aktualizace Technical Backlog ✅
* Rozhodnutí o High Priority položkách ✅

#### High Priority (Technical Backlog)
* Žádné

#### Další business funkcionalita
* 

### Bankovní funkcionalita
* API pro účty ⏳
* API pro transakce ⏳
* API pro platební karty ⏳

---

## Level 01 – Aegis Exit Gate

Aegis / Level 01 je považován za dokončený, pokud projekt prokáže:

* funkční základní bankovní aplikace,
* funkční REST API,
* základní business Use Cases,
* databázovou vrstvu,
* SQL znalosti a databázové ověřování,
* pozitivní a negativní testování,
* práci s Postmanem,
* práci s Git/GitHub,
* dokumentovaný vývojový workflow,
* průběžně aktualizovanou projektovou dokumentaci,
* evidenci technického dluhu,
* Project Reviews,
* schopnost vysvětlit použité technologie a návrhová rozhodnutí.

### Portfolio rozsah

Pro portfolio má projekt navíc prokazovat:

* realistické business požadavky,
* Use Cases,
* testovací scénáře,
* bug reporting,
* evidence testování,
* konzistentní projektovou dokumentaci,
* Git historii odpovídající vývoji projektu,
* schopnost nového člověka pochopit projekt z dokumentace.

### Bonus / Bridge

Volitelně může být provedena pouze malá příprava na následující projekt.

Bonus nesmí změnit Aegis na nový integrační nebo automatizační projekt.

Příklady:

* návrh HTTP/API kontraktu,
* jednoduchá test matrix,
* návrh struktury dokumentace pro další projekt,
* krátký zápis o převzetí projektu novým členem týmu.

Bonus nesmí nahradit hlavní učivo následujícího projektu.

---

## Fáze 4 – Testování API
* vytvoření Postman kolekcí ⏳
* pozitivní testy ⏳
* negativní testy ⏳

## Fáze 5 – Simulace práce testera
* návrh testovacích scénářů (Test Cases) ⏳
* tvorba bug reportů ⏳
* provádění a evidence testů ⏳

## Fáze 6 – Legacy/Mainframe prostředí
* práce s flat files ⏳
* dávkové zpracování (Batch Processing) ⏳
* základní koncepty mainframe prostředí ⏳
* základní koncepty COBOLu ⏳

### Poznámka

Fáze 4 a Fáze 5 nejsou pouze technické úkoly.

Jejich cílem je vytvořit portfolio důkazů o schopnosti:

* odvodit testy z business požadavků,
* testovat API,
* pracovat s pozitivními i negativními scénáři,
* reprodukovat chybu,
* vytvořit bug report,
* provést regresní ověření,
* zdokumentovat výsledek testování,
* formulovat evidence-based závěr.

---

## Aktuální stav
* Fáze 1 – Databáze: dokončena.
* Fáze 2 – Backend: dokončena základní JPA vrstva.
* Fáze 3 – REST API: probíhá.

## Poznámka
Jednotlivé fáze na sebe navazují a neměly by být přeskakovány.

Každá fáze by měla být dokončena a zdokumentována před zahájením následující fáze.

Od REST API bude každá větší funkcionalita implementována ve vlastní Git Feature Branch.

Doporučený postup:
1. vytvoření nové větve z main
2. implementace funkcionality
3. lokální testování
4. commit
5. merge do větve main
6. Project Review
7. aktualizace dokumentace
8. implementace všech relevantních High Priority položek
9. Project Review po Hight Priority položkách
10. odstranění dokončené větve
11. push na GitHub

Každá Feature Branch by měla představovat jednu logicky uzavřenou funkcionalitu projektu.

Po dokončení každého business Use Casu nebo významného technického milníku probíhá Project Review.

Teprve po jeho dokončení a implementaci všech položek označených jako **High Priority** začíná implementace dalšího Use Casu.

Podrobný postup vývoje je popsán v dokumentu:

`DEVELOPMENT_WORKFLOW.md`

Po dokončení významného milníku je nutné aktualizovat:
* PROJECT_CONTEXT.md
* PROJECT_VISION.md
* BUSINESS_REQUIREMENTS.md
* ROADMAP.md
* (CHANGELOG.md)

---

## Aktuální milestone

**Dokončeno**

✅ UC001 – Client Management
✅ PR-001 – Project Review po UC001
✅ TECH-001 – Globální zpracování výjimek
✅ TECH-002 - Validace vstupních dat
✅ PR-002 – Project Review po TECH-002
✅ UC002 - Open Account
✅ PR-003 - Project Review po UC002
✅ UC003 - Deposit Money
✅ PR-004 - Project Review po UC003
✅ TECH-006 - Izolace testovací databáze
✅ PR-005 - Project Review po TECH-006
✅ UC004 - Withdraw Money
✅ PR-006 - Project Review po UC004
✅ UC005 - Transfer Money
✅ PR-007 - Project Review po UC005
✅ UC006 - Issue Card - implementováno a otestováno
✅ PR-008 - Project Review po UC006
✅ UC007 - Block Card - implementováno a otestováno
✅ PR-009 - Project Review po UC007

**Probíhá**

**Následuje**
⏳ Další Use Case dle ROADMAP.md a BUSINESS_REQUIREMENTS.md