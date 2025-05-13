package com.mocanu.clean_tests_presentation._1_unclear_test._6_verify._1_missing_assertion

import com.mocanu.clean_tests_presentation._1_unclear_test._2_bad_test_name.MathOperations
import org.assertj.core.api.WithAssertions
import org.junit.jupiter.api.Test

class MissingAssertion : WithAssertions {

    // [tell] note that both tests are missing assertions


    // [do  ] assertThat(...).isEqualTo(...)

    @Test
    fun `should add correctly`() {
        MathOperations.add(1, 2)
    }


    // [do  ] assertThatCode { ... }.doesNotThrowAnyException()

    @Test
    fun `should not throw an error when dividing by non-zero`() {
        MathOperations.divide(3, 2)
    }

}
