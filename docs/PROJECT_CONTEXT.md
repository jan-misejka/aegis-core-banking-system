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
README.md
```

---

## Aktuální fáze

### Fáze 1 – Návrh databáze

Aktuální databáze:

```text
aegiscore_banking
```

Aktuální stav repozitáře:

```text
database/
└── schema.sql
```

Databázové schéma je momentálně ve fázi návrhu.

REST API zatím nebylo implementováno.

Spring Boot aplikace zatím nebyla implementována.

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

Navrhnout první verzi databázového schématu bankovního systému a vytvořit základ pro budoucí testování API a QA aktivity.
