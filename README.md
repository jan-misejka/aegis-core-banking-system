# Aegis Core Banking System

Aegis Core Banking System is a study and portfolio project simulating the core functionality of a banking information system.

The project combines backend development, relational database design, SQL, REST API, manual API testing and QA documentation around a small banking domain.

It is the first project developed within the broader study workflow, with an emphasis on learning through a complete, evolving software project rather than building isolated exercises.

---

## Project Overview

Aegis models a simplified personal banking system built around five main entities:

- Client
- Account
- Card
- Transfer
- Transaction

The system currently supports basic banking operations such as:

- client management
- account opening
- deposits
- withdrawals
- transfers between accounts
- card issuance
- card blocking

The database model defines the relationships between these entities, including account ownership, cards assigned to accounts, transactions belonging to accounts, transfers between source and target accounts, and transactions linked to transfers. fileciteturn57file18

---

## Current Status

### Implemented

- UC001 – Client Management
- UC002 – Open Account
- UC003 – Deposit Money
- UC004 – Withdraw Money
- UC005 – Transfer Money
- UC006 – Issue Card
- UC007 – Block Card

The project also contains Project Reviews and completed technical tasks associated with the implemented functionality.

### Next

- UC008 – Unblock Card

### Planned

- UC009 – Account Detail
- UC010 – Client Accounts
- UC011 – Transaction History
- UC012 – Transfer Detail
- UC013 – Close Account

The current project state and development plan are maintained separately in the project documentation.

---

## Technology Stack

### Backend

- Java
- Spring Boot
- Spring Data JPA
- Maven

### Database

- MySQL
- DBeaver

### Testing

- JUnit
- Postman
- DBeaver
- Jira
- Excel

### Version Control

- Git
- GitHub

### Development Environment

- IntelliJ IDEA Community
- Windows
- WSL

The project started with the database model and SQL work and was subsequently extended with a Spring Boot backend and REST API. fileciteturn58file0

---

## Architecture

The backend follows a layered architecture:

```text
REST Controller
       ↓
Service
       ↓
Repository
       ↓
JPA / Hibernate
       ↓
MySQL
```

The project uses separate domain entities, DTOs, controllers, services and repository components.

The REST API is used as the main interface for interacting with the banking functionality, while the database remains an important part of functional verification.

---

## REST API

Implemented API functionality currently covers the implemented Use Cases.

Examples include:

```text
POST   /clients
GET    /clients
GET    /clients/{id}
PUT    /clients/{id}
DELETE /clients/{id}

POST   /accounts

POST   /accounts/{accountId}/deposit
POST   /accounts/{accountId}/withdraw

POST   /transfers

POST   /cards

PATCH  /cards/{cardId}/block
```

The Client API was the first REST API functionality implemented and was subsequently extended with the remaining banking Use Cases. fileciteturn58file14

---

## Database

The application uses a relational MySQL database.

The current schema contains:

```text
Client
  │
  └── Account
        ├── Card
        ├── Transaction
        └── Transfer
              └── Transaction
```

The database includes constraints for:

- primary and foreign keys
- unique values
- required fields
- account types
- card statuses
- transaction types
- transfer statuses
- non-negative account balances
- positive transaction and transfer amounts
- different source and target accounts

The reference dataset contains clients, accounts, cards, transfers and transactions representing different business states and scenarios.

Database artefacts are located in:

```text
database/
├── schema.sql
├── test_data.sql
├── test_data_part2.sql
├── test_reset.sql
├── SQL_EXERCISES.md
└── SQL_VALIDATION.md
```

The SQL learning material contains 145 exercises covering SELECT, filtering, sorting, aggregation, GROUP BY, JOINs and more advanced reporting queries.

The SQL validation set covers referential integrity, business rules, transfer/transaction consistency and card validation.

---

## Testing & QA

Testing is performed at both API and database level.

### API testing

Manual API testing is performed using Postman.

Typical verification includes:

- positive scenarios
- negative scenarios
- boundary conditions
- validation of HTTP responses
- verification of resulting database state

### Database verification

DBeaver and SQL are used to verify:

- account balances
- created records
- transaction records
- transfer relationships
- card states
- referential integrity
- business-rule consistency

The project also contains a dedicated automated test environment and database reset mechanism to keep automated tests isolated from development data.

### QA documentation

QA artefacts are maintained in:

```text
docs/qa/
├── TEST_PLAN.md
├── TEST_CASES.md
├── TEST_DATA.md
├── TEST_RUNS.md
├── TRACEABILITY.md
└── RELEASE_ASSESSMENT.md
```

