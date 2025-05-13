package com.mocanu.clean_tests_presentation._1_unclear_test._5_execute.multiple

object PersonFixture {

    private val personRepository = PersonRepository()

    fun givenThePersonTableContainsASingleValidPerson() {
        personRepository.deleteAllCascade()
        personRepository.insert(aValidPerson())
    }

    fun givenThePersonTableContainsThePersons(
        persons: List<Person>,
    ) {
        personRepository.deleteAllCascade()
        persons.forEach {
            personRepository.insert(it)
        }
    }

}
