package com.mocanu.clean_tests_presentation._1_unclear_test._6_verify._4_irrelevant_detail

import com.mocanu.clean_tests_presentation._1_unclear_test._4_setup._1_too_much.Customer
import com.mocanu.clean_tests_presentation._1_unclear_test._4_setup._1_too_much.CustomerRepository

object CustomerFixture {

    fun givenASingleCustomerInTheDatabase(
        customer: Customer,
    ) {
        CustomerRepository.deleteAllCascade()
        CustomerRepository.insert(customer)
    }

}
