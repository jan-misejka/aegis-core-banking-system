# Development Workflow
## Účel dokumentu
Tento dokument definuje standardizovaný způsob práce na projektu Aegis Core Banking System.

Popisuje:
- životní cyklus změny
- plánování práce
- spolupráci s AI
- Git workflow
- testování a ověřování změn
- Project Review
- práci s Technical Backlog
- Definition of Done
- pravidla aktualizace dokumentace

Workflow je závazný pro významné změny projektu.

---

# Životní cyklus změny
Každá významná změna projektu prochází následujícím životním cyklem:
1. Záměr
2. Návrh
3. Provedení
4. Důkaz
5. Review
6. Záznam
7. Git checkpoint

Jednotlivé kroky mohou být podle velikosti změny provedeny v jednom pracovním vlákně nebo rozděleny do více kroků.

---

## 1. Záměr
Cílem je jednoznačně definovat, **co se má udělat a proč**.

### 1.1 Předmět
Definovat:
- co se má změnit
- jakého Use Case nebo technické oblasti se změna týká
- jaký je očekávaný výsledek

### 1.2 Důvod
Definovat:
- proč je změna potřebná
- jaký problém řeší
- jakou hodnotu přináší

### 1.3 Rozsah
Určit:
- co je součástí změny
- co není součástí změny
- jaké části projektu změna ovlivňuje

### 1.4 Kritéria
Definovat podmínky, podle kterých bude možné určit, že je změna dokončena.

### 1.5 Kontext
Před zahájením práce ověřit aktuální stav relevantní dokumentace:

1. `docs/project/CURRENT_STATE.md`
2. `docs/project/ROADMAP.md`
3. `docs/business/BUSINESS_REQUIREMENTS.md`
4. `docs/technical/TECHNICAL_BACKLOG.md`
5. relevantní technickou a testovací dokumentaci

Aegis nepoužívá samostatný `TASK.md`. Záměr je součástí pracovního procesu a nemusí být evidován jako samostatný soubor.

---

## 2. Návrh
Cílem je rozhodnout, **jak bude změna provedena a ověřena**.

### 2.1 Řešení
Navrhnout způsob implementace změny.

### 2.2 Dopady
Určit případné dopady na:
- backend
- databázi
- API
- testy
- testovací data
- dokumentaci

### 2.3 Rizika
Identifikovat:
- možné regresní riziko
- business rizika
- technická rizika
- případný nový technický dluh

### 2.4 Testování
Před implementací určit:
- co bude testováno
- jak bude změna ověřena
- které pozitivní scénáře jsou relevantní
- které negativní scénáře jsou relevantní
- které hraniční scénáře jsou relevantní

### 2.5 Rozdělení
Větší změnu rozdělit na menší části, které lze samostatně implementovat a ověřit.

---

## 3. Provedení
Cílem je provést schválený návrh změny.

### 3.1 Branch
Pro samostatnou funkcionalitu vytvořit vlastní Git Feature Branch.

Doporučené názvy:
```text
feature/uc008-unblock-card
feature/uc009-account-detail
feature/uc010-client-accounts
```

Technické změny:
```text
chore/tech-003-dto-mapping
chore/tech-004-soft-delete
```

Dokumentační změny:
```text
chore/documentation-refactor
```

### 3.2 Implementace
Provést pouze změny odpovídající definovanému rozsahu.

### 3.3 Průběžná kontrola
Během implementace kontrolovat:
- rozsah změny
- konzistenci s návrhem
- případné vedlejší dopady
- vznik nového technického dluhu

### 3.4 Izolace
Velké nebo nesouvisející změny nerozšiřovat do stejného pracovního kroku. Každá změna má představovat logicky uzavřený celek.

---

## 4. Důkaz
Cílem je prokázat, že změna splňuje definované požadavky.

### 4.1 Testy
Spustit relevantní automatizované testy.

### 4.2 Pozitivní
Ověřit očekávané správné chování.

### 4.3 Negativní
Ověřit chybové a zamítnuté scénáře.

### 4.4 Hraniční
Ověřit relevantní boundary conditions.

### 4.5 Databáze
Podle potřeby ověřit výsledný stav databáze pomocí DBeaveru nebo SQL.

### 4.6 Reprodukce
Výsledek ověření musí být možné reprodukovat.

### 4.7 Vysvětlení
Výsledek změny musí být možné vysvětlit bez spoléhání pouze na výstup AI. Důkaz musí vycházet z provedeného testování nebo jiného ověření, nikoliv pouze z předpokladu, že implementace funguje.

---

