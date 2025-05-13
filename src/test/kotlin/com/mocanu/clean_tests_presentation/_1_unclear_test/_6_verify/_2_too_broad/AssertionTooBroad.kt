package com.mocanu.clean_tests_presentation._1_unclear_test._6_verify._2_too_broad

import com.mocanu.clean_tests_presentation._1_unclear_test._2_bad_test_name.MathOperations
import org.assertj.core.api.WithAssertions
import org.junit.jupiter.api.Test

class AssertionTooBroad : WithAssertions {

    // [do  ] replace with `.isEquals`

    @Test
    fun `should add correctly`() {
        assertThat(MathOperations.add(1, 2))
            .isGreaterThan(0)
    }

}
