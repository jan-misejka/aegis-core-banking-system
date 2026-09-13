# Test Data
## Aegis Core Banking System

## 1. Účel
Tento dokument popisuje testovací data používaná při testování projektu Aegis Core Banking System.

Slouží zejména k:
- identifikaci dat potřebných pro jednotlivé testovací scénáře
- popisu účelu testovacích dat
- zajištění opakovatelnosti testování
- propojení testovacích dat s Test Cases
- orientaci v testovacím datasetu

Tento dokument **neobsahuje samotný SQL dataset**.

Skutečná testovací data jsou uložena v:
- `database/test_data.sql`
- `database/test_data_part2.sql`

SQL soubory obsahují konkrétní záznamy používané k naplnění databáze.

---

## 2. Princip práce s testovacími daty
Testovací data musí odpovídat konkrétnímu testovacímu scénáři.

Před provedením testu musí být znám zejména:
- výchozí stav dat
- účel dat
- Use Case, pro který jsou data použita
- případné omezení nebo podmínky použití

Pokud test vyžaduje specifický stav databáze, musí být tento stav před testem zajištěn. Testovací data musí být podle potřeby obnovitelná tak, aby bylo možné test opakovat.

---

## 3. Testovací dataset
Aktuální testovací dataset obsahuje data pro hlavní doménové entity projektu:
- Client
- Account
- Card
- Transfer
- Transaction

Testovací data jsou určena především pro manuální API testování a následné databázové ověření. Aktuální testovací dataset používá pro účty měnu **CZK**. Podpora dalších měn je součástí business funkcionality účtu, ale aktuální testovací dataset je zjednodušeně zaměřen na CZK.

---

## 4. Identifikace Test Data
Testovací data používají identifikátor:
`TD-[UC]-[číslo]`

Příklad:
`TD-004-01`

kde:
- `TD` = Test Data
- `004` = Use Case UC004
- `01` = pořadové číslo testovacích dat

Identifikátor slouží k propojení testovacích dat s konkrétními Test Cases.

---

# 5. Test Data
## UC001 – Client Management
### TD-001-01 – Existující klient
- **Účel:** Testování operací nad existujícím klientem.
- **Použití:** TC-001-04, TC-001-06, TC-001-08
- **Stav:** Klient existuje v databázi.
- **Požadavky:** Data musí obsahovat validní údaje klienta.

### TD-001-02 – Neexistující klient
- **Účel:** Testování chování systému při práci s neexistujícím klientem.
- **Použití:** TC-001-05, TC-001-07
- **Stav:** Použité ID klienta neexistuje v databázi.

### TD-001-03 – Nový klient
- **Účel:** Testování vytvoření klienta.
- **Použití:** TC-001-01
- **Stav:** Data představují klienta, který dosud v databázi neexistuje.

### TD-001-04 – Nevalidní údaje klienta
- **Účel:** Testování negativních scénářů při vytváření klienta.
- **Použití:** TC-001-02
- **Stav:** Data obsahují hodnoty, které porušují požadavky na vstup.

---

## UC002 – Open Account
### TD-002-01 – Existující klient bez účtu pro nový test
- **Účel:** Testování otevření účtu pro existujícího klienta.
- **Použití:** TC-002-01
- **Stav:** Klient existuje a lze pro něj vytvořit účet.

### TD-002-02 – Neexistující klient
- **Účel:** Testování odmítnutí otevření účtu pro neexistujícího klienta.
- **Použití:** TC-002-02
- **Stav:** Použité ID klienta neexistuje.

### TD-002-03 – Validní typ účtu
- **Účel:** Testování podporovaných typů účtů.
- **Použití:** TC-002-01, TC-002-03
- **Stav:** Hodnota odpovídá podporovanému typu účtu.

### TD-002-04 – Nevalidní typ účtu
- **Účel:** Testování odmítnutí nepodporovaného typu účtu.
- **Použití:** TC-002-03
- **Stav:** Hodnota neodpovídá podporovanému typu účtu.

### TD-002-05 – Podporovaná měna
- **Účel:** Testování otevření účtu s podporovanou měnou.
- **Použití:** TC-002-04
- **Stav:** CZK, EUR nebo USD.

