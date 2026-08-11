# Business požadavky

## Rozsah systému

Systém představuje zjednodušenou platformu pro správu osobního bankovnictví.

## Případy užití

### UC001 – Vytvoření klienta
Bankovní pracovník vytvoří nového klienta.
**Stav:** ✅ Dokončeno

**Implementováno:**

- POST /clients
- GET /clients
- GET /clients/{id}
- PUT /clients/{id}
- DELETE /clients/{id}

**Ověření:**

- Manuální testování v Postman.
- Ověření dat v DBeaver.
- CRUD funkcionalita dokončena.

### UC002 – Založení účtu
Bankovní pracovník založí účet existujícímu klientovi.
**Stav:** ⏳ Plánováno

**Předpoklady implementace:**

- Dokončený Project Review #1
- Implementovaný TECH-001
- Implementovaný TECH-002

### UC003 – Vklad peněz
Na účet jsou vloženy peníze.
**Stav:** ⏳ Plánováno

### UC004 – Výběr peněz
Z účtu jsou vybrány peníze.
**Stav:** ⏳ Plánováno

### UC005 – Převod peněz
Peníze jsou převedeny mezi dvěma účty.
**Stav:** ⏳ Plánováno

### UC006 – Vydání platební karty
K účtu je vydána platební karta.
**Stav:** ⏳ Plánováno

### UC007 – Blokace platební karty
Platební karta je zablokována.
**Stav:** ⏳ Plánováno

## Business pravidla

- Účet musí patřit konkrétnímu klientovi.
- Transakce musí být přiřazena ke konkrétnímu účtu.
- Převod musí mít zdrojový a cílový účet.
- Zablokovanou kartu nelze použít.
- Zůstatek na účtu nesmí být záporný, pokud není implementována podpora kontokorentu.

---

# Implementační pořadí

Business Use Casy jsou implementovány postupně.

Po dokončení každého Use Casu následuje:
1. Project Review.
2. Aktualizace dokumentace.
3. Aktualizace Technical Backlog.
4. Implementace položek označených jako High Priority.
5. Zahájení dalšího Use Casu.

Podrobný vývojový postup je popsán v dokumentu:

`DEVELOPMENT_WORKFLOW.md`