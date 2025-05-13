package com.mocanu.clean_tests_presentation._1_unclear_test._6_verify._5_too_much_code

import com.mocanu.clean_tests_presentation._1_unclear_test._5_execute.multiple.Person

class PersonListAssertSolution(
    private val actual: List<Person>,
) {


    companion object {
        fun assertThatListOfPersons(
            actual: List<Person>,
        ) = PersonListAssertSolution(actual)
    }
}
