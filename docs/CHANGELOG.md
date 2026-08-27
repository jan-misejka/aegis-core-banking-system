## 2026-06-7 - JM
- Vytvořen GitHub repozitář
- Nastavení workflow s AI
- Vytvoření projektu AegisCore Banking System v ChatGPT

## 2026-06-10 - JM
- Vytvořena projektová dokumentace
- Dokumentace přidána jako zdroje do projektu ChatGPT
- Nastavení workflow projektu ChatGPT

## 2026-06-11 - JM
- Vytvořen a schválen databázový model (DM)
- DM vložen jako zdroj do projektu ChatGPT
- Aktualizace dokumentace (PROJECT_CONTEXT.md, ROADMAP.md) a jeho implementace do zdrojů projektu AI
- Aktualizace DM navržením atributů pro jednotlivé entity a aktualizace dokumentace (DATABASE_MODEL.md, PROJECT_CONTEXT.md, ROADMAP.md)
- Vytvořeno databázové schéma (database/schema.sql) na základě DM a aktualizace dokumentace (DATABASE_MODEL.md, PROJECT_CONTEXT.md, ROADMAP.md)
- Update DM: rozšíření entity transaction o atribut transfer_id a aktualizace dokumentace (DATABASE_MODEL.md, PROJECT_CONTEXT.md, ROADMAP.md)
- Vytvoření a uploadování testovacích dat do databáze (database/test_data.sql, database/test_data_part2.sql) a aktualizace dokumentace (DATABASE_MODEL.md, PROJECT_CONTEXT.md, ROADMAP.md)

## 2026-06-15 - JM
- Vytvořeny testovací úlohy a validační testy (SQL_EXERCISES.md, SQL_VALIDATION.md)
- Import konkrétních úloh do dokumentů (SQL_EXERCISES.md, SQL_VALIDATION.md)
- Aktualizace dokumentace (DATABASE_MODEL.md, PROJECT_CONTEXT.md, ROADMAP.md) a implmentace do zdrojů projektu AI (SQL_EXERCISES.md, SQL_VALIDATION.md)
- Vytvoření nového projektu Spring Boot pro implementaci backendu a nastavení základní struktury projektu
- Aktualizace dokumentace (PROJECT_CONTEXT.md, ROADMAP.md)

## 2026-06-18 - JM
- Import souborů Spring Boot (pom.xml, src/main/java..., src/resources/application.properties) do zdrojů projektu ChatGPT

## 2026-06-20 - JM
- Konfigurace připojení k databázi v souboru application.properties
- Úspěšné spuštění Spring Boot aplikace a ověření připojení k databázi aegiscore_banking
- Vytvoření package pro entity a implementace entity třídy Client -> aktualizace dokumentace (PROJECT_CONTEXT.md)
- Úprava entity třídy Client zahrnutím @GeneratedValue(strategy = GenerationType.IDENTITY) a vytovření první repository vrstvy pro entitu Client -> aktualizace dokumentace (PROJECT_CONTEXT.md)
- Vytvoření prvního integračního testu pro entitu Client -> aktualizace dokumentace (PROJECT_CONTEXT.md)
- Vytvoření package pro repository a implementace repository třídy ClientRepository -> aktualizace dokumentace (PROJECT_CONTEXT.md)
- Vytvoření Account entity a první JPA relace Account → Client -> aktualizace dokumentace (PROJECT_CONTEXT.md)
- Vytvoření AccountRepository a první integrační test pro entitu Account -> aktualizace dokumentace (PROJECT_CONTEXT.md)
- Vytvoření Card entity a první JPA relace Card → Account -> aktualizace dokumentace (PROJECT_CONTEXT.md)
- Vytvoření CardRepository a první integrační test pro entitu Card -> aktualizace dokumentace (PROJECT_CONTEXT.md)

## 2026-06-21 - JM
- Vytvoření Transfer entity a relací sourceAccount, targetAccount -> aktualizace dokumentace (PROJECT_CONTEXT.md)
- Vytvoření TransferRepository a první integrační test pro entitu Transfer -> aktualizace dokumentace (PROJECT_CONTEXT.md)
- Vytvoření Transaction entity -> aktualizace dokumentace (PROJECT_CONTEXT.md)
- Oprava Transaction entity mapování v databázovém schámatu, přidání chybějícího pole, oprava odkazujících atributů (tx_id, tx_type, tx_date mapování)
- Aktualizace zdrojů projektu ChatGPT

## 2026-07-28 - JM
- Přidání 'target/' do .gitignore
- Odstraněny Maven build artefakty z verzování pomocí Gitu
- Aktualizace ROADMAP.md
- Vytvoření složek controller, dto a service s příslušnými třdami pro implementaci REST API (pro entitu Client)

## 2026-07-29 - JM
- Implementace ClientController, ClientService a DTO tříd CreateClientRequest a ClientResponse pro REST API (entita Client)
- Vytvoření workspace v Postman pro testování REST API a vytvoření prvního testovacího requestu pro POST /clients
- Aktualizace entity Client - přidání JPA callbacku @PrePersist pro automatické nastavení atributu createdAt
- Implementace endpointu POST /clients (UC001 - Create Client)
- Úspěšné otestování endpointu POST /clients pomocí Postman
- Ověření uložení nového klienta do databáze pomocí DBeaver
- Aktualizace dokumentace (PROJECT_CONTEXT.md, ROADMAP.md)
- Aktualizace zdrojů projektu ChatGPT

## 2026-08-05 - JM
- Implementace endpointu GET /clients.
- Ověření funkčnosti endpointu pomocí Postman.
- Ověřena konzistence dat s databází v DBeaver.
- Aktualizace dokumentace (PROJECT_CONTEXT.md, ROADMAP.md)

