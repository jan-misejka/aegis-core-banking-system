# Business požadavky

## Rozsah systému

Systém představuje zjednodušenou platformu pro správu osobního bankovnictví.

## Případy užití

### UC001 – Vytvoření klienta

Bankovní pracovník vytvoří nového klienta.

### UC002 – Založení účtu

Bankovní pracovník založí účet existujícímu klientovi.

### UC003 – Vklad peněz

Na účet jsou vloženy peníze.

### UC004 – Výběr peněz

Z účtu jsou vybrány peníze.

### UC005 – Převod peněz

Peníze jsou převedeny mezi dvěma účty.

### UC006 – Vydání platební karty

K účtu je vydána platební karta.

### UC007 – Blokace platební karty

Platební karta je zablokována.

## Business pravidla

- Účet musí patřit konkrétnímu klientovi.
- Transakce musí být přiřazena ke konkrétnímu účtu.
- Převod musí mít zdrojový a cílový účet.
- Zablokovanou kartu nelze použít.
- Zůstatek na účtu nesmí být záporný, pokud není implementována podpora kontokorentu.