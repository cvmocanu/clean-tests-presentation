package com.mocanu.clean_tests_presentation.x_02_missing_assertion

import com.mocanu.clean_tests_presentation.x_01_bad_names.MathOperations
import org.assertj.core.api.WithAssertions
import org.junit.jupiter.api.Test

class MissingAssertionTest : WithAssertions {

    // do: assertThatCode { ... }.doesNotThrowAnyException()

    @Test
    fun `should not throw an error when dividing by non-zero`() {
        assertThatCode { MathOperations.divide(3, 2) }
            .doesNotThrowAnyException()
    }

}
