package com.mocanu.clean_tests_presentation.old.x_03_assertion_too_broad

import com.mocanu.clean_tests_presentation.com.mocanu.clean_tests_presentation.old.x_01_bad_names.MathOperations
import org.assertj.core.api.WithAssertions
import org.junit.jupiter.api.Test

class AssertionTooBroadTest : WithAssertions {

    // do: replace with `.isEquals`

    @Test
    fun `should add correctly`() {
        assertThat(MathOperations.add(1, 2))
            .isGreaterThan(0)
    }

}
