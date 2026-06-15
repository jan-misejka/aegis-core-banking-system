# SQL Úlohy

## Level 1 - Základní SELECT

### EX001
Vypiš všechny klienty.

**Tabulka:** clients

---
### EX002
Vypiš jméno a příjmení všech klientů.

**Tabulka:** clients

---
### EX003
Vypiš všechny účty.

**Tabulka:** accounts

---
### EX004
Vypiš pouze:
* account_id
* iban
* balance
* 
z tabulky accounts.

---
### EX005
Vypiš všechny platební karty.

**Tabulka:** cards

---
### EX006
Vypiš všechny transakce.

**Tabulka:** transactions

---
### EX007
Vypiš všechny převody.

**Tabulka:** transfers

---
### EX008
Vypiš všechny emailové adresy klientů.

**Tabulka:** clients

---
### EX009
Vypiš všechny IBANy.

**Tabulka:** accounts

---
### EX010
Vypiš všechny typy účtů.

**Tabulka:** accounts

---

## Level 2 - WHERE

### EX011
Najdi klienta se jménem Jan.

---
### EX012
Najdi klienta s příjmením Novák.

---
### EX013
Najdi účet s IBAN:

CZ6508000000000000000001

---
### EX014
Vypiš všechny CURRENT účty.

---
### EX015
Vypiš všechny SAVINGS účty.

---
### EX016
Najdi účty se zůstatkem vyšším než 100000.

---
### EX017
Najdi účty se zůstatkem nižším než 5000.

---
### EX018
Vypiš všechny ACTIVE karty.

---
### EX019
Vypiš všechny BLOCKED karty.

---
### EX020
Vypiš všechny EXPIRED karty.

---
### EX021
Najdi všechny COMPLETED převody.

---
### EX022
Najdi všechny FAILED převody.

---
### EX023
Najdi všechny PENDING převody.

---
### EX024
Najdi všechny transakce typu DEPOSIT.

---
### EX025
Najdi všechny transakce typu WITHDRAWAL.

---
### EX026
Najdi všechny transakce typu INBOUND.

---
### EX027
Najdi všechny transakce typu OUTBOUND.

---
### EX028
Najdi převody s částkou vyšší než 10000.

---
### EX029
Najdi převody s částkou mezi 1000 a 5000.

---
### EX030
Najdi klienty, kteří mají vyplněné telefonní číslo.

---

## Level 3 - ORDER BY

### EX031
Vypiš všechny klienty seřazené podle příjmení vzestupně.

---
### EX032
Vypiš všechny klienty seřazené podle příjmení sestupně.

---
### EX033
Vypiš všechny účty seřazené podle zůstatku od nejvyššího.

---
### EX034
Vypiš všechny účty seřazené podle zůstatku od nejnižšího.

---
### EX035
Najdi 5 účtů s nejvyšším zůstatkem.

---
### EX036
Najdi 5 účtů s nejnižším zůstatkem.

---
### EX037
Vypiš všechny převody seřazené podle částky od nejvyšší.

---
### EX038
Vypiš všechny převody seřazené podle částky od nejnižší.

---
### EX039
Najdi největší převod v systému.

---
### EX040
Najdi nejmenší převod v systému.

---
### EX041
Vypiš všechny transakce seřazené podle částky od nejvyšší.

---
### EX042
Vypiš všechny transakce seřazené podle částky od nejnižší.

---
### EX043
Najdi největší vklad (DEPOSIT).

---
### EX044
Najdi největší výběr (WITHDRAWAL).

---
### EX045
Vypiš všechny karty seřazené podle data expirace od nejbližší expirace.

---
### EX046
Vypiš všechny karty seřazené podle data expirace od nejvzdálenější expirace.

---
### EX047
Najdi kartu s nejbližší expirací.

---
### EX048
Najdi nejstarší účet podle created_at.

---
### EX049
Najdi nejnovější účet podle created_at.

---
### EX050
Vypiš všechny převody seřazené podle data vytvoření od nejnovějších.

---

## Level 4 - Agregační Funkce

### EX051
Zjisti celkový počet klientů.

---
### EX052
Zjisti celkový počet účtů.

---
### EX053
Zjisti celkový počet platebních karet.

---
### EX054
Zjisti celkový počet transakcí.

---
### EX055
Zjisti celkový počet převodů.

---
### EX056
Zjisti počet CURRENT účtů.

---
### EX057
Zjisti počet SAVINGS účtů.

---
### EX058
Zjisti počet ACTIVE karet.

---
### EX059
Zjisti počet BLOCKED karet.

---
### EX060
Zjisti počet EXPIRED karet.

---
### EX061
Zjisti počet COMPLETED převodů.

---
### EX062
Zjisti počet FAILED převodů.

---
### EX063
Zjisti počet PENDING převodů.

---
### EX064
Zjisti součet všech zůstatků na účtech.

---
### EX065
Zjisti průměrný zůstatek účtu.

---
### EX066
Zjisti nejvyšší zůstatek účtu.

---
### EX067
Zjisti nejnižší zůstatek účtu.

---
### EX068
Zjisti celkový objem všech převodů.

---
### EX069
Zjisti průměrnou částku převodu.

---
### EX070
Zjisti nejvyšší částku převodu.

---
### EX071
Zjisti nejnižší částku převodu.

---
### EX072
Zjisti celkovou částku všech DEPOSIT transakcí.

---
### EX073
Zjisti celkovou částku všech WITHDRAWAL transakcí.

---
### EX074
Zjisti průměrnou částku DEPOSIT.

---
### EX075
Zjisti průměrnou částku WITHDRAWAL.

---

## Level 5 - GROUP BY

### EX076
Zjisti počet účtů podle account_type.

---
### EX077
Zjisti počet karet podle card_status.

---
### EX078
Zjisti počet převodů podle transfer_status.

---
### EX079
Zjisti počet transakcí podle tx_type.

---
### EX080
Zjisti součet zůstatků podle account_type.

---
### EX081
Zjisti průměrný zůstatek podle account_type.

---
### EX082
Zjisti nejvyšší zůstatek podle account_type.

---
### EX083
Zjisti nejnižší zůstatek podle account_type.

---
### EX084
Zjisti součet převodů podle transfer_status.

---
### EX085
Zjisti průměrnou částku převodu podle transfer_status.

---
### EX086
Zjisti počet transakcí na jednotlivých účtech.

---
### EX087
Zjisti součet částek transakcí na jednotlivých účtech.

---
### EX088
Zjisti počet karet na jednotlivých účtech.

---
### EX089
Zjisti počet účtů jednotlivých klientů.

---
### EX090
Zjisti celkový zůstatek jednotlivých klientů.

---
### EX091
Zjisti počet příchozích (INBOUND) transakcí podle účtu.

---
### EX092
Zjisti počet odchozích (OUTBOUND) transakcí podle účtu.

---
### EX093
Zjisti součet DEPOSIT transakcí podle účtu.

---
### EX094
Zjisti součet WITHDRAWAL transakcí podle účtu.

---
### EX095
Zjisti počet převodů podle zdrojového účtu.

---

## Level 6 - JOINy
## Level 7 - Pokročilejší Reporting queries