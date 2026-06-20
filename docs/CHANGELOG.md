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