# Business požadavky
## Rozsah systému

Systém představuje zjednodušenou platformu pro správu osobního bankovnictví.

## Pravidla pro Use Cases
Každý Use Case musí být definován tak, aby bylo možné jednoznačně určit:

- business účel,
- požadované chování,
- validační pravidla,
- očekávané HTTP chování,
- očekávaný stav databáze,
- pozitivní scénáře,
- negativní scénáře,
- relevantní boundary conditions,
- způsob ověření.

Acceptance criteria musí být dostatečně konkrétní, aby podle nich bylo možné vytvořit testovací scénáře a jednoznačně rozhodnout, zda je Use Case splněn.

Důkaz o splnění požadavku musí vycházet z provedeného testování nebo jiného ověření, nikoliv pouze z předpokladu, že implementace funguje.

## Případy užití
### UC001 – Vytvoření klienta
Bankovní pracovník vytvoří nového klienta.

**Stav:** ✅ Dokončeno

**Požadované chování:**
- systém umožní vytvořit klienta
- systém umožní zobrazit seznam klientů
- systém umožní zobrazit detail klienta
- systém umožní upravit údaje klienta
- systém umožní klienta odstranit

---

### UC002 – Založení účtu
Bankovní pracovník založí účet existujícímu klientovi.

**Stav:** ✅ Dokončeno

**Požadované chování:**
- účet musí být přiřazen existujícímu klientovi
- účet musí mít typ CURRENT nebo SAVINGS
- účet musí mít podporovanou měnu CZK, EUR nebo USD
- počáteční balance účtu je 0
- účet má vytvořen čas založení
- účet má unikátní IBAN

**HTTP chování:**
- 201 Created – účet byl úspěšně vytvořen
- 400 Bad Request – nevalidní vstup nebo nepovolený typ účtu či měna
- 404 Not Found – klient neexistuje

---

### UC003 – Vklad peněz
Na účet jsou vloženy peníze.

**Stav:** ✅ Dokončeno

**Požadované chování:**
- účet musí existovat
- částka musí být větší než 0
- minimální částka vkladu je 0.01
- balance účtu se navýší o vloženou částku
- při vkladu vznikne DEPOSIT transaction
- transaction je přiřazena ke konkrétnímu účtu
- transaction obsahuje datum a čas
- změna balance a vytvoření transaction musí proběhnout jako jedna operace

**HTTP chování:**
- 200 OK – vklad byl úspěšně proveden
- 400 Bad Request – částka je nevalidní
- 404 Not Found – účet neexistuje

---

### UC004 – Výběr peněz
Z účtu jsou vybrány peníze.

**Stav:** ✅ Dokončeno

**Požadované chování:**
- účet musí existovat
- částka musí být větší než 0
- minimální částka výběru je 0.01
- výběr nesmí překročit aktuální balance účtu
- balance účtu se sníží o vybranou částku
- při výběru vznikne WITHDRAWAL transaction
- transaction je přiřazena ke konkrétnímu účtu
- transaction obsahuje datum a čas
- zamítnutý výběr nesmí změnit balance ani vytvořit transaction
- změna balance a vytvoření transaction musí proběhnout jako jedna operace

**HTTP chování:**
- 200 OK – výběr byl úspěšně proveden
- 400 Bad Request – částka je nevalidní nebo není dostatečný balance
- 404 Not Found – účet neexistuje

---

### UC005 – Převod peněz
Peníze jsou převedeny mezi dvěma účty.

**Stav:** ✅ Dokončeno