## 2026-08-10 - JM
- Implementace endpointu GET /clients/{id}.
- Přidána možnost získat detail klienta podle ID.
- Implementována odpověď HTTP 404 pro neexistujícího klienta.
- Funkčnost ověřena pomocí Postman a DBeaver.
- Implementace endpointu PUT /clients/{id}.
- Přidána možnost aktualizace údajů existujícího klienta.
- Implementována odpověď HTTP 404 při pokusu o aktualizaci neexistujícího klienta.
- Vytvořeno DTO UpdateClientRequest.
- Funkčnost ověřena pomocí Postman a DBeaver.

## 2026-08-11 - JM
- Implementace endpointu DELETE /clients/{id}.
- Dokončen CRUD pro entitu Client.
- Implementována odpověď HTTP 204 po úspěšném smazání klienta.
- Implementována odpověď HTTP 404 při pokusu o smazání neexistujícího klienta.
- Funkčnost ověřena pomocí Postman a DBeaver.

- Vytvoření nových dokumentů DEVELOPMENT_WORKFLOW.md a TECHNICAL_BACKLOG.md.
- Aktualizace dokumentu README.md s informacemi o nových dokumentech.
- Aktualizace dokumentu PROJECT_CONTEXT.md s informacemi o nových dokumentech.
- Aktualizace dokumentu ROADMAP.md s informacemi o nových dokumentech.
- Aktualizace dokumentu BUSINESS_REQUIREMENTS.md s informacemi o nových dokumentech.
- Aktualizace dokumentu TECHNICAL_BACKLOG.md s informacemi o nových dokumentech.
- Aktualizace dokumentu PROJECT_VISION.md s informacemi o nových dokumentech.

## 2026-08-12 - JM
- Zkouška nového postupu s AI - vložení dokumentace do Project Knowledge Base a vygenerování promptu pro pokračování v projektu.
- Přejmenování Project Review #1 na PRXXX po UCXXX.
- Aktualizace dokumentace.

## 2026-08-14 - JM
- Zpracování PR-001.
- Implementace TECH-001 – Globální zpracování výjimek.
- Přidána výjimka ClientNotFoundException pro neexistujícího klienta.
- Přidán GlobalExceptionHandler pomocí @ControllerAdvice.
- Odstraněno ruční vracení null/boolean při hledání neexistujícího klienta v ClientService.
- Upraven ClientController tak, aby chybové scénáře řešil globální exception handler.
- Přidány controller testy pro ověření HTTP 404 při GET, PUT a DELETE neexistujícího klienta.
- Opraveny zastaralé assertions v AccountRepositoryTest a CardRepositoryTest (Jan → Honza).
- Všechny Maven testy úspěšně prošly.

## 2026-08-16 - JM
- Zpracování TECH-002: ->
- Dokončena implementace TECH-002 – Validace vstupních dat.
- Přidána Jakarta Bean Validation podpora pomocí `spring-boot-starter-validation`.
- Přidána validace `CreateClientRequest` a `UpdateClientRequest` pomocí `@NotBlank`, `@Email` a `@Size`.
- Aktivována validace REST requestů pomocí `@Valid`.
- Rozšířen `GlobalExceptionHandler` o zpracování `MethodArgumentNotValidException`.
- Přidány automatické controller testy pro nevalidní POST a PUT requesty.
- Validace ověřena manuálně pomocí Postmanu.
- Ověřeno, že nevalidní POST/PUT requesty nevedou ke změně databázových dat.
- Všechny Maven testy úspěšně prošly.

## 2026-08-18 - JM
- PR-002: review provedeno -> prošlo, žádné nové změny nejsou potřeba a nebyly nalezeny žádné dluhy.
- UC002: Implementace.

## 2026-08-19 - JM
- Pokračování implementace UC002: Controller, Service, Exceptions.
- Pozitivní testing, negativní testing

## 2026-08-20 - JM
- Aktualizace dokumentace po UC002.
- Provedeno PR-003 – Project Review po UC002.
- PR-003 neidentifikoval žádnou High Priority položku.
- Do Technical Backlogu přidána položka TECH-005 – Automatizované testy UC002 s prioritou Medium.
- TECH-003 a TECH-004 zůstávají ve stavu Medium Priority.

## 2026-08-26 - JM
- Aktualizace dokumentace (ROADMAP.md).
- Návrh a implementace UC003 - Deposit Money.
- Přidán DepositMoneyRequest s validací částky pomocí Jakarta Bean Validation.

## 2026-08-27 - JM
- Přidána AccountNotFoundException pro neexistující účet.
- Rozšířen AccountService o funkci depositMoney().
- Přidáno vytvoření DEPOSIT Transaction při provedení vkladu.
- Přidána databázová transakce pomocí @Transactional pro změnu balance a vytvoření Transaction.
- Přidán endpoint POST /accounts/{id}/deposit.
- Implementovány automatizované controller testy pro pozitivní a negativní scénáře UC003.
- Pozitivní scénář ověřen pomocí Postmanu.
- Negativní scénáře ověřeny pomocí Postmanu.
- Změna balance a vytvoření DEPOSIT Transaction ověřeny pomocí DBeaveru.
- Během automatizovaného testování identifikován problém s izolací testovací databáze; bude vyhodnocen během PR-004.
- Zpracování PR-004: Project Review #4 po UC003.

## 2026-08-28 - JM
- Dokončeno PR-004.
- Do Technical Backlogu přidána položka TECH-006 - Izolace testovací databáze.
- TECH-006 označena jako High Priority.
- Aktualizace zdrojů pro ChatGPT.
- 