Additional practical testing methodology is maintained in:

```text
testing/TESTING.md
```

Bug reports are maintained separately in:

```text
jira/BUG_REPORTS.md
```

---

## Development Workflow

Development follows an iterative workflow built around individual Use Cases:

```text
Záměr
  ↓
Návrh
  ↓
Provedení
  ↓
Důkaz
  ↓
Review
  ↓
Záznam
  ↓
Git checkpoint
```

Each completed Use Case goes through implementation, testing, verification, documentation and Project Review.

Git is used for feature branches, commits and merges into `main`.

Technical debt identified during Project Reviews is tracked separately in:

```text
docs/technical/TECHNICAL_BACKLOG.md
```

The complete development and Git workflow is documented in:

```text
docs/development/DEVELOPMENT_WORKFLOW.md
```

---

## Repository Structure

```text
aegis-core-banking-system/
│
├── database/
│   ├── schema.sql
│   ├── test_data.sql
│   ├── test_data_part2.sql
│   ├── test_reset.sql
│   ├── SQL_EXERCISES.md
│   └── SQL_VALIDATION.md
│
├── docs/
│   ├── project/
│   ├── business/
│   ├── development/
│   ├── technical/
│   ├── qa/
│   ├── CHANGELOG.md
│   └── README.md
│
├── testing/
│   └── TESTING.md
│
├── postman/
│
├── jira/
│   └── BUG_REPORTS.md
│
├── src/
│
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

---

## Documentation

The project documentation is organized by purpose.

### Project

- [`PROJECT_VISION.md`](docs/project/PROJECT_VISION.md)
- [`PROJECT_CONTEXT.md`](docs/project/PROJECT_CONTEXT.md)
- [`CURRENT_STATE.md`](docs/project/CURRENT_STATE.md)
- [`ROADMAP.md`](docs/project/ROADMAP.md)

### Business

- [`BUSINESS_REQUIREMENTS.md`](docs/business/BUSINESS_REQUIREMENTS.md)

### Development

- [`DEVELOPMENT_WORKFLOW.md`](docs/development/DEVELOPMENT_WORKFLOW.md)

### Technical

- [`TECH_STACK.md`](docs/technical/TECH_STACK.md)
- [`DATABASE_MODEL.md`](docs/technical/DATABASE_MODEL.md)
- [`TECHNICAL_BACKLOG.md`](docs/technical/TECHNICAL_BACKLOG.md)

### QA

- [`TEST_PLAN.md`](docs/qa/TEST_PLAN.md)
- [`TEST_CASES.md`](docs/qa/TEST_CASES.md)
- [`TEST_DATA.md`](docs/qa/TEST_DATA.md)
- [`TEST_RUNS.md`](docs/qa/TEST_RUNS.md)
- [`TRACEABILITY.md`](docs/qa/TRACEABILITY.md)
- [`RELEASE_ASSESSMENT.md`](docs/qa/RELEASE_ASSESSMENT.md)

### Other

- [`TESTING.md`](testing/TESTING.md)
- [`BUG_REPORTS.md`](jira/BUG_REPORTS.md)
- [`CHANGELOG.md`](docs/CHANGELOG.md)

---

## Running the Project

The project uses Maven Wrapper.

### Run the application

Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

Linux / WSL:

```bash
./mvnw spring-boot:run
```

### Run automated tests

Windows:

```powershell
.\mvnw.cmd test
```

Linux / WSL:

```bash
./mvnw test
```

The application requires a configured MySQL database.

The main development database is:

```text
aegiscore_banking
```

Database configuration is defined in:

```text
src/main/resources/application.properties
```

Sensitive credentials are intentionally not documented in the repository.

---

## Project Scope

Aegis currently focuses on a simplified personal banking domain.

The current scope does not include:

- loans
- mortgages
- investments
- branches
- employees
- audit logs
- batch processing
- mainframe integration

These areas are outside the current version of the system.

Future development may extend the project with legacy and mainframe-related concepts.

---

## Technical Debt

Current technical debt is tracked in:

[`TECHNICAL_BACKLOG.md`](docs/technical/TECHNICAL_BACKLOG.md)

The backlog currently contains medium- and low-priority technical improvements, while no High Priority technical debt is currently outstanding.

---

## Project Direction

The project is intentionally developed incrementally.

The current focus is completing the core banking Use Cases and building the associated testing and QA evidence.

Future work will extend the system and its test coverage while keeping the project focused on realistic business-system development rather than turning it into a generic technology showcase.

---

## Author

JM

[GitHub Repository](https://github.com/jan-misejka/aegis-core-banking-system)