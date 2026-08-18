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

#### Další business funkcionalita
* UC002 – Open Account ⏳

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
* Logický databázový model verze 1 byl schválen.
* Model obsahuje entity:
    - Client
    - Account
    - Card
    - Transaction
    - Transfer

* Byly schváleny atributy všech entit.
* Byly definovány základní business hodnoty:
    - Account Type
        - CURRENT
        - SAVINGS

    - Card Status
        - ACTIVE
        - BLOCKED
        - EXPIRED

    - Transaction Type (tx_type)
        - DEPOSIT
        - WITHDRAWAL
        - INBOUND
        - OUTBOUND

    - Transfer Status
        - PENDING
        - COMPLETED
        - FAILED

* Detailní popis modelu je uložen v:
  docs/DATABASE_MODEL.md

* Byla vytvořena první verze testovacích dat.
* Testovací dataset obsahuje:
    * 10 klientů
    * 15 účtů
    * 12 platebních karet
    * 20 převodů
    * 50 transakcí

* Byly ověřeny vazby mezi všemi entitami databázového modelu.
* Byla doplněna vazba:
  Transfer → Transaction

prostřednictvím atributu:
```
transfer_id
```
* Byly vytvořeny SQL cvičení a validační testy pro všechny entity a jejich vazby. Cvičení a testy jsou uloženy v:
  docs/SQL_EXERCISES.md
  docs/SQL_VALIDATION.md
* Byl dokončen základní JPA model databáze s entitami, jejich repository a relacemi (viz PROJECT_CONTEXT.md)

* Byla dokončena první REST API funkcionalita:
    - UC001 - Client Management

* Implementován endpoint:
    - POST /clients

* Funkčnost endpointu byla ověřena pomocí Postmanu.
* Bylo ověřeno správné ukládání dat do databáze pomocí DBeaveru.


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

Po dokončení každého business Use Casu probíhá Project Review.

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

**Probíhá**

🔄 Dokončení TECH-002: dokumentace, Git

**Následuje**

1. UC002 – Open Account