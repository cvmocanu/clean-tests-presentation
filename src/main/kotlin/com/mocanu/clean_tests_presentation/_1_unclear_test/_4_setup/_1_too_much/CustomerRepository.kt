package com.mocanu.clean_tests_presentation._1_unclear_test._4_setup._1_too_much

class CustomerRepository {

    fun insert(customer: Customer) {}

    fun updateName(id: Long, newName: String) {}

    fun getById(id: Long): Customer = TODO()

    fun deleteAllCascade() {}

}
