package com.mocanu.clean_tests_presentation.x_01_bad_names

import org.assertj.core.api.WithAssertions
import org.junit.jupiter.api.Test

class MathOperationsTest : WithAssertions {

    // * do: bad test names
    //   > good names
    //   > kotlin names
    // * do: missing test cases (division by zero)

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
