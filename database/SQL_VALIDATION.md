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

### VAL026
Ověř, že každý COMPLETED transfer má alespoň jednu OUTBOUND transakci.

Expected Result:
0 violations
---
### VAL027
Ověř, že každý COMPLETED transfer má alespoň jednu INBOUND transakci.

Expected Result:
0 violations
---
### VAL028
Ověř, že každý COMPLETED transfer má přesně dvě související transakce.

Expected Result:
0 violations
---
### VAL029
Ověř, že všechny transakce navázané na COMPLETED transfer mají stejnou částku jako transfer.

Expected Result:
0 violations
---
### VAL030
Ověř, že FAILED transfery nemají vytvořené žádné transakce.

Expected Result:
0 violations
---
### VAL031
Ověř, že PENDING transfery nemají vytvořené žádné transakce.

Expected Result:
0 violations
---
### VAL032
Ověř, že každý transfer obsahuje zdrojový účet.

Expected Result:
0 violations
---
### VAL033
Ověř, že každý transfer obsahuje cílový účet.

Expected Result:
0 violations
---
### VAL034
Ověř, že částka transferu je větší než nula.

Expected Result:
0 violations
---
### VAL035
Ověř, že neexistuje transfer bez stavu.

Expected Result:
0 violations
---
### VAL036
Ověř, že všechny OUTBOUND transakce odkazující na transfer mají účet shodný se zdrojovým účtem transferu.

Expected Result:
0 violations
---
### VAL037
Ověř, že všechny INBOUND transakce odkazující na transfer mají účet shodný s cílovým účtem transferu.

Expected Result:
0 violations
---
### VAL038
Ověř, že počet INBOUND transakcí odpovídá počtu OUTBOUND transakcí pro COMPLETED transfery.

Expected Result:
0 violations
---
### VAL039
Ověř, že neexistují transakce odkazující na FAILED transfer.

Expected Result:
0 violations
---
### VAL040
Ověř, že neexistují transakce odkazující na PENDING transfer.

Expected Result:
0 violations

---

## Validace karet
## Sada Regresních Testů