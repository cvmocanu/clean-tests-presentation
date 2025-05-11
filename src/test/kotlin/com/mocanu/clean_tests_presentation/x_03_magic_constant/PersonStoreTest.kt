package com.mocanu.clean_tests_presentation.x_03_magic_constant

import org.assertj.core.api.WithAssertions
import org.junit.jupiter.api.Test

class PersonStoreTest : WithAssertions {

    // * do: introduce enum instead of hard-coded constants
    // * tell: bad production code affects your tests also

    private val personStore = PersonStore()

    @Test
    fun `changing the name should mark as updated`() {
        assertThat(personStore.state)
            .isEqualTo(0)

        personStore.setName("a name")

        assertThat(personStore.state)
            .isEqualTo(1)
    }

}
