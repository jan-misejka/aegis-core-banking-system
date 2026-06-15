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
## Validace převodů mezi účty
## Validace karet
## Sada Regresních Testů