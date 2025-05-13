package com.mocanu.clean_tests_presentation._1_unclear_test._1_unclear_failure

import org.assertj.core.api.WithAssertions
import org.junit.jupiter.api.Test

class UnclearFailure : WithAssertions {

    // * [tell] class name: I would use `ColorsRepositoryTest`
    //
    // * [tell] using WithAssertions from assertj
    //
    // * [tell] for every test, intentionally make it fail
    //          (e.g. by having a wrong expected result),
    //          and make sure you're happy with the result
    // * [do  ] change `blue` -> `bluex`
    // * [do  ] run the test
    // * [tell] it's not clear why the test failed
    // * [do  ] change the code `isTrue` -> `contains`
    // * [do  ] re-run the test
    // * [do  ] fix the test: `bluex` -> `blue`

    private val colorsRepository = ColorsRepository()

    @Test
    fun `should contain the color blue`() {
        assertThat(colorsRepository.getColors().contains("blue"))
            .isTrue()
    }
}