**Požadované chování:**
- zdrojový účet musí existovat
- cílový účet musí existovat
- zdrojový a cílový účet nesmí být stejný
- částka musí být větší než 0
- minimální částka převodu je 0.01
- zdrojový účet musí mít dostatečný balance
- balance zdrojového účtu se sníží o převáděnou částku
- balance cílového účtu se navýší o převáděnou částku
- vznikne Transfer se stavem COMPLETED
- vznikne OUTBOUND transaction na zdrojovém účtu
- vznikne INBOUND transaction na cílovém účtu
- obě transaction jsou navázány na konkrétní Transfer
- Transfer obsahuje datum a čas vytvoření
- zamítnutý převod nesmí změnit balance ani vytvořit Transfer nebo transaction
- změna balance, vytvoření Transferu a vytvoření transaction musí proběhnout jako jedna operace

**HTTP chování:**
- 201 Created – převod byl úspěšně proveden
- 400 Bad Request – částka je nevalidní, účty jsou stejné nebo není dostatečný balance
- 404 Not Found – zdrojový nebo cílový účet neexistuje

---

### UC006 – Vydání platební karty
K účtu je vydána platební karta.

**Stav:** ✅ Dokončeno

**Požadované chování:**
- karta je vydána k existujícímu účtu
- karta má unikátní 16místné číslo
- nová karta má stav ACTIVE
- karta má datum vytvoření
- karta má datum expirace
- datum expirace je nastaveno na 10 let od data vydání
- k jednomu účtu lze vydat více karet

**HTTP chování:**
- 201 Created – karta byla úspěšně vydána
- 400 Bad Request – accountId je nevalidní nebo chybí
- 404 Not Found – účet neexistuje

---

### UC007 – Blokace platební karty
Platební karta je zablokována.

**Stav:** ✅ Dokončeno

**Požadované chování:**
- karta musí existovat
- kartu ve stavu BLOCKED nelze znovu zablokovat
- kartu ve stavu EXPIRED nelze zablokovat
- karta ve stavu ACTIVE je změněna do stavu BLOCKED
- při blokaci se mění pouze stav karty

**HTTP chování:**
- 200 OK – karta byla úspěšně zablokována
- 400 Bad Request – karta je již zablokována nebo je expirovaná
- 404 Not Found – karta neexistuje

---

### UC008 – Odblokování platební karty

Bankovní pracovník obnoví použití dříve zablokované karty.

**Stav:** ✅ Dokončeno

**Požadované chování:**

- karta musí existovat
- kartu ve stavu BLOCKED lze odblokovat
- karta ve stavu BLOCKED je změněna do stavu ACTIVE
- kartu ve stavu ACTIVE nelze odblokovat
- kartu ve stavu EXPIRED nelze odblokovat
- při odblokování se mění pouze stav karty

**HTTP chování:**

- 200 OK – karta byla úspěšně odblokována
- 400 Bad Request – karta je již aktivní nebo je expirovaná
- 404 Not Found – karta neexistuje

---

### UC009 – Zobrazení detailu účtu
Bankovní pracovník zobrazí účet včetně vlastníka, měny, IBANu a aktuálního zůstatku.

**Stav:** ⏳ Plánováno

---

### UC010 – Zobrazení účtů klienta
Bankovní pracovník zobrazí všechny účty vybraného klienta.

**Stav:** ⏳ Plánováno

---

### UC011 – Zobrazení historie transakcí účtu
Bankovní pracovník zobrazí transakce konkrétního účtu včetně typu, částky, času a vazby na převod.

**Stav:** ⏳ Plánováno

---

### UC012 – Zobrazení detailu převodu
Bankovní pracovník zobrazí převod včetně zdrojového účtu, cílového účtu, částky, stavu a souvisejících transakcí.

**Stav:** ⏳ Plánováno

---

### UC013 – Uzavření účtu
Bankovní pracovník uzavře účet pouze tehdy, pokud neporuší definovaná business pravidla a auditní historii.

**Stav:** ⏳ Plánováno

---

## Business pravidla
- Účet musí patřit konkrétnímu klientovi.
- Transakce musí být přiřazena ke konkrétnímu účtu.
- Převod musí mít zdrojový a cílový účet.
- Zablokovanou kartu nelze použít.
- Zůstatek účtu nesmí být záporný, pokud není implementován kontokorent.