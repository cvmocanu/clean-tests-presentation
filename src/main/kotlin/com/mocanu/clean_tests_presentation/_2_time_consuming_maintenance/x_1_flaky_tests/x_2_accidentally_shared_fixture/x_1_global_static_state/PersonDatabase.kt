package com.mocanu.clean_tests_presentation._2_time_consuming_maintenance.x_1_flaky_tests.x_2_accidentally_shared_fixture.x_1_global_static_state

import com.mocanu.clean_tests_presentation._1_unclear_test._5_execute.multiple.Person

object PersonDatabase {

    private val persons = mutableListOf<Person>()

    fun insert(person: Person) {
        persons += person
    }

    fun getCount() = persons.size

    fun deleteAll() {
        persons.clear()
    }

}
