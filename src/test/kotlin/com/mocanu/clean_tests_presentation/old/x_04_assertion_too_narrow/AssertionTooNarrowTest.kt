package com.mocanu.clean_tests_presentation.old.x_04_assertion_too_narrow

import com.mocanu.clean_tests_presentation._1_unclear_test._5_execute.too_many.Person
import org.assertj.core.api.WithAssertions
import org.junit.jupiter.api.Test

class AssertionTooNarrowTest : WithAssertions {

    // to: replace with `.isLessThan(0)`

    @Test
    fun `should compare persons - smaller than`() {
        val left = Person("Alex", 13)
        val right = Person("Alex", 14)

        assertThat(Person.Companion.COMPARATOR.compare(left, right))
            .isEqualTo(-1)
    }

}
