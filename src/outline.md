# Outline

## Ideas
* good tests
  * clean test code
  * testable production code (SOLID principles, dependency injection, immutability, etc.)
    * if the production code is not easy to tests, the tests will be bad
  * we won't discuss testable code principles
    * it's important, but we don't have time
* why are tests important?
  * 2 reasons (there are many others)
    * it saves you time (and thus money)
      * automated tests vs manual tests
      * catching bugs early (immediately after you changed the code) reduces debugging time (you know what you just changed), compared to lengthy debugging, for a customer-reported bug
      * you can refactor fearlessly - you have a safety net, that will tell you fast if you broke anything (as opposed to reading a lot of code to sure that every little change is safe - it doesn't break anything)
    * it's fun
        * knowing you have a safety net, and you can refactor without care, makes programming much more enjoyable
* bad tests don't have these benefits
  * no time saving
    * false positives - the test fails even if the production code is still correct
    * hard to understand
* what makes a good test?
* code smells & fixes
  * false positives
    * flaky tests (especially multi-threaded tests)
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
* single most important take away: treat test code with the same care as production code, including refactoring, creating abstractions, etc. - do anything that is needed to make the tests easy to understand


## Outline
* slides (max 10-15 minutes)
* hands-on refactoring in IntelliJ (the rest of the time)
