package com.mocanu.clean_tests_presentation._1_unclear_test._5_execute.multiple

object PersonFixture {

    fun givenThePersonTableContainsASingleValidPerson() {
        PersonRepository.deleteAllCascade()
        PersonRepository.insert(aValidPerson())
    }

    fun givenThePersonTableContainsThePersons(
        persons: List<Person>,
    ) {
        PersonRepository.deleteAllCascade()
        persons.forEach {
            PersonRepository.insert(it)
        }
    }

}