### TD-002-06 – Počáteční balance 0
- **Účel:** Ověření počátečního zůstatku nového účtu.
- **Použití:** TC-002-05
- **Stav:** Balance je 0.

---

## UC003 – Deposit Money
### TD-003-01 – Účet s běžným kladným zůstatkem
- **Účel:** Testování standardního vkladu.
- **Použití:** TC-003-01
- **Stav:** Účet existuje a má dostatečný zůstatek pro provedení testu.

### TD-003-02 – Částka 0
- **Účel:** Ověření odmítnutí nulového vkladu.
- **Použití:** TC-003-02
- **Hodnota:** 0

### TD-003-03 – Záporná částka
- **Účel:** Ověření odmítnutí záporného vkladu.
- **Použití:** TC-003-03
- **Hodnota:** Záporná částka.

### TD-003-04 – Minimální částka
- **Účel:** Ověření minimální povolené částky.
- **Použití:** TC-003-04
- **Hodnota:** 0,01

### TD-003-05 – Neexistující účet
- **Účel:** Testování vkladu na neexistující účet.
- **Použití:** TC-003-05
- **Stav:** Použité ID účtu neexistuje.

---

## UC004 – Withdraw Money
### TD-004-01 – Účet s dostatečným zůstatkem
- **Účel:** Testování standardního výběru.
- **Použití:** TC-004-01, TC-004-04
- **Stav:** Balance je vyšší nebo roven testované částce.

### TD-004-02 – Částka 0
- **Účel:** Ověření odmítnutí nulového výběru.
- **Použití:** TC-004-02
- **Hodnota:** 0

### TD-004-03 – Záporná částka
- **Účel:** Ověření odmítnutí záporného výběru.
- **Použití:** TC-004-03
- **Hodnota:** Záporná částka.

### TD-004-04 – Minimální částka
- **Účel:** Ověření minimální povolené částky.
- **Použití:** TC-004-04
- **Hodnota:** 0,01

### TD-004-05 – Nedostatečný zůstatek
- **Účel:** Ověření odmítnutí výběru vyššího než dostupný balance.
- **Použití:** TC-004-05
- **Stav:** Balance je nižší než požadovaná částka.

### TD-004-06 – Neexistující účet
- **Účel:** Testování výběru z neexistujícího účtu.
- **Použití:** TC-004-06
- **Stav:** Použité ID účtu neexistuje.

---

## UC005 – Transfer Money
### TD-005-01 – Zdrojový účet s dostatečným zůstatkem
- **Účel:** Testování úspěšného převodu.
- **Použití:** TC-005-01, TC-005-04
- **Stav:** Zdrojový účet má dostatečný balance.

### TD-005-02 – Cílový účet
- **Účel:** Testování přijetí převodu.
- **Použití:** TC-005-01, TC-005-04
- **Stav:** Cílový účet existuje.

### TD-005-03 – Částka 0
- **Účel:** Ověření odmítnutí nulového převodu.
- **Použití:** TC-005-02
- **Hodnota:** 0

### TD-005-04 – Záporná částka
- **Účel:** Ověření odmítnutí záporného převodu.
- **Použití:** TC-005-03
- **Hodnota:** Záporná částka.

### TD-005-05 – Minimální částka
- **Účel:** Ověření minimální povolené částky převodu.
- **Použití:** TC-005-04
- **Hodnota:** 0,01

### TD-005-06 – Nedostatečný zůstatek
- **Účel:** Ověření odmítnutí převodu při nedostatečném zůstatku.
- **Použití:** TC-005-05
- **Stav:** Balance zdrojového účtu je nižší než převáděná částka.

### TD-005-07 – Stejný zdrojový a cílový účet
- **Účel:** Ověření odmítnutí převodu na stejný účet.
- **Použití:** TC-005-06
- **Stav:** Source account a target account mají stejný účet.

### TD-005-08 – Neexistující cílový účet
- **Účel:** Ověření odmítnutí převodu na neexistující účet.
- **Použití:** TC-005-07
- **Stav:** Cílový účet neexistuje.

---

## UC006 – Issue Card
### TD-006-01 – Existující účet
- **Účel:** Testování vydání karty.
- **Použití:** TC-006-01, TC-006-04, TC-006-05
- **Stav:** Účet existuje.

