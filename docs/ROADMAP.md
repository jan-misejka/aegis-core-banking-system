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

#### Další business funkcionalita
* UC004 – Withdraw Money ⏳
* UC005 – Transfer Money ⏳
* UC006 – Issue Card ⏳
* UC007 – Block Card ⏳

### Bankovní funkcionalita
* API pro účty ⏳
* API pro transakce ⏳
* API pro platební karty ⏳

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

---

## Aktuální stav
* Fáze 1 – Databáze: dokončena.
* Fáze 2 – Backend: dokončena základní JPA vrstva.
* Fáze 3 – REST API: probíhá.

Dokončené milníky:
* UC001 – Client Management
* PR-001 – Project Review po UC001
* TECH-001 – Globální zpracování výjimek
* TECH-002 – Validace vstupních dat
* PR-002 – Project Review po TECH-001,002
* UC002 – Open Account
* PR-003 – Project Review po UC002
* UC003 – Deposit Money
* PR-004 – Project Review po UC003
* TECH-006 – Izolace testovací databáze
* PR-005 – Project Review po TECH-006

Aktuálně:
* UC004 – Withdraw Money

Další business funkcionalita:
* 

## Poznámka
Jednotlivé fáze na sebe navazují a neměly by být přeskakovány.

Každá fáze by měla být dokončena a zdokumentována před zahájením následující fáze.

Od REST API bude každá větší funkcionalita implementována ve vlastní Git Feature Branch.

Doporučený postup:
1. vytvoření nové větve z main
2. implementace funkcionality
3. lokální testování
4. aktualizace dokumentace
5. commit
6. merge do větve main
7. odstranění dokončené větve

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

**Probíhá**

🔄 UC004 - Withdraw Money

**Následuje**

⏳ 