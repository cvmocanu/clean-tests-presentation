# Ideas
* code smells & fixes
  * false positives
    * flaky tests (especially multi-threaded tests)
      * multi-threaded (e.g. Thread.sleep()) -> proper locking or, even better, test just the sync part of the code
      * shared fixture + parallel tests
      * accidentally shared fixture - execution order of tests matters
    * mocks / testing a particular implementation: cripples your refactoring => Test behavior, not internals
      * mock only at the system boundaries - e.g. mock an HTTP API, since that is not an implemention detail, it's a contract you have with other teams
  * false negatives
    * over-reliance of mocks - e.g. you're testing with an H2 in-memory database with Postgres compatibility mode, but Postgres in prod; your tests pass, but a query breaks in production => test as much as possible similar to prod (e.g. Postgres inside docker)
  * shared fixture - couples tests with each other, making it difficult to change one test without braking another
  * unclear test
    * too much setup 
      * use test data builders
      * use fixture builders
    * too many calls to the SUT -> what is being tested? should do a single call
    * multiple assertions per test (what are we actually testing?)
    * too much assertion code -> encapsulate assertion code
    * irrelevant detail
    * should be: setup, call SUT, assert
  * duplication (setup, assertions) -> extract test infra code (test data builders, custom assertions)
* cherry-on-the-cake: Kotlin DSL
* single most important take away: treat test code with the same care as production code, including refactoring, creating abstractions, etc. - do anything that is needed to make the tests easy to understand

* Testing multiple concerns in one test
  * Consequence: Unclear failure causes.
  * Fix: Split into separate tests.
* missing cleanup (e.g. global static state)
  * Consequence: Intermittent failures. (e.g. the test passes when it's run together with the rest, but fails in isolation)
  * Fix: Reset or isolate state per test.
  * even better fix: change prod code to no longer rely on global state
* missing cleanup (e.g. DB records), order of tests matter
  * Consequence: State leaks between tests.
  * recommend: cleanup before the test, to be able to inspect the DB after a test failure
    * if you use Spring Boot, avoid `@Transactional` tests (no way to see the DB state after a failure)
* shared DB fixture
  * on purpose: to save time writing test code
  * accidental: depending on DB state configured by previously executed tests
    * execution order of tests matter
* relying on system time / clock
  * Consequence: Non-deterministic tests (slow CI/CD, daylight saving changes, slow test, etc.)
  * Fix: Use time abstraction/mockable clock.
* Tests require network access
  * Consequence: Fail offline, slow.
  * Fix: Mock network calls. (e.g. normal mocks + wiremock)
* unclear failure
  * when the test fails
    * it's not clear what went wrong
    * or it's not clear why it went wrong (e.g. what do I do now to fix this?)
  * fix: for every test, intentionally make it fail (e.g. by having a wrong expected result), and make sure you're happy with the result
    * add assertion messages, including any needed debug information

* Assertions on irrelevant details
  * Consequence: Tests break unnecessarily.
  * Fix: Assert only on observable, relevant behavior.

* Unclear boundaries between setup, execution, and verification
  * Consequence: Cognitive load increases.
  * Fix: Structure tests clearly (Arrange-Act-Assert pattern).

* Monolithic test classes/files
  * Consequence: Hard to find and understand tests.
  * Fix: Split into smaller, focused test classes.
    * => it's not required to have a test class per production class; focus on testing features, not classes


## Principles
* one test per functional requirement (the test name should explain the requirement)
* setup, execute, verify
  * in this order
  * without interleaving, e.g. "setup, execute, verify, execute, verify" is not good
* no irrelevant detail
  * use test data builders
  * use custom assertion
