# SQL Validation

## Validace Referenční Integrity

### VAL001
Ověř, že každý účet patří existujícímu klientovi.

Expected Result:
0 rows
---
### VAL002
Ověř, že každá karta patří existujícímu účtu.

Expected Result:
0 rows
---
### VAL003
Ověř, že každá transakce patří existujícímu účtu.

Expected Result:
0 rows
---
### VAL004
Ověř, že každý zdrojový účet převodu existuje.

Expected Result:
0 rows
---
### VAL005
Ověř, že každý cílový účet převodu existuje.

Expected Result:
0 rows
---
### VAL006
Ověř, že všechny transfer_id použité v transakcích existují v tabulce transfers.

Expected Result:
0 rows
---
### VAL007
Ověř, že neexistují duplicitní emailové adresy klientů.

Expected Result:
0 rows
---
### VAL008
Ověř, že neexistují duplicitní IBANy.

Expected Result:
0 rows
---
### VAL009
Ověř, že neexistují duplicitní čísla karet.

Expected Result:
0 rows
---
### VAL010
Ověř, že všechny povinné cizí klíče obsahují hodnotu.

Expected Result:
0 rows

---

## Validace Business Pravidel

### VAL011
Ověř, že neexistují účty se záporným zůstatkem.

Expected Result:
0 rows
---
### VAL012
Ověř, že neexistují převody s nulovou částkou.

Expected Result:
0 rows
---
### VAL013
Ověř, že neexistují převody se zápornou částkou.

Expected Result:
0 rows
---
### VAL014
Ověř, že neexistují transakce s nulovou částkou.

Expected Result:
0 rows
---
### VAL015
Ověř, že neexistují transakce se zápornou částkou.

Expected Result:
0 rows
---
### VAL016
Ověř, že zdrojový a cílový účet převodu nejsou stejné.

Expected Result:
0 rows
---
### VAL017
Ověř, že všechny účty mají platný typ účtu.

Expected Result:
0 rows
---
### VAL018
Ověř, že všechny karty mají platný stav.

Expected Result:
0 rows
---
### VAL019
Ověř, že všechny transakce mají platný typ.

Expected Result:
0 rows
---
### VAL020
Ověř, že všechny převody mají platný stav.

Expected Result:
0 rows
---
### VAL021
Ověř, že všechny účty používají měnu CZK.

Expected Result:
0 rows
---
### VAL022
Ověř, že neexistují karty bez data expirace.

Expected Result:
0 rows
---
### VAL023
Ověř, že neexistují klienti bez emailové adresy.

Expected Result:
0 rows
---
### VAL024
Ověř, že neexistují účty bez IBANu.

Expected Result:
0 rows
---
### VAL025
Ověř, že neexistují karty bez čísla karty.

Expected Result:
0 rows

---

## Validace převodů mezi účty
## Validace karet
## Sada Regresních Testů