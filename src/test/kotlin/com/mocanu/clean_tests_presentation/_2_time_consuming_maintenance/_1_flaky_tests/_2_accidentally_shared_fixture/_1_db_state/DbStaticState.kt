package com.mocanu.clean_tests_presentation._2_time_consuming_maintenance._1_flaky_tests._2_accidentally_shared_fixture._1_db_state

import com.mocanu.clean_tests_presentation._1_unclear_test._5_execute.multiple.aValidPerson
import com.mocanu.clean_tests_presentation._2_time_consuming_maintenance._1_flaky_tests._2_accidentally_shared_fixture._1_global_static_state.PersonService
import org.assertj.core.api.WithAssertions
import org.junit.jupiter.api.Test

class DbStaticState : WithAssertions {

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