### TD-006-02 – Neexistující účet
- **Účel:** Ověření odmítnutí vydání karty pro neexistující účet.
- **Použití:** TC-006-02
- **Stav:** Použité ID účtu neexistuje.

### TD-006-03 – Nově vydaná karta
- **Účel:** Ověření atributů nově vytvořené karty.
- **Použití:** TC-006-03, TC-006-05
- **Stav:** Karta byla právě vytvořena.

### TD-006-04 – Účet s více kartami
- **Účel:** Ověření možnosti vydání více karet pro jeden účet.
- **Použití:** TC-006-04
- **Stav:** Účet umožňuje vytvoření více karet.

---

## UC007 – Block Card
### TD-007-01 – Aktivní karta
- **Účel:** Testování zablokování aktivní karty.
- **Použití:** TC-007-01
- **Stav:** Card status = ACTIVE.

### TD-007-02 – Zablokovaná karta
- **Účel:** Testování opakovaného zablokování.
- **Použití:** TC-007-02
- **Stav:** Card status = BLOCKED.

### TD-007-03 – Neexistující karta
- **Účel:** Testování práce s neexistující kartou.
- **Použití:** TC-007-03
- **Stav:** Použité ID karty neexistuje.

### TD-007-04 – Expirovaná karta
- **Účel:** Ověření nepovoleného zablokování expirované karty.
- **Použití:** TC-007-04
- **Stav:** Card status = EXPIRED.

---

## UC008 – Unblock Card
### TD-008-01 – Zablokovaná karta
- **Účel:** Testování úspěšného odblokování karty.
- **Použití:** TC-008-01
- **Stav:** Card status = BLOCKED.

### TD-008-02 – Aktivní karta
- **Účel:** Testování odmítnutí odblokování již aktivní karty.
- **Použití:** TC-008-02
- **Stav:** Card status = ACTIVE.

### TD-008-03 – Expirovaná karta
- **Účel:** Testování odmítnutí odblokování expirované karty.
- **Použití:** TC-008-03
- **Stav:** Card status = EXPIRED.

### TD-008-04 – Neexistující karta
- **Účel:** Testování práce s neexistující kartou.
- **Použití:** TC-008-04
- **Stav:** Použité ID karty neexistuje.

---

## UC009 – Account Detail
### TD-009-01 – Existující účet
- **Účel:** Ověření úspěšného zobrazení detailu existujícího účtu.
- **Použití:** TC-009-01, TC-009-03, TC-009-04
- **Stav:** Účet ID 1 existuje a je dostupný pro čtení.

### TD-009-02 – Neexistující účet
- **Účel:** Ověření zpracování požadavku na neexistující účet.
- **Použití:** TC-009-02
- **Stav:** Použité ID účtu `999999` neexistuje.

---

# 6. Plánovaná Test Data
Testovací data pro následující Use Cases budou doplněna před zahájením jejich testování:
- UC010 – Client Accounts
- UC011 – Transaction History
- UC012 – Transfer Detail
- UC013 – Close Account

Testovací data budou definována podle konkrétních Test Cases a business pravidel příslušného Use Case.

---

# 7. Vztah k SQL testovacím datům
`TEST_DATA.md` dokumentuje **účel a použití** testovacích dat.

Konkrétní data jsou uložena v SQL souborech:
- `database/test_data.sql`
- `database/test_data_part2.sql`

Při změně SQL datasetu musí být podle potřeby aktualizován také tento dokument.

Pokud je přidáno nové testovací data pro konkrétní scénář, musí být možné určit:
`Test Case → Test Data → SQL dataset`

---

# 8. Údržba dokumentu
Dokument se aktualizuje při:
- přidání nového Use Case
- vytvoření nového Test Case
- přidání nového testovacího scénáře
- změně testovacích dat
- změně účelu existujících testovacích dat
- odstranění nebo nahrazení testovacích dat

Výsledky konkrétního použití testovacích dat se do tohoto dokumentu nezapisují. Ty patří do `docs/qa/TEST_RUNS.md`. Identifikátory Test Data jsou stabilní a nemění se při opakovaném použití dat v dalších Test Runs.