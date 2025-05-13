package com.mocanu.clean_tests_presentation._1_unclear_test._2_bad_test_name

import com.mocanu.clean_tests_presentation.com.mocanu.clean_tests_presentation.old.x_01_bad_names.MathOperations
import org.assertj.core.api.WithAssertions
import org.junit.jupiter.api.Test

class MathOperationsTest : WithAssertions {

    // [tell] test1, test2, ...
    // [tell] the test name should explain the functional requirement
    // [do  ] rename, using kotlin names (e.g. `should add correctly`)
    // [tell] missing test cases (division by zero); always test boundary conditions

    @Test
    fun test1() {
        assertThat(MathOperations.add(2, 3))
            .isEqualTo(5)
    }

    @Test
    fun test2() {
        assertThat(MathOperations.subtract(2, 3))
            .isEqualTo(-1)
    }

    @Test
    fun test3() {
        assertThat(MathOperations.multiply(2, 3))
            .isEqualTo(6)
    }

    @Test
    fun test4() {
        assertThat(MathOperations.divide(7, 3))
            .isEqualTo(2)
    }

}
