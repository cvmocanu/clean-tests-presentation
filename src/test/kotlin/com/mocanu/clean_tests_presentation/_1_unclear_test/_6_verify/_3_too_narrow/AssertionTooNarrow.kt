package com.mocanu.clean_tests_presentation._1_unclear_test._6_verify._3_too_narrow

import com.mocanu.clean_tests_presentation._1_unclear_test._5_execute.multiple.Person
import com.mocanu.clean_tests_presentation._1_unclear_test._5_execute.multiple.aValidPerson
import org.assertj.core.api.WithAssertions
import org.junit.jupiter.api.Test

class AssertionTooNarrow : WithAssertions {

    // [show] the test
    // [show] the `returns` section of the javadoc of
    //        `Comparator.compare()`
    // [tell] right now, we are testing a particular implementation
    // [do  ] replace with `.isLessThan(0)`

    @Test
    fun `should compare persons - smaller than`() {
        val left: Person = aValidPerson().copy(name = "Alex", age = 13)
        val right: Person = aValidPerson().copy(name = "Alex", age = 14)

        assertThat(Person.COMPARATOR.compare(left, right))
            .isEqualTo(-1)
    }

}
