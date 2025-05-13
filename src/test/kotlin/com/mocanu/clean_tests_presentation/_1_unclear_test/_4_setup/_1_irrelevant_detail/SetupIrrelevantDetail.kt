package com.mocanu.clean_tests_presentation._1_unclear_test._4_setup._1_irrelevant_detail

import com.mocanu.clean_tests_presentation._1_unclear_test._4_setup._1_too_much.Account
import com.mocanu.clean_tests_presentation._1_unclear_test._4_setup._1_too_much.Address
import com.mocanu.clean_tests_presentation._1_unclear_test._4_setup._1_too_much.Customer
import org.assertj.core.api.WithAssertions
import org.junit.jupiter.api.Test

class SetupIrrelevantDetail : WithAssertions {

    // * [tell] the test is a bit hard to follow
    // * [tell] reason: only the account balance is relevant
    // * [tell] use test data builders
    // * [do  ] use `aValidCustomer().copy(accountBalanceEuroCents = -1)`
    // * [tell] test data builders also prevent setup code duplication;
    //          duplication = maintenance burden when the Customer model changes

    @Test
    fun `should detect_overdrawn_accounts`() {
        val customer = Customer(
            id = 1,
            name = "John Doe",
            age = 21,
            address = Address(
                countryCode = "NL",
                province = "North Holland",
                city = "Amsterdam",
                postCode = "1072 AT",
                streetLine = "Ruysdaelkade 174",
            ),
            accountBalanceEuroCents = -1,
        )

        val account = Account(customer)

        assertThat(account.isOverdrawn())
            .isTrue()
    }

}