## 5. Review
Cílem je nezávisle posoudit, zda je změna připravena k uzavření. U dokončeného Use Case je Review označeno jako `PR-XXX`.

Příklad:
```text
PR-009 – Project Review po UC007
```

Project Review je součástí dokončení Use Case. 

Project Review může následovat také po samostatném technickém milníku `TECH-XXX`, pokud tento úkol významně ovlivňuje:
- architekturu
- testování
- infrastrukturu
- budoucí vývoj projektu

---

# Project Review
## 5.1 Implementace
Ověřit:
- implementace odpovídá požadavkům
- změna odpovídá definovanému rozsahu
- nevznikla zbytečná komplexita
- změna nenarušila existující funkcionalitu

## 5.2 Testování
Ověřit:
- relevantní testy byly provedeny
- pozitivní scénáře byly pokryty
- negativní scénáře byly pokryty
- relevantní hraniční scénáře byly pokryty
- výsledky jsou reprodukovatelné
- důkazy odpovídají požadavkům

## 5.3 Databáze
Ověřit:
- databázový stav odpovídá očekávání
- relace jsou zachovány
- business omezení jsou dodržena
- nevznikla nekonzistence dat

## 5.4 Technický dluh
Ověřit:
- nevznikla nová technická položka
- případná nová položka byla zapsána do `TECHNICAL_BACKLOG.md`
- existující technický dluh byl posouzen
- případné High Priority položky byly identifikovány

## 5.5 Dokumentace
Ověřit:
- dokumentace odpovídá aktuálnímu stavu
- změny byly zaznamenány pouze v relevantních dokumentech
- nevznikla zbytečná duplicita
- informace jsou uloženy v dokumentu, kterému podle svého účelu náleží

## 5.6 Rozhodnutí
Na základě Review rozhodnout:
- změna je připravena k uzavření
- změna vyžaduje opravu
- vznikl nový technický dluh
- před dalším Use Casem je nutné vyřešit High Priority položku

---

## 6. Záznam
Cílem je zajistit, aby projektový stav odpovídal skutečnému výsledku práce.

### 6.1 Stav
Aktualizovat:
`docs/project/CURRENT_STATE.md`

Pouze pokud se změnil aktuální stav projektu.

### 6.2 Roadmapa
Aktualizovat:
`docs/project/ROADMAP.md`

Pouze pokud se změnil plánovaný rozsah, pořadí nebo významný milestone.

### 6.3 Business
Aktualizovat:
`docs/business/BUSINESS_REQUIREMENTS.md`

Pouze pokud se změnily business požadavky nebo rozsah systému.

### 6.4 Technický dluh
Aktualizovat:
`docs/technical/TECHNICAL_BACKLOG.md`

Pokud vznikla, změnila se nebo byla uzavřena položka technického dluhu.

### 6.5 Testování
Aktualizovat relevantní QA dokumentaci podle provedeného testování v :
`docs/testing/...`

### 6.6 Changelog
Aktualizovat:
`docs/CHANGELOG.md`

Stručně zaznamenat významnou dokončenou změnu.

### 6.7 Kontrola
Před dokončením záznamu ověřit, že:
- dokumentace odpovídá skutečnému stavu
- stejná informace není zbytečně vedena na více místech
- žádný dokument neobsahuje zastaralou informaci

Dokumentace se aktualizuje pouze tehdy, pokud se její skutečný obsah změnil.

---

## 7. Git checkpoint
Cílem je vytvořit čistý a srozumitelný bod v historii projektu.

### 7.1 Status
Zkontrolovat stav pracovního stromu:
```text
git status
```

### 7.2 Diff
Zkontrolovat provedené změny:
```text
git diff
```

### 7.3 Test
Ověřit, že relevantní testy prošly.

### 7.4 Scope
Ověřit, že commit obsahuje pouze změny související s daným logickým celkem.

### 7.5 Commit
Vytvořit srozumitelný commit.

Příklady:
```text
feat: implement UC008 - unblock card
test: add controller tests for UC008
docs: update documentation after UC008
chore: refactor DTO mapping
```

### 7.6 Merge
Po dokončení změny a Review sloučit branch do `main`.

### 7.7 Verification
Po merge ověřit výsledný stav projektu.

### 7.8 Cleanup
Po úspěšném merge odstranit dokončenou Feature Branch.

---

# Git Workflow
Každá samostatná funkcionalita je implementována ve vlastní Git Feature Branch.

