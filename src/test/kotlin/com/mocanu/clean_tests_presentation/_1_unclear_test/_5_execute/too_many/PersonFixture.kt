package com.mocanu.clean_tests_presentation._1_unclear_test._5_execute.too_many

object PersonFixture {

    fun givenThePersonTableContainsASingleValidPerson() {
        PersonRepository.deleteAllCascade()
        PersonRepository.insert(aValidPerson())
    }

}
