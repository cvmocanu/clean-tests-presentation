package com.mocanu.clean_tests_presentation._1_unclear_test._6_verify._4_irrelevant_detail

import com.mocanu.clean_tests_presentation._1_unclear_test._4_setup._1_irrelevant_detail.aValidCustomer
import com.mocanu.clean_tests_presentation._1_unclear_test._4_setup._1_too_much.Customer
import com.mocanu.clean_tests_presentation._1_unclear_test._4_setup._1_too_much.CustomerRepository
import org.assertj.core.api.WithAssertions
import org.junit.jupiter.api.Test

class IrrelevantAssertionDetail : WithAssertions {


    // [show] the test
    // [tell] hard to understand what it does
    // [do  ] delete irrelevant assertions

    private val customerRepository = CustomerRepository()

    @Test
    fun `should update the name correctly`() {
        val customer: Customer = aValidCustomer()
            .copy(name = "Old Name")

        CustomerFixture.givenASingleCustomerInTheDatabase(customer)

        customerRepository.updateName(
            id = customer.id,
            newName = "New Name",
        )

        val updatedCustomer: Customer = customerRepository.getById(customer.id)
        assertThat(updatedCustomer.id)
            .isEqualTo(customer.id)
        assertThat(updatedCustomer.name)
            .isEqualTo("New Name")
        assertThat(updatedCustomer.age)
            .isEqualTo(customer.age)
        assertThat(updatedCustomer.address.countryCode)
            .isEqualTo(customer.address.countryCode)
        assertThat(updatedCustomer.address.province)
            .isEqualTo(customer.address.province)
        assertThat(updatedCustomer.address.city)
            .isEqualTo(customer.address.city)
        assertThat(updatedCustomer.address.postCode)
            .isEqualTo(customer.address.postCode)
        assertThat(updatedCustomer.address.streetLine)
            .isEqualTo(customer.address.streetLine)
        assertThat(updatedCustomer.accountBalanceEuroCents)
            .isEqualTo(customer.accountBalanceEuroCents)
    }

}