## Doporučený postup
1. **Update** – aktualizovat lokální `main`
2. **Branch** – vytvořit Feature Branch
3. **Plan** – provést návrh změny
4. **Implement** – implementovat změnu
5. **Test** – provést relevantní testování
6. **Verify** – ověřit výsledek a diff
7. **Review** – provést Project Review
8. **Document** – aktualizovat relevantní dokumentaci
9. **Commit** – vytvořit Git checkpoint
10. **Merge** – sloučit branch do `main`
11. **Verify** – ověřit výsledný stav
12. **Cleanup** – odstranit dokončenou branch

Příklad názvů Feature Branch:
```text
feature/uc008-unblock-card
feature/uc009-account-detail
feature/uc010-client-accounts
```

Technické změny:
```text
chore/tech-003-dto-mapping
chore/tech-004-soft-delete
```

Dokumentační změny:
```text
chore/documentation-refactor
```

Project Review je označeno identifikátorem `PR-XXX`. Příklad:
```text
PR-009 – Project Review po UC007
```

---

# Technical Backlog
Technical Backlog obsahuje technická zlepšení projektu. Nové položky vznikají během Project Review.

Backlog je rozdělen podle priorit:

## High Priority
Technický problém, který musí být vyřešen před pokračováním v dalším Use Case.

## Medium Priority
Technický problém, který je vhodné řešit v rámci plánovaného vývoje nebo samostatného refaktoringu.

## Low Priority
Volitelné technické zlepšení bez významného dopadu na aktuální vývoj. 

**High Priority položky musí být před zahájením dalšího Use Case vyřešeny a následně ověřeny.**

Podrobnosti jsou vedeny v:
`docs/technical/TECHNICAL_BACKLOG.md`

---

# Definition of Done
Use Case je považován za dokončený, pokud:
- business požadavky jsou implementovány
- relevantní pozitivní scénáře byly ověřeny
- relevantní negativní scénáře byly ověřeny
- relevantní hraniční scénáře byly ověřeny
- relevantní automatizované testy prošly
- databázový stav byl podle potřeby ověřen
- změna prošla Project Review
- relevantní dokumentace byla aktualizována
- vznikl odpovídající Git checkpoint
- všechny relevantní High Priority položky byly vyřešeny a ověřeny
- změna je připravena k pokračování na další milestone

Teprve poté je Use Case považován za dokončený a může začít další Use Case.

---

# Práce s AI
AI je v projektu pomocný nástroj, nikoliv vlastník projektu.

## AI může
- vysvětlovat technologie
- analyzovat požadavky
- navrhovat řešení
- generovat návrhy kódu
- navrhovat testovací scénáře
- analyzovat chyby
- pomáhat se SQL
- pomáhat s dokumentací
- upozorňovat na možné technické problémy

## Odpovědnost uživatele
Uživatel projektu vlastní:
- scope
- business rozhodnutí
- architekturu
- acceptance criteria
- testovací strategii
- finální review
- ověření výsledku
- rozhodnutí o dokončení změny

AI nenahrazuje tato rozhodnutí.

## Ověření AI výstupu
Každý důležitý výstup vytvořený pomocí AI musí být možné:
- vysvětlit
- ověřit
- reprodukovat
- případně upravit bez závislosti na AI

AI nesmí být jediným zdrojem důkazu, že změna funguje.

## Učební princip
Aegis je současně studijní projekt.

Proto platí:
- porozumění je důležitější než rychlost
- velké změny se dělí na menší ověřitelné části
- před implementací se nejprve rozumí problému
- testování je součást implementace
- důležitá rozhodnutí musí být vysvětlitelná
- AI má urychlovat práci, nikoliv nahrazovat učení

---

# Vztah k ostatní dokumentaci
Jednotlivé dokumenty mají jasně oddělenou odpovědnost:
- `PROJECT_VISION.md` – dlouhodobá vize
- `PROJECT_CONTEXT.md` – stabilní kontext projektu
- `CURRENT_STATE.md` – aktuální stav
- `ROADMAP.md` – plánovaný rozsah a pořadí
- `BUSINESS_REQUIREMENTS.md` – business požadavky
- `TECH_STACK.md` – technologie a nástroje
- `DATABASE_MODEL.md` – databázový model
- `TECHNICAL_BACKLOG.md` – technický dluh
- `DEVELOPMENT_WORKFLOW.md` – způsob práce
- `CHANGELOG.md` – historie významných změn
- `TEST_PLAN.md` – plán testování
- `testing/TESTING.md` – praktická testovací dokumentace
- `jira/BUG_REPORTS.md` – evidence nalezených vad

Informace se nemají kopírovat mezi dokumenty bez důvodu. Každá informace má být vedena především v dokumentu, kterému podle svého účelu náleží.