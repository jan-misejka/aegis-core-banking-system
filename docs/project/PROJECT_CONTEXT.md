# Kontext projektu

## Účel dokumentu

Tento dokument popisuje stabilní kontext projektu Aegis Core Banking System.

Obsahuje základní informace potřebné k pochopení toho, proč projekt vznikl, jaký problém simuluje a v jakém technickém a studijním kontextu je používán.

Aktuální implementovaný stav projektu je veden samostatně v dokumentu `CURRENT_STATE.md`.

## Kontext projektu

Aegis Core Banking System je studijní a portfolio projekt simulující základní funkcionalitu bankovního informačního systému.

Projekt vznikl jako praktická simulace práce s enterprise business systémem, na kterém lze procvičovat:

- práci s business požadavky
- návrh a ověřování business pravidel
- relační databáze a SQL
- REST API
- testování API
- práci s testovacími daty
- ověřování dat v databázi
- tvorbu testovacích scénářů
- evidenci a popis chyb
- práci s technickou dokumentací
- práci s Git a verzováním

Projekt je současně používán jako portfolio ukázka schopnosti pracovat s reálným softwarem z pohledu testování a kvality.

## Doména

Aegis simuluje základní bankovní operace nad těmito hlavními doménovými oblastmi:

- klienti
- bankovní účty
- platební karty
- převody
- transakce

Business funkcionalita je organizována pomocí Use Cases.

Detailní business požadavky a plánované Use Cases jsou uvedeny v `docs/business/BUSINESS_REQUIREMENTS.md`.

## Technický kontext

Backendová část projektu je postavena na:

- Java
- Spring Boot
- Spring Data JPA
- REST API
- MySQL
- Maven
- JUnit

Databázová část projektu obsahuje relační model odpovídající bankovní doméně.

Projekt používá oddělené prostředí pro automatizované testování, aby testovací data neovlivňovala vývojovou databázi.

Podrobnosti o použitých technologiích jsou uvedeny v `docs/technical/TECH_STACK.md`.

Datový model je popsán v `docs/technical/DATABASE_MODEL.md`.

## Projektový kontext a způsob práce

Vývoj projektu probíhá iterativně.

Nová funkcionalita je navrhována a implementována jako samostatný Use Case nebo technický úkol.

Každá významnější změna má být:

1. implementována
2. otestována
3. ověřena proti požadavkům
4. zdokumentována
5. zaznamenána v Git historii

Detailní pravidla vývoje a Git workflow jsou uvedena v `docs/development/DEVELOPMENT_WORKFLOW.md`.

## Vztah k profesnímu cíli

Aegis je primárně zaměřen na přípravu pro práci Junior IT Tester / QA v bankovním a enterprise prostředí.

Projekt proto klade důraz nejen na implementaci funkcionality, ale také na schopnost:

- analyzovat požadavky
- navrhnout testovací scénáře
- ověřit pozitivní i negativní chování systému
- pracovat s API
- kontrolovat stav databáze
- reprodukovat chyby
- popsat očekávané a skutečné chování
- pracovat s důkazy o provedeném testování

## Budoucí rozšíření

Po dokončení hlavního rozsahu projektu může být Aegis rozšířen o prvky související s legacy a mainframe prostředím.

Plánované rozšíření může zahrnovat:

- flat files
- batch processing
- základní koncepty mainframe prostředí
- COBOL
- propojení moderního backendového systému s koncepty legacy prostředí

Konkrétní rozsah a pořadí těchto rozšíření určuje `docs/project/ROADMAP.md`.