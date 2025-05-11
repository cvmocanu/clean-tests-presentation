package com.mocanu.clean_tests_presentation.x_04_assertion_too_narrow

import org.assertj.core.api.WithAssertions
import org.junit.jupiter.api.Test

class AssertionTooNarrowTest : WithAssertions {

    // to: replace with `.isLessThan(0)`

    @Test
    fun `should compare persons - smaller than`() {
        val left = Person("Alex", 13)
        val right = Person("Alex", 14)

        assertThat(Person.COMPARATOR.compare(left, right))
            .isEqualTo(-1)
    }

}
