package com.mocanu.clean_tests_presentation._2_time_consuming_maintenance._1_flaky_tests._2_accidentally_shared_fixture._1_global_static_state

import com.mocanu.clean_tests_presentation._1_unclear_test._5_execute.multiple.Person

class PersonService {

    fun insert(person: Person) = PersonDatabase.insert(person)

    fun getCount(): Int = PersonDatabase.getCount()

    fun deleteAll() = PersonDatabase.deleteAll()

}
