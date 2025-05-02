# Outline

## Ideas
* tests are important to allow you to refactor fearlessly
* we won't discuss about testable code (dependency injection, immutability, etc.)
* what makes a good test?
* code smells & fixes
  * mocks / testing a particular implementation: cripples your refactoring
  * bad test names
  * share setup - couples tests with each other, making it difficult to change one test without braking another
  * unclear test
    * too much setup -> use test data builders
    * too many calls to the SUT -> what is being tested? should do a single call
    * multiple assertions (what are we actually testing)
    * too much assertion code -> encapsulate assertion code
    * irrelevant detail
    * should be: setup, call SUT, assert
  * duplication (setup, assertions)
* cherry-on-the-cake: Kotlin DSL
* single most important lesson: treat test code with the same care as production code, including refactoring, creating abstractions, etc. - do anything that is needed to make the tests easy to understand


## Outline
* slides (max 10-15 minutes)
* hands-on refactoring in IntelliJ (the rest of the time)
