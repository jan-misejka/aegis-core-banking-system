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

### VAL041
Ověř, že všechny karty mají přiřazen účet.

Expected Result:
0 violations
---
### VAL042
Ověř, že neexistují duplicitní čísla karet.

Expected Result:
0 violations
---
### VAL043
Ověř, že všechny karty mají vyplněné datum expirace.

Expected Result:
0 violations
---
### VAL044
Ověř, že všechny karty mají platný stav.

Expected Result:
0 violations
---
### VAL045
Ověř, že neexistují ACTIVE karty s datem expirace v minulosti.

Expected Result:
0 violations
---
### VAL046
Ověř, že všechny EXPIRED karty mají datum expirace v minulosti.

Expected Result:
0 violations
---
### VAL047
Ověř, že neexistují BLOCKED karty bez účtu.

Expected Result:
0 violations
---
### VAL048
Ověř, že počet ACTIVE karet odpovídá referenčnímu datasetu.

Expected Result:
8
---
### VAL049
Ověř, že počet BLOCKED karet odpovídá referenčnímu datasetu.

Expected Result:
2
---
### VAL050
Ověř, že počet EXPIRED karet odpovídá referenčnímu datasetu.

Expected Result:
2
---
### VAL051
Ověř, že neexistuje účet s více kartami se stejným číslem.

Expected Result:
0 violations
---
### VAL052
Ověř, že každá karta obsahuje neprázdné číslo karty.

Expected Result:
0 violations
---
### VAL053
Ověř, že všechny ACTIVE karty mají datum expirace v budoucnosti.

Expected Result:
0 violations
---
### VAL054
Ověř, že všechny EXPIRED karty jsou označeny stavem EXPIRED.

Expected Result:
0 violations
---
### VAL055
Ověř, že všechny karty jsou navázány na existující účet.

Expected Result:
0 violations

---

## Sada Regresních Testů

### REG001
Ověř celkový počet klientů.

Expected Result:
10
---
### REG002
Ověř celkový počet účtů.

Expected Result:
15
---
### REG003
Ověř celkový počet karet.

Expected Result:
12
---
### REG004
Ověř celkový počet převodů.

Expected Result:
20
---
### REG005
Ověř celkový počet transakcí.

Expected Result:
50
---
### REG006
Ověř, že neexistují účty bez klienta.

Expected Result:
0 violations
---
### REG007
Ověř, že neexistují karty bez účtu.

Expected Result:
0 violations
---
### REG008
Ověř, že neexistují záporné zůstatky.

Expected Result:
0 violations
---
### REG009
Ověř, že FAILED transfery nemají transakce.

Expected Result:
0 violations
---
### REG010
Ověř, že PENDING transfery nemají transakce.

Expected Result:
0 violations
---
### REG011
Ověř, že všechny COMPLETED transfery mají odpovídající INBOUND a OUTBOUND transakce.

Expected Result:
0 violations
---
### REG012
Ověř počet ACTIVE karet.

Expected Result:
8
---
### REG013
Ověř počet BLOCKED karet.

Expected Result:
2
---
### REG014
Ověř počet EXPIRED karet.

Expected Result:
2
---
### REG015
Ověř, že neexistují duplicitní IBANy.

Expected Result:
0 violations