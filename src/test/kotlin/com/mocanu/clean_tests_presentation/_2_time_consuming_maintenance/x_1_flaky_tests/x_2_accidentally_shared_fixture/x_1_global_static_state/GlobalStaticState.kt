package com.mocanu.clean_tests_presentation._2_time_consuming_maintenance.x_1_flaky_tests.x_2_accidentally_shared_fixture.x_1_global_static_state

import com.mocanu.clean_tests_presentation._1_unclear_test._5_execute.multiple.aValidPerson
import org.assertj.core.api.WithAssertions
import org.junit.jupiter.api.Test

class GlobalStaticState : WithAssertions {

    // [show] and explain the tests
    // [do  ] run the tests, and show how they fail
    // [tell] it's because the first test changes the DB
    //        and the second one picks that up
    // [do  ] quick fix: @BeforeEach: deleteAll
    // [show] the tests now succeed
    // [tell] better alternative - avoid global state
    // [do  ] refactor to use instance-level DB

    private val personService = PersonService()

    @Test
    fun `should have the correct count after one insert`() {
        personService.insert(aValidPerson())

        assertThat(personService.getCount())
            .isEqualTo(1)
    }

    @Test
    fun `should have the correct count after multiple inserts`() {
        personService.insert(aValidPerson())
        personService.insert(aValidPerson())

        assertThat(personService.getCount())
            .isEqualTo(2)
    }

}
