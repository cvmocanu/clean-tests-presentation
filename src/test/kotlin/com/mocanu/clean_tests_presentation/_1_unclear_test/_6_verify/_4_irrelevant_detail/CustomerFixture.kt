package com.mocanu.clean_tests_presentation._1_unclear_test._6_verify._4_irrelevant_detail

import com.mocanu.clean_tests_presentation._1_unclear_test._4_setup._1_too_much.Customer
import com.mocanu.clean_tests_presentation._1_unclear_test._4_setup._1_too_much.CustomerRepository

object CustomerFixture {

    private val customerRepository = CustomerRepository()

    fun givenASingleCustomerInTheDatabase(
        customer: Customer,
    ) {
        customerRepository.deleteAllCascade()
        customerRepository.insert(customer)
    }

}
