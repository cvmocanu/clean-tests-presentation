package com.mocanu.clean_tests_presentation._1_unclear_test._6_verify._5_too_much_code

import com.mocanu.clean_tests_presentation._1_unclear_test._5_execute.multiple.Person
import com.mocanu.clean_tests_presentation._1_unclear_test._5_execute.multiple.PersonFixture
import com.mocanu.clean_tests_presentation._1_unclear_test._5_execute.multiple.PersonRepository
import com.mocanu.clean_tests_presentation._1_unclear_test._5_execute.multiple.aRandomPerson
import org.assertj.core.api.WithAssertions
import org.junit.jupiter.api.Test

class TooMuchAssertionCode : WithAssertions {

    // * [show] and explain the test
    // * [tell] the SQL query doesn't sort the results,
    //          so the result order is not guaranteed
    // * [do  ] PersonListAssertSolution
    //          - create class
    //          - companion: assertThatListOfPersons(actual: List<Person>)
    //          - member: isEqualIgnoringOrderTo(expected: List<Person>)

    @Test
    fun `should retrieve the list of persons`() {
        val persons: List<Person> = List(10) {
            aRandomPerson()
        }
        PersonFixture.givenThePersonTableContainsThePersons(persons)

        val actualPersons: List<Person> = PersonRepository.getAll()

        val sortedExpected: List<Person> = persons.sortedWith(Person.COMPARATOR)
        val sortedActual: List<Person> = actualPersons.sortedWith(Person.COMPARATOR)

        assertThat(sortedActual)
            .isEqualTo(sortedExpected)
    }

}
