package com.mocanu.clean_tests_presentation._2_time_consuming_maintenance._1_flaky_tests._2_accidentally_shared_fixture._1_global_static_state

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
