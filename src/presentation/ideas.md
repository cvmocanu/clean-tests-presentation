# Ideas
* code smells & fixes
  * unclear test
    * unclear failure
      * when the test fails, it's not clear why it went wrong (e.g. what do I do now to fix this?)
      * fix: for every test, intentionally make it fail (e.g. by having a wrong expected result), and make sure you're happy with the result
        * add assertion messages, including any needed debug information
    * bad test name
    * aggregate test - testing multiple concerns in one test
      * Consequence: Unclear failure causes.
      * Fix: Split into separate tests.
    * setup
      * irrelevant detail + duplication
        * use test data builders / fixture builders
    * execute
      * too many calls to the SUT -> what is being tested? should do a single call
        * split to multiple tests
        * or extract fixture utility
    * verify
      * missing assertion
      * too broad
      * too narrow
      * irrelevant detail
      * too much assertion code
        * encapsulate assertion code (custom assertions)
  * time-consuming maintenance
    * flaky tests
      * accidentally shared fixture - execution order of tests matters
        * DB state
          * fix: reset/cleanup **before** the test, to be able to inspect the DB after a test failure
            * if you use Spring Boot, avoid `@Transactional` tests (no way to see the DB state after a failure)
    * intentionally shared fixture
      * usually done on purpose: to save time writing test code
      * couples tests with each other, making it difficult to change one test without braking another one
    * mocks
      * missing tests for mocked code (own code)
        * if you mock your repository/DAO classes to test your services, don't forget to also test your repository classes
        * alternatively, if your DB queries change a lot, consider your repository/DAO classes an implementation detail, and test your services with a real database
      * testing a particular implementation: cripples your refactoring => Test behavior, not internals
        * mock only at the system boundaries - e.g. mock an HTTP API, since that is not an implementation detail, it's a contract you have with other teams
          * if you mock an HTTP client class, to test your services, don't forget to test your HTTP client class also, using e.g. wiremock
        * in addition, when using e.g. Mockito to create stubs, make sure you configure the stubs to be lenient (don't break the test if the stub wasn't called)
      * wrong mock for code you don't own - e.g. when mocking a 3rd party API, but your mock is behaving differently from the actual API
* cherry-on-the-cake: Java & Kotlin DSL
* single most important take away: treat test code with the same care as production code, including refactoring, creating abstractions, etc. - do anything that is needed to make the tests easy to understand

## Principles
* one test per functional requirement (the test name should explain the requirement)
* setup, execute, verify
  * in this order
  * without interleaving, e.g. "setup, execute, verify, execute, verify" is not good
* no irrelevant detail
  * use test data builders
  * use custom assertion
