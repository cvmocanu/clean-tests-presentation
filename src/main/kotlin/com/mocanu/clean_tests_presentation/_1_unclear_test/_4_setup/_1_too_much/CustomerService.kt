package com.mocanu.clean_tests_presentation._1_unclear_test._4_setup._1_too_much

class CustomerService(
    private val customerRepository: CustomerRepository = CustomerRepository(),
) {

    fun suspend(customer: Customer) {
        customerRepository.updateName(
            id = customer.id,
            newName = SUSPENDED_NAME,
        )
    }

    companion object {
        const val SUSPENDED_NAME = "_suspended"
    }

}
