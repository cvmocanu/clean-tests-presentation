package com.mocanu.clean_tests_presentation.old.x_02_missing_assertion

import com.mocanu.clean_tests_presentation.old.x_01_bad_names.MathOperations
import org.assertj.core.api.WithAssertions
import org.junit.jupiter.api.Test

class MissingAssertionTest : WithAssertions {

    // do: assertThat(...).isEqualTo(...)
    // do: assertThatCode { ... }.doesNotThrowAnyException()

    @Test
    fun `should add correctly`() {
        MathOperations.add(1, 2)
    }

    @Test
    fun `should not throw an error when dividing by non-zero`() {
        MathOperations.divide(3, 2)
    }

}
