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

    @Test
    fun `should update the name correctly`() {
        val customer: Customer = aValidCustomer()
            .copy(name = "Old Name")

        CustomerFixture.givenASingleCustomerInTheDatabase(customer)

        CustomerRepository.updateName(
            id = customer.id,
            newName = "New Name",
        )

        assertThat(CustomerRepository.getById(customer.id).id)
            .isEqualTo(customer.id)
        assertThat(CustomerRepository.getById(customer.id).name)
            .isEqualTo("New Name")
        assertThat(CustomerRepository.getById(customer.id).age)
            .isEqualTo(customer.age)
        assertThat(CustomerRepository.getById(customer.id).address.countryCode)
            .isEqualTo(customer.address.countryCode)
        assertThat(CustomerRepository.getById(customer.id).address.province)
            .isEqualTo(customer.address.province)
        assertThat(CustomerRepository.getById(customer.id).address.city)
            .isEqualTo(customer.address.city)
        assertThat(CustomerRepository.getById(customer.id).address.postCode)
            .isEqualTo(customer.address.postCode)
        assertThat(CustomerRepository.getById(customer.id).address.streetLine)
            .isEqualTo(customer.address.streetLine)
        assertThat(CustomerRepository.getById(customer.id).accountBalanceEuroCents)
            .isEqualTo(customer.accountBalanceEuroCents)
    }

}
