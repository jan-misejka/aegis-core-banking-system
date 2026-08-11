# Development Workflow

## Účel dokumentu
Tento dokument popisuje standardizovaný postup vývoje projektu Aegis Core Banking System.

Cílem je zajistit jednotný způsob implementace nových funkcionalit, průběžnou aktualizaci dokumentace, řízení technického dluhu a konzistentní Git workflow.

Tento workflow je závazný pro celý projekt.

---

# Životní cyklus Use Case
Každý business Use Case (UC) prochází následujícím životním cyklem:

1. Analýza business požadavku.
2. Vytvoření Git Feature Branch.
3. Implementace funkcionality.
4. Manuální testování (Postman + DBeaver).
5. Aktualizace dokumentace.
6. Commit změn.
7. Merge do větve `main`.
8. Project Review.
9. Implementace položek označených jako High Priority v Technical Backlog.
10. Zahájení dalšího Use Casu.

Žádný nový Use Case nezačíná před dokončením předchozího.

---

# Git Workflow

Každá nová funkcionalita je implementována ve vlastní Git Feature Branch.

Doporučené názvy větví:

```
feature/create-client
feature/get-client
feature/update-client
feature/delete-client
feature/open-account
```

Projekt Review a dokumentační změny jsou prováděny v samostatných větvích typu:

```
chore/project-review-uc001
```

Po dokončení vývoje:

1. Lokální otestování.
2. Aktualizace dokumentace.
3. Commit.
4. Merge do `main`.
5. Odstranění Feature Branch.

---

# Project Review

Po dokončení každého Use Casu probíhá Project Review.

Cílem Project Review je:

- zkontrolovat architekturu projektu,
- ověřit konzistenci dokumentace,
- identifikovat technický dluh,
- aktualizovat Technical Backlog,
- rozhodnout o implementaci položek s vysokou prioritou.

Project Review je považován za součást dokončení Use Casu.

---

# Technical Backlog
Technical Backlog obsahuje technická zlepšení projektu.

Nové položky vznikají během Project Review.

Backlog je rozdělen podle priorit:

## High Priority
Implementuje se bezprostředně po dokončení aktuálního Use Casu.

Typicky:
- Exception Handling
- Bean Validation
- společná infrastruktura projektu

## Medium Priority
Implementuje se po dokončení několika Use Casů nebo během plánovaného refaktoringu.

Typicky:
- odstranění duplicitního kódu,
- architektonické úpravy,
- rozšíření stávajících funkcionalit.

## Low Priority
Volitelná rozšíření projektu.

---

# Definition of Done
Use Case je považován za dokončený pouze tehdy, pokud:

- business funkcionalita je implementována,
- všechny manuální testy v Postmanu prošly,
- data byla ověřena v DBeaveru,
- dokumentace byla aktualizována,
- Feature Branch byla sloučena do větve `main`,
- proběhl Project Review,
- byly implementovány všechny položky označené jako High Priority.

Teprve poté začíná implementace dalšího Use Casu.

## Zahájení práce v novém vlákně

Před návrhem jakékoliv změny je nutné:

1. Prostředovat aktuální projektovou dokumentaci.
2. Určit aktuální milestone podle PROJECT_CONTEXT.md.
3. Ověřit další plánovaný krok v ROADMAP.md.
4. Zkontrolovat BUSINESS_REQUIREMENTS.md.
5. Ověřit, zda není potřeba nejprve implementovat položky označené jako High Priority v TECHNICAL_BACKLOG.md.
6. Navrhnout pouze další logický krok podle DEVELOPMENT_WORKFLOW.md.