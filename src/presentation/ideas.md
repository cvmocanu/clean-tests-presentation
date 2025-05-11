# Ideas
* code smells & fixes
  * false positives
    * flaky tests (especially multi-threaded tests)
      * multi-threaded (e.g. Thread.sleep()) -> proper locking or, even better, test just the sync part of the code
      * shared fixture + parallel tests
    * mocks / testing a particular implementation: cripples your refactoring => Test behavior, not internals
  * false negatives
    * over-reliance of mocks - e.g. you're testing with an H2 in-memory database with Postgres compatibility mode, but Postgres in prod; your tests pass, but a query breaks in production => test as much as possible similar to prod (e.g. Postgres inside docker)
  * shared fixture - couples tests with each other, making it difficult to change one test without braking another
  * unclear test
    * too much setup -> use test data builders
    * too many calls to the SUT -> what is being tested? should do a single call
    * multiple assertions per test (what are we actually testing?)
    * too much assertion code -> encapsulate assertion code
    * irrelevant detail
    * should be: setup, call SUT, assert
  * duplication (setup, assertions)
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
* relying on system time / clock
  * Consequence: Non-deterministic tests (slow CI/CD, daylight saving changes, slow test, etc.)
  * Fix: Use time abstraction/mockable clock.
* Tests require manual setup (e.g., prepopulating DB)
  * Consequence: Slows dev cycle, errors prone.
  * Fix: Automate setup/teardown.
* Tests require network access
  * Consequence: Fail offline, slow.
  * Fix: Mock network calls. (e.g. normal mocks + wiremock)
