# Copilot / AI agent instructions for this repo

This file gives concise, actionable guidance for an AI coding agent to be productive in this Java Maven project.

- **Big picture:** small single-module Java CLI app that models a national budget. Core pieces:
  - `Budget.java` — single mutable data holder (many public fields and parallel arrays for ministries).
  - `BudgetManager.java` — CLI logic manipulating `Budget` (display, modify, scenarios). Uses `Scanner` for interactive console input.
  - `Main.java` — program entrypoint and menu loop that calls `BudgetManager`.
  - `Ministry.java` — lightweight POJO (present but not used by main data model).
  - `BudgetManagerTest.java` — unit test that mutates `Budget` fields for deterministic checks.

- **Build / run / test (explicit):**
  - Compile: `mvn clean compile` (requires Java 17)
  - Run tests: `mvn test`  — tests directly modify `Budget` fields for isolation.
  - Run CLI: `mvn compile exec:java -Dexec.mainClass=Main` or after `mvn package` run `java -cp target/classes Main`.

- **Project-specific patterns discovered (use these as examples):**
  - Data model is a mutable, public-field POJO (`Budget.java`). Expect direct field mutation in tests and code (e.g., `testBudget.totalRevenue = 1000.0`).
  - Ministry data is stored in parallel arrays (`ministryRevenue`, `ministryExpenses`, `ministries`) — many methods rely on array lengths matching. When editing, keep these arrays consistent.
  - Tests shorten arrays for simplicity (see `BudgetManagerTest.java`), so unit code must handle variable-length arrays safely.
  - CLI flows (menu-driven) are in `Main.java` and `BudgetManager.java` using `Scanner` for input; avoid changing `Scanner` usage unless converting UI.

- **Conventions & gotchas to respect when editing:**
  - Code comments and messages are in Greek — preserve or mirror language for UI strings unless explicitly internationalizing.
  - There are many public mutable fields; refactors that introduce encapsulation should provide backwards-compatible behavior for tests (tests set fields directly).
  - `pom.xml` defines Java 17 and includes `exec-maven-plugin` (mainClass `Main`). Use `mvn exec:java` to run during development.

- **Quick examples to edit or test small changes:**
  - To run a single test class: `mvn -Dtest=BudgetManagerTest test`
  - To run the CLI locally (recompile and start):
    - `mvn clean compile exec:java -Dexec.mainClass=Main`

- **Where to look first for related changes:**
  - UI/menu changes: `Main.java`, `BudgetManager.java`
  - Data shape/initial values: `Budget.java`
  - Unit example and expected behavior: `BudgetManagerTest.java`

- **When you see failing builds/tests:**
  - Verify `Budget` array lengths and index usage (out-of-bounds often from inconsistent parallel arrays).
  - Check tests that modify `Budget` fields directly — they may rely on reduced-size arrays.

- **Do not assume external integrations:**
  - No external services or network calls; repo is self-contained. Dependencies are only build plugins in `pom.xml`.

- **Next step:** ask the maintainer before large refactors that change the `Budget` public API.

If any section is unclear or you'd like the guidance expanded (e.g., suggested refactors or conventions for new code), tell me which area to iterate on